package edu.weber;

import java.util.ArrayList;
import java.util.ListIterator;

public class ArrayListExample {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<String>();
        list.add("California");
        list.add("Oregon");
        list.add("Washington");
        System.out.println(list);

        list.add("Alaska");
        System.out.println(list);

        list.remove(0);
        System.out.println(list);

        String state = list.get(1);
        System.out.println("The second state is " + state);

        list.add("Alaska");
        System.out.println(list);

        int pos = list.indexOf("Alaska");
        System.out.println(pos);

        ListIterator<String> listIterator = list.listIterator();
        while(listIterator.hasNext())
        {
            String value = listIterator.next();
            System.out.println(value);
        }
    }
}
