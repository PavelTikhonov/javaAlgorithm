package lesson5;

import java.util.ArrayList;
import java.util.Arrays;

public class Bag {
    int size;
    int[] mask;
    int[] cost;
    int weight;
    ArrayList<Thing> thing;
    int numbSeries;
    int costMax;
    ArrayList<Thing> optimalSet;

    public Bag(int weight, Thing...thing){
        this.size = thing.length;
        mask = new int[size];
        cost = new int[(int) Math.pow(2, size)];
        this.weight = weight;
        this.thing = new ArrayList<>();
        this.thing.addAll(Arrays.asList(thing));
        this.optimalSet = new ArrayList<>();
    }

    public void getNextMask(){
        int n = 0;
        increment(n);
//        System.out.println(Arrays.toString(mask));
    }

    private void increment(int n){
        if (n == size){
            return;
        }
        if (mask[n] != 0) {
            mask[n] = 0;
            increment(n + 1);
        } else {
            mask[n] = 1;
        }
    }

    public void getOpt(){
        int cost;
        int weightThings;
        for (int i = 0; i < this.cost.length; i++) {
            cost = 0;
            weightThings = 0;
            for (int j = 0; j < mask.length; j++) {
                cost += thing.get(j).getCost() * mask[j];
                weightThings += thing.get(j).getWeight() * mask[j];
                if(weightThings <= weight){
                    this.cost[i] = cost;
                    if(this.cost[i] > costMax){
                        costMax = this.cost[i];
                        setOptimalSet();
                        numbSeries = i;
                    }
                }
            }
            getNextMask();
        }
//        System.out.println(costMax + ", " + numbSeries);
    }

    private void setOptimalSet(){
        optimalSet.removeAll(optimalSet);
        for (int i = 0; i < mask.length; i++) {
            if(mask[i] == 1){
                optimalSet.add(thing.get(i));
            }
        }
    }

    public void getOptimalSet(){
        getOpt();
        System.out.print("Weight = " + weight + ", Optimal set: ");
        for (Thing t: optimalSet) {
            System.out.print(t.getName() + ", ");
        }
        System.out.println("cost = " + costMax);
    }

    public void setWeight(int weight){
        if(weight > 0) {
            this.weight = weight;
        }
    }


}
