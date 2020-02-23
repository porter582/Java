package edu.weber;

import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {

        Fruit apple = new Apple();
        Fruit banana = new Banana();
        Fruit watermelon = new Watermelon();

        HashSet<Fruit> fruitSet = new HashSet<>();
        fruitSet.add(apple);
        fruitSet.add(watermelon);
        System.out.println(fruitSet);
        fruitSet.add(banana);
        System.out.println(fruitSet);

        fruitSet.add(apple);
        System.out.println(fruitSet);

        fruitSet.add(null);
        System.out.println(fruitSet);

        fruitSet.remove(apple);
        System.out.println(fruitSet);
        fruitSet.remove(null);
        System.out.println(fruitSet);
        System.out.println(fruitSet.size());
    }
}
