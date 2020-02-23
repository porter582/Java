package edu.weber;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapExample {
    public static void main(String[] args)
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("California", "Sacramento");
        map.put("Oregon", "Salem");
        map.put("Washington", "Olympia");
        System.out.println(map);
        System.out.println("Size of the map = " + map.size());

        map.put("Alaska", "Juneau");
        System.out.println(map);

        String capital = map.get("Oregon");
        System.out.println(capital);

        map.remove("California");
        System.out.println(map);

        map.put("Alaska", "Anchorage");
        System.out.println(map);

        Set<String> keys = map.keySet();
        Iterator<String> itor = keys.iterator();

        while(itor.hasNext())
        {
            String key = itor.next();
            System.out.println("The capital of " + key + " is " + map.get(key));
        }
    }
}
