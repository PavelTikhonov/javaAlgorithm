package lesson7;

public class Main7 {

    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Липецк");
        graph.addVertex("Воронеж");
        graph.addVertex("Рязань");
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");
        graph.addVertex("Калуга");
        graph.addVertex("Орел");
        graph.addVertex("Курск");

        graph.addEdges("Москва", "Тула", "Рязань", "Калуга");
//        graph.addEdges("Рязань",  "Воронеж");
        graph.addEdges("Тула",  "Липецк");
        graph.addEdges("Липецк", "Воронеж");
        graph.addEdges("Рязань",  "Тамбов");
        graph.addEdges("Тамбов", "Саратов");
        graph.addEdges("Саратов", "Воронеж");
        graph.addEdges("Калуга", "Орел");
        graph.addEdges("Орел", "Курск");
        graph.addEdges("Курск", "Воронеж");


        graph.display();
        graph.bfs("Москва", "Воронеж");
        graph.bfs("Москва");
        graph.displayJourney();

    }



}
