package edu.weber;
/*----------------------------------------------------------------
 * CS3230  ObjectOriented User Interface Development with Java
 * Instructor Young Zhang
 * Author: Porter Okey, Nathan Cummings,Roque Dominguez
 * Written: 7/03/2019
 * Last updated: 7/13/2019
 *Main screen for back account
 *----------------------------------------------------------------*/
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BankScreen {
    public static void main(String[] args) {

        BankScreen bankScreen = new BankScreen();//allow to run method out of main
        int newAccountNumber = 100000; //starting account number
        boolean found = false; //used to see if the account was found
        String accountOrEmployee; //used to determine what the beginning choice is
        int accountNum = 0; //user account number used to search the listOfAccounts
        int i = 0; //index value used to keep knowledge of the selected account in listOfAccounts
        int choiceHolder; //used to determine what the user wants to do when logged in
        Date date = new Date(); //holds the date
        ArrayList<AccountHolder> listOfAccounts = new ArrayList<>(); //array list of accounts to be created

        /****************************Customer1******************************************/
        AccountHolder customer1 = new AccountHolder();
        customer1.setAccountNumber(newAccountNumber);
        customer1.setFirstName("Porter");
        customer1.setLastName("Okey");
        TypesOfAccounts typesOfAccounts = Enum.valueOf(TypesOfAccounts.class, "LOAN");
        customer1.setAccountType(typesOfAccounts);
        customer1.deposit(52.3);
        listOfAccounts.add(customer1);
        newAccountNumber++;
        customer1.accountHolderTransactions.add(new AccountHolderTransactions());
        customer1.accountHolderTransactions.get(0).setTransactionCredit(100);
        customer1.accountHolderTransactions.get(0).setTransactionDebit(100);
        customer1.accountHolderTransactions.get(0).setTransactionDetails("Walmart");
        customer1.accountHolderTransactions.get(0).setDate(date);


        customer1.accountHolderTransactions.add(new AccountHolderTransactions());
        customer1.accountHolderTransactions.get(1).setTransactionCredit(25.23);
        customer1.accountHolderTransactions.get(1).setTransactionDebit(25.23);
        customer1.accountHolderTransactions.get(1).setTransactionDetails("McDonalds");
        customer1.accountHolderTransactions.get(1).setDate(date);
        /****************************Customer2******************************************/
        AccountHolder customer2 = new AccountHolder();
        customer2.setAccountNumber(newAccountNumber);
        customer2.setFirstName("Nathan");
        customer2.setLastName("Cummings");
        typesOfAccounts = Enum.valueOf(TypesOfAccounts.class, "CHECKING");
        customer2.setAccountType(typesOfAccounts);
        customer2.deposit(152.3);
        listOfAccounts.add(customer2);
        newAccountNumber++;
        /****************************Customer3******************************************/
        AccountHolder customer3 = new AccountHolder();
        customer3.setAccountNumber(newAccountNumber);
        customer3.setFirstName("Roque");
        customer3.setLastName("Dominguez");
        typesOfAccounts = Enum.valueOf(TypesOfAccounts.class, "BUSINESS");
        customer3.setAccountType(typesOfAccounts);
        customer3.deposit(12.3);
        listOfAccounts.add(customer3);
        newAccountNumber++;

        do {
            System.out.println("Login (1 for Existing Account Holder, 2 for Employee, 3 for New Account)");
            Scanner reader = new Scanner(System.in);

            accountOrEmployee = reader.next();

            if (accountOrEmployee.equalsIgnoreCase("1")) { //if option 1 then account holder logged in
                reader.nextLine();
                do { //begin loop
                    try {
                        System.out.println("Account Holder ");
                        System.out.println("Enter Account Number: "); //requests the account number to search for
                        accountNum = Integer.parseInt(reader.next());
                        for (i = 0; i < listOfAccounts.size(); i++) { //for loop used to find account in listOfAccounts
                            if (listOfAccounts.get(i).getAccountNumber() == accountNum) {
                                found = true;
                                break;
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Account Number");
                    }
                } while(accountNum != -1 && found == false); //end loop
                if (found) {

                    reader.nextLine(); //flush the buffer
                    found = false; //reset found to false

                    do { //start while
                        try { //user options below
                            System.out.println("Welcome: " + listOfAccounts.get(i).getFirstName() + " "
                                    + listOfAccounts.get(i).getLastName()
                                    + " " + listOfAccounts.get(i).getAccountType().toString());
                            System.out.println("Press 1 to deposit funds");
                            System.out.println("Press 2 to withdraw funds");
                            System.out.println("Press 3 to view balance");
                            System.out.println("Press 4 to view transaction details");
                            System.out.println("Press 5 to transfer funds to another account");
                            System.out.println("Press -1 to go back");
                            choiceHolder = reader.nextInt();

                            if (choiceHolder == 1) { //option for depositing funds
                                reader.nextLine();
                                bankScreen.depositFunds(i, listOfAccounts); //passes the arrayList, index for account
                            } else if (choiceHolder == 2) { //withdraw funds
                                reader.nextLine();
                                bankScreen.withdrawFunds(i, listOfAccounts); //passes the arrayList, index for account
                            } else if (choiceHolder == 3) { //balance check option
                                System.out.println("Your Balance is: " +
                                        listOfAccounts.get(i).getBalance()); //gets balance
                            } else if (choiceHolder == 4) { //view transactions option
                                System.out.println(listOfAccounts.get(i).accountHolderTransactions);
                            } else if (choiceHolder == 5) { //option to transfer funds to second account
                                bankScreen.transferFunds(i, listOfAccounts); //passes array with index for curr account
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid Choice");
                            choiceHolder=0;//*******************************************
                            reader.nextLine();
                        }
                    } while (choiceHolder != -1); //end while
                }
            } else if (accountOrEmployee.equalsIgnoreCase("2")) { //employee option
                do {
                    Employee employee = null;
                    boolean employeesloop=false;//
                    do {
                        try {
                            reader.nextLine(); //flush buffer
                            System.out.println("Employee");
                            employee = new Employee();
                            System.out.println("Press 1 to access a current account. " +
                                    "Press 2 to create a new account"
                                    + " Press 3 to list all accounts"); // options for employee
                            choiceHolder = reader.nextInt();
                            employeesloop=false;
                        } catch (Exception e) {
                            //   System.out.println("Invalid option");
                            choiceHolder = 0;
                        }
                    } while (employeesloop==true);

                    if (choiceHolder == 1) { //login as an account holder option
                        do { //start loop
                            try {
                                System.out.println("Enter Account Number: "); //gets account number from user
                                accountNum = Integer.parseInt(reader.next());
                                for (i = 0; i < listOfAccounts.size(); i++) { //loops through array list of accounts
                                    if (listOfAccounts.get(i).getAccountNumber() == accountNum) { //if account is found
                                        found = true;
                                        break; //exit loop
                                    }
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid Account Number");
                            }
                        } while (found == false && accountNum != -1); //end while
                        if (found) {
                            reader.nextLine(); //flush buffer
                            do {
                                found = false;
                                System.out.println("Welcome: " + listOfAccounts.get(i).getFirstName() + " "
                                        + listOfAccounts.get(i).getLastName()
                                        + " " + listOfAccounts.get(i).getAccountType().toString()); //prints account info
                                System.out.println("Press 1 to deposit funds"); //employee options
                                System.out.println("Press 2 to withdraw funds");
                                System.out.println("Press 3 to view balance");
                                System.out.println("Press 4 to view transaction details");
                                System.out.println("Press 5 to transfer funds to another account");
                                System.out.println("Press 6 to delete this account"); //delete current account
                                System.out.println("Press -1 to go back");
                                choiceHolder = reader.nextInt();

                                if (choiceHolder == 1) { //deposit option
                                    reader.nextLine();
                                    bankScreen.depositFunds(i, listOfAccounts);
                                } else if (choiceHolder == 2) { //withdraw option
                                    reader.nextLine();
                                    bankScreen.withdrawFunds(i, listOfAccounts);
                                } else if (choiceHolder == 3) { //get balance option
                                    System.out.println("Your Balance is: " + listOfAccounts.get(i).getBalance());
                                } else if (choiceHolder == 4) { //view transaction details
                                    System.out.println(listOfAccounts.get(i).accountHolderTransactions);
                                } else if (choiceHolder == 5) { //transfer funds to another account
                                    bankScreen.transferFunds(i, listOfAccounts);
                                } else if (choiceHolder == 6) { //delete current account
                                    employee.deleteAccount(listOfAccounts, i);
                                    choiceHolder = -1;
                                }


                            } while (choiceHolder != -1);
                            choiceHolder = 0;
                        }
                    } else if (choiceHolder == 2) { //option for creating a new account
                        reader.nextLine();
                        bankScreen.createAccount(listOfAccounts, newAccountNumber); //creates new account call
                        newAccountNumber++; //increments the new account number
                    } else if (choiceHolder == 3) //option for listing all accounts
                    {
                        for (int k = 0; k < listOfAccounts.size(); k++) //loops through each obj in listOfAccounts
                        {
                            System.out.println(listOfAccounts.get(k).getAccountNumber() +
                                    " " + listOfAccounts.get(k).getFirstName() +
                                    " " + listOfAccounts.get(k).getLastName()); //prints account information
                        }
                    }
                    else{
                        System.out.println("Invalid Option");
                        choiceHolder=0;
                    }
                }while(choiceHolder != -1);
            } else if (accountOrEmployee.equalsIgnoreCase("3")) { //option for creating a new account
                reader.nextLine();
                bankScreen.createAccount(listOfAccounts, newAccountNumber);
                newAccountNumber++;
            }
            else {
                System.out.println("Invalid Input");
                accountOrEmployee="";
            }
        } while (accountOrEmployee != "-1"); //end while


    }

    /**
     * This will allow to Create an account
     * @param listOfAccounts
     * @param newAccountNumber
     */

    public void createAccount(ArrayList<AccountHolder> listOfAccounts, int newAccountNumber) {
        String holder;
        boolean validChoice;
        Scanner reader = new Scanner(System.in);
        AccountHolder newAccount = new AccountHolder();
        System.out.println("Enter First Name: ");
        holder = reader.nextLine();
        newAccount.setFirstName(holder);

        System.out.println("Enter Last Name: ");
        holder = reader.nextLine();
        newAccount.setLastName(holder);

        do {
            try {
                System.out.println("Enter the type of account: (PERSONAL, BUSINESS, CHECKING, SAVINGS, LOAN, CD, CREDIT");
                holder = reader.nextLine().toUpperCase();

                TypesOfAccounts typesOfAccounts = Enum.valueOf(TypesOfAccounts.class, holder);
                newAccount.setAccountType(typesOfAccounts);
                validChoice = true;
            } catch (Exception e) {
                System.out.println("Invalid Choice");
                validChoice = false;
            }
        } while(validChoice == false);
        System.out.println("Your Account Number Is: " + newAccountNumber);
        newAccount.setAccountNumber(newAccountNumber);

        listOfAccounts.add(newAccount);
    }

    /**
     * This Method will be used to Deposit Funds
     * @param i
     * @param listOfAccounts
     */
    public void depositFunds(int i, ArrayList<AccountHolder> listOfAccounts) {
        Scanner reader = new Scanner(System.in);
        String holder; //holds amount in string value
        double money; //amount of money to deposit
        int t=0;
        do {
            try {
                System.out.println("How much do you want to deposit?");
                holder = reader.nextLine();
                money = Double.parseDouble(holder);
                listOfAccounts.get(i).deposit(money); //adds money to account
                System.out.println(listOfAccounts.get(i).getBalance()); //prints balance
                t=0;
            } catch (NumberFormatException e) {
                System.out.println("Invalid Amount");
                t=1;
            }
        }while (t!=0);
    }

    /**
     * This Method will Withdraw Funds
     * @param i
     * @param listOfAccounts
     */
    public void withdrawFunds(int i, ArrayList<AccountHolder> listOfAccounts) {
        Scanner reader = new Scanner(System.in);
        String holder; //holds string value for money
        double money; //numerical money amount
        int t = 1;
        if(t == 1) {
            try {
                do {
                    System.out.println("How much do you want to withdraw?");
                    holder = reader.nextLine();
                    money = Double.parseDouble(holder);
                    listOfAccounts.get(i).withdraw(money); //removes money
                    System.out.println(listOfAccounts.get(i).getBalance()); //prints balance
                    t = 0;
                } while (t != 0);
            } catch (NumberFormatException e) {
                System.out.println("Wrong Input");
                t=1;
            }
        }
    }

    /**
     * This Method is use to transfer funds to another bank Member
     * @param i
     * @param listOfAccounts
     */
    public void transferFunds(int i, ArrayList<AccountHolder> listOfAccounts) {
        Scanner reader = new Scanner(System.in);
        String holder;
        double money;
        int accountNum;
        boolean found = false;
        int j = 0; //index value for other account number
        int t = 1;


        do {
            try {
                System.out.println("Enter the other account number: ");
                accountNum = Integer.parseInt(reader.next());
                for (int k = 0; k < listOfAccounts.size(); k++) { //searches all accounts until correct is found or end
                    if (listOfAccounts.get(k).getAccountNumber() == accountNum) {
                        found = true;
                        if (found) {
                            j = k; //if found assign the index value to j
                            t=-1;//get out of the do loop
                        }
                        break;
                    }


                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong Account number");
            }
        } while (t!=-1);

        do {

            try {
                t=1;//to stay in the loop
                if (found) { //if found enter an amount and withdraw funds from original account and deposit to other account

                    System.out.println("Enter an amount to transfer: ");
                    //reader.nextLine();
                    holder = reader.nextLine();
                    money = Double.parseDouble(holder);
                    listOfAccounts.get(i).withdraw(money);
                    System.out.println(listOfAccounts.get(i).getBalance());
                    listOfAccounts.get(j).deposit(money);
                    t=0;//get out of the do loop
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Amount");

            }
        } while (t!=0);
    }
}