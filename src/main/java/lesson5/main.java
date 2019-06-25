package lesson5;

public class main {
    public static void main(String[] args) {
        System.out.println(Pow.calc(2, 10));
        System.out.println(Pow.calc(2, -10));
        System.out.println(Pow.calc(2, 0));


        Bag bag = new Bag(
                1,
                new Thing("book", 1, 600),
                new Thing("binoculars", 2, 5000),
                new Thing("medicalKit", 4, 1500),
                new Thing("laptop", 2, 40000),
                new Thing("boiler", 1, 500));

        for (int i = 0; i < 13; i++) {
            bag.setWeight(i);
            bag.getOptimalSet();
        }


    }

}
