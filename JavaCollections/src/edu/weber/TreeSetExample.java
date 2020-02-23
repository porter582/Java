package edu.weber;

import java.util.TreeSet;

public class TreeSetExample {

    public static void main(String[] args) {

        Fruit apple = new Apple();
        Fruit banana = new Banana();
        Fruit blueberry = new BlueBerry();

        TreeSet<Fruit> treeSet = new TreeSet();
        treeSet.add(banana);
        treeSet.add(apple);
        treeSet.add(blueberry);

        System.out.println(treeSet);

        Fruit watermelon = new Watermelon();
        treeSet.add(watermelon);
        System.out.println(treeSet);
    }
}
