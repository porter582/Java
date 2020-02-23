package edu.weber;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample {

    public static void main(String[] args) {

        LinkedList<Fruit> list = new LinkedList<>();
        list.add(new Apple());
        list.add(new BlueBerry());
        System.out.println(list);

        list.add(1, new Banana());
        System.out.println(list);

        list.addFirst(new Watermelon());
        System.out.println(list);

        Fruit f1 = list.peek();
        System.out.println(f1.toString());
        System.out.println(list);

        Fruit f2 = list.poll();
        System.out.println(list);

        display(list); //string class split method
    }

    private static void display(Collection<Fruit> collect)
    {
        System.out.println("List order: ");
        Iterator<Fruit> itor = collect.iterator();
        while(itor.hasNext())
        {
            Fruit fruit = (Fruit)itor.next();
            System.out.println(fruit);
        }
    }
}
