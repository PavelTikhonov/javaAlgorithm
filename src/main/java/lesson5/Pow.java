package lesson5;

public class Pow {
    static int initialDegree;
    static int degree;
    static double result;

    public static double calc(double number, int degr){
        result = number;
        initialDegree = degr;
        degree = Math.abs(initialDegree);
        return initialDegree > 0 ? calc() : 1 / calc();
    }

    private static double calc(){
        if(--degree < 0){
            return 1;
        }
        result *= calc();
        return result;
    }
}
