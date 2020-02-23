package edu.weber;

import java.util.ArrayList;

/*----------------------------------------------------------------
 * CS3230  ObjectOriented User Interface Development with Java
 * Instructor Young Zhang
 * Author: Porter Okey, Nathan Cummings,Roque Dominguez
 * Written: 7/03/2019
 * Last updated: 7/13/2019
 * Will allow an Employee to delete an account and do anything an
 * account holder can do
 *----------------------------------------------------------------*/
public class Employee extends AccountHolder {
    public void deleteAccount(ArrayList arrayList, int index)
    {
        arrayList.remove(index);
    }
}
