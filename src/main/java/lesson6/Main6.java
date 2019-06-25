package lesson6;

public class Main6 {

    private static int countFalseAdding = 0;
    private static int countBalanced = 0;

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            Tree<Integer> tree = new TreeImpl<>();
            while(tree.size() <= Math.pow(2, tree.getTreeDeep()) - 2){
                if(tree.add((int)(Math.random() * 25))){
                    countFalseAdding = 0;
                } else {
                    countFalseAdding++;
                }
                if(countFalseAdding > 100){
                    break;
                }
            }
            tree.traverse(Tree.TraverseMode.IN_ORDER);
            if(tree.isBalanced()){
                System.out.println("Balanced");
                countBalanced++;
            } else {
                System.out.println("Not balanced");
            }
            tree.display();

        }
        System.out.println("percent balanced  = " + countBalanced * 5 + "%");

    }

    private static void testTree() {
        Tree<Integer> tree = new TreeImpl<>();
        tree.add(60);
        tree.add(50);
        tree.add(66);
        tree.add(70);
        tree.add(67);
        tree.add(81);
        tree.add(40);
        tree.add(31);
        tree.add(45);
        tree.add(55);
        tree.add(57);

        System.out.println("Root is 60: " + tree.find(60));
        System.out.println("Find 70: " + tree.find(70));
        System.out.println("Find 31: " + tree.find(31));
        System.out.println("Find 555: " + tree.find(555));

        tree.traverse(Tree.TraverseMode.IN_ORDER);
    }
}
