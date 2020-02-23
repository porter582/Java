package edu.weber;

/*----------------------------------------------------------------
 * CS3230  ObjectOriented User Interface Development with Java
 * Instructor Young Zhang
 * Author: Porter Okey, Nathan Cummings,Roque Dominguez
 * Written: 7/03/2019
 * Last updated: 7/13/2019
 * Will create a Types of accounts PERSONAL, BUSINESS,CHECKING,SAVINGS,LOAN,CD,CREDIT;
 *----------------------------------------------------------------*/
public enum TypesOfAccounts {
        PERSONAL("Personal"),
        BUSINESS("Business"),
        CHECKING("Checking"),
        SAVINGS("Savings"),
        LOAN("Loan"),
        CD("CD"),
        CREDIT("Credit");
        private String nameString;

        private TypesOfAccounts(String nameString) {
                this.nameString = nameString;
        }

        @Override
        public String toString() {
                return ("\n" + "Account Type: " + this.nameString+"\n");
        }
}
