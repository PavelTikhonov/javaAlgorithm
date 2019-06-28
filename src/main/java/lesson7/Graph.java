package lesson7;

import java.util.*;

public class Graph {

    private final List<Vertex> vertexList;
    private final boolean[][] adjMat;
    private int size;

    List<Vertex> journeys;


    public Graph(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMat = new boolean[maxVertexCount][maxVertexCount];
        this.journeys = new ArrayList<>();

    }

    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
        size++;
    }

    public void removeJourneys(){
        if(!journeys.isEmpty()){
            journeys.removeAll(journeys);
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return  getSize() == 0;
    }

    public void addEdges(String start, String second, String... others) {
        addEdge(start, second);
        for (String another : others) {
            addEdge(start, another);
        }
    }

    public void addEdge(String start, String finish) {
        int startIndex =  indexOf(start);
        int finishIndex = indexOf(finish);

        if (startIndex == -1 || finishIndex == -1) {
            throw new IllegalArgumentException("Invalid label for vertex");
        }

        adjMat[startIndex][finishIndex] = true;
        adjMat[finishIndex][startIndex] = true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < size; i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    private void displayVertex(Vertex vertex) {
        System.out.println(vertex);
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < size; j++) {
                if (adjMat[i][j]) {
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }

    /**
     * англ. Depth-first search, DFS
     * @param startLabel
     */
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();

        Vertex vertex = vertexList.get(startIndex);
        visitVertex(stack, vertex);

        while ( !stack.isEmpty() ) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            }
            else {
                stack.pop();
            }
        }

        resetVertexState();
    }


    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);
        visitVertex(queue, vertex);

        while ( !queue.isEmpty() ) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertex(queue, vertex);
            }
            else {
                queue.remove();
            }
        }

        resetVertexState();

    }
    /**
     * англ. breadth-first search, BFS
     * @param startLabel
     */
    public void bfs(String startLabel, String finishLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel);
        }

        int finishIndex = indexOf(finishLabel);
        if (finishIndex == -1) {
            throw new IllegalArgumentException("Invalid startLabel: " + finishLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);
        visitVertex(queue, vertex);
        journeys.add(vertex);
        int level = 1;

        while ( true ) {
            vertex = getNearUnvisitedVertex(queue.peek());

            if (vertex != null) {
                visitVertex(queue, vertex);
                vertex.level = level;
                journeys.add(vertex);

                if(vertex.getLabel().equals(finishLabel)){
                    break;
                }
            }
            else {
                level++;
                queue.remove();
            }
        }

        int last = 1;
        while (!vertex.equals(vertexList.get(startIndex))){

            vertex = getNearVisitedVertex(journeys.get(journeys.size() - last));
            while (!vertex.equals(journeys.get(journeys.size() - last - 1))){
                journeys.remove(journeys.size() - last - 1);
            }
            last++;
        }
        resetVertexState();

    }

    private void resetVertexState() {
        for (int i = 0; i < size; i++) {
            vertexList.get(i).setVisited(false);
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex peek) {
        int peekIndex = vertexList.indexOf(peek);
        for (int i = 0; i < size; i++) {
            if (adjMat[peekIndex][i] && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }

        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        displayVertex(vertex);
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
        displayVertex(vertex);
        queue.add(vertex);
        vertex.setVisited(true);
    }

    private Vertex getNearVisitedVertex(Vertex peek) {
        int peekIndex = vertexList.indexOf(peek);
        List<Vertex> cases = new ArrayList<>();
        int quickWay;
        int quickIndex = 0;

        for (int i = 0; i < size; i++) {
            if (adjMat[peekIndex][i] && vertexList.get(i).isVisited()) {
                cases.add(vertexList.get(i));
            }
        }
        if(cases.size() == 1){
            return cases.get(0);
        } else {
            quickWay = cases.get(0).level;

            for (int i = 0; i < cases.size(); i++) {
                if(cases.get(i).level < quickWay){
                    quickWay = cases.get(i).level;
                    quickIndex = i;
                }
            }
            return cases.get(quickIndex);
        }
    }

    public void displayJourney(){
        System.out.print("Кратчайший путь: ");
        for (int i = 0; i < journeys.size() ; i++) {
            System.out.print(journeys.get(i).getLabel());
            if(i < journeys.size() - 1){
                System.out.print(" -> ");
            }
        }
    }
}
