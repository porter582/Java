package edu.weber;

public class SimpleArrayExample {

    public static void main(String[] args) {

        int[] intArray = new int[10];
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }

        for(int i : intArray)
        {
            System.out.println(i);
        }

        int[] array2 = {1,2,3,4,5};
    }
}
