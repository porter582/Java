package edu.weber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BankMain extends JPanel {

    // Create the arrayList of account holders and create various variables
    private ArrayList<AccountHolder> listOfAccounts = new ArrayList<>(); //array list of accounts to be created
    private int iAccountNumber = 0;
    private boolean found = false;
    private AccountHolder accountHolder = new AccountHolder();
    int i = 0;

    // Create JFrame
    JFrame frame = new JFrame("Bank Application");

    // Create panels for JFrame
    JPanel login = new JPanel();
    JPanel panelCont = new JPanel();
    JPanel mainScreen = new JPanel();
    JPanel deposit = new JPanel();
    JPanel withdraw = new JPanel();
    JPanel transfer = new JPanel();
    JPanel balance = new JPanel();
    JPanel createAccount = new JPanel();


    // Create items for Login screen
    JTextField accountField = new JTextField(10);
    JButton createAccountButton = new JButton("Create New Account");
    JLabel accountNumber = new JLabel("or Log in with Account Number: ");
    JButton submitLogin = new JButton("Login");

    // Create items for new account screen
    JButton accountBack = new JButton("Back");
    JLabel newAccountNumberLabel = new JLabel();
    JLabel newFirstName = new JLabel("First Name: ");
    JTextField newFirstNameTextField = new JTextField(10);
    JLabel newLastName = new JLabel("Last Name: ");
    JTextField newLastNameTextField = new JTextField(10);
    JButton newAccountSubmit = new JButton("Submit");
    int newAccountNumber = 0;

    // Create items for main menu screen
    JLabel welcome = new JLabel();
    JButton depositButton = new JButton("Deposit");
    JButton withdrawButton = new JButton("Withdraw");
    JButton transferButton = new JButton("Transfer");
    JButton balanceButton = new JButton("Balance");
    JButton logout = new JButton("Logout");

    // Create items for deposit screen
    JLabel depAmount = new JLabel("Deposit Amount: $");
    JTextField depTextField = new JTextField(10);
    JButton depSubmit = new JButton("Submit");
    double depInput = 0;
    JButton depBack = new JButton("Back");

    // Create items for withdraw screen
    JLabel withAmountLabel = new JLabel("Withdrawal Amount: $");
    JTextField withTextField = new JTextField(10);
    JButton withSubmit = new JButton("Submit");
    double withInput = 0;
    JButton withBack = new JButton("Back");

    // Create items for balance screen
    JLabel balanceAmount = new JLabel();
    JButton balBack = new JButton("Back");

    // Create items for transfer screen
    JLabel tranAccount = new JLabel("Account to transfer to: ");
    JTextField tranAccountTextField = new JTextField(10);
    JLabel tranAmount = new JLabel("Transfer Amount: ");
    JTextField tranAmountTextField = new JTextField(10);
    JButton tranSubmit = new JButton("Transfer");
    JButton tranBack = new JButton("Back");

    // Create CardLayout to be able to switch panels with only one window
    CardLayout cardLayout = new CardLayout();


    // BankMain constructor
    public BankMain() {

/**********************************************************************************************************************
 // Create example accounts
 **********************************************************************************************************************/

        AccountHolder customer1 = new AccountHolder();
        customer1.setAccountNumber(10000);
        customer1.setFirstName("Porter");
        customer1.setLastName("Joe");
        customer1.deposit(52.3);
        listOfAccounts.add(customer1);

        AccountHolder customer2 = new AccountHolder();
        customer2.setAccountNumber(10001);
        customer2.setFirstName("Joe");
        customer2.setLastName("Shmoe");
        customer2.deposit(500.00);
        listOfAccounts.add(customer2);


        // Set the layout to cardLayout
        panelCont.setLayout(cardLayout);


/**********************************************************************************************************************
 // Create all items to be displayed
 **********************************************************************************************************************/
        // Login items
        login.add(createAccountButton);
        login.add(accountNumber);
        login.add(accountField);
        login.add(submitLogin);

        // Main Screen items
        mainScreen.add(welcome);
        mainScreen.add(depositButton);
        mainScreen.add(withdrawButton);
        mainScreen.add(transferButton);
        mainScreen.add(balanceButton);
        mainScreen.add(logout);

        // Balance items
        balance.add(balanceAmount);
        balance.add(balBack);

        // Withdraw items
        withdraw.add(withAmountLabel);
        withdraw.add(withTextField);
        withdraw.add(withSubmit);
        withdraw.add(withBack);

        // Deposit items
        deposit.add(depAmount);
        deposit.add(depTextField);
        deposit.add(depSubmit);
        deposit.add(depBack);

        // Transfer items
        transfer.add(tranAccount);
        transfer.add(tranAccountTextField);
        transfer.add(tranAmount);
        transfer.add(tranAmountTextField);
        transfer.add(tranSubmit);
        transfer.add(tranBack);

        // CreateAccount items
        createAccount.add(newAccountNumberLabel);
        createAccount.add(newFirstName);
        createAccount.add(newFirstNameTextField);
        createAccount.add(newLastName);
        createAccount.add(newLastNameTextField);
        createAccount.add(newAccountSubmit);
        createAccount.add(accountBack);


        // Add panels to the cardLayout
        panelCont.add(login, "login");
        panelCont.add(mainScreen, "mainScreen");
        panelCont.add(deposit, "deposit");
        panelCont.add(withdraw, "withdraw");
        panelCont.add(balance, "balance");
        panelCont.add(transfer, "transfer");
        panelCont.add(createAccount, "createAccount");


        // Show the login screen when program starts
        cardLayout.show(panelCont, "login");

/**********************************************************************************************************************
 // Create functionality for all buttons
 **********************************************************************************************************************/

        // Login Button

        submitLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountNumber = accountField.getText();
                iAccountNumber = Integer.parseInt(accountNumber);

                for (i = 0; i < listOfAccounts.size(); i++) { //for loop used to find account in listOfAccounts
                    if (listOfAccounts.get(i).getAccountNumber() == iAccountNumber) {
                        found = true;
                        accountHolder = listOfAccounts.get(i);
                        break;
                    }

                }

                welcome.setText("Welcome, " + listOfAccounts.get(i).getFirstName() + " " + listOfAccounts.get(i).getLastName());

                if(found)
                {
                    cardLayout.show(panelCont, "mainScreen");
                }
                else
                {
                    JOptionPane.showMessageDialog(frame,
                            "Account Number Not Found.",
                            "Error",
                            JOptionPane.PLAIN_MESSAGE);
                }

            }
        });


        // CreateNewAccount buttons

        newAccountSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                AccountHolder accountHolder = new AccountHolder();
                accountHolder.setFirstName(newFirstNameTextField.getText());
                accountHolder.setLastName(newLastNameTextField.getText());
                accountHolder.setAccountNumber(newAccountNumber);
                listOfAccounts.add(accountHolder);


                cardLayout.show(panelCont, "login");
            }
        });

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int j = 0; j < listOfAccounts.size(); j++) {
                    if (j == listOfAccounts.size() - 1) {
                        newAccountNumber = listOfAccounts.get(j).getAccountNumber() + 1;
                        newAccountNumberLabel.setText("Account Number: " + Integer.toString(newAccountNumber));
                    }
                }
                newFirstNameTextField.setText("");
                newLastNameTextField.setText("");
                cardLayout.show(panelCont, "createAccount");
            }
        });

        accountBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelCont, "login");
            }
        });


        // Deposit Buttons

        depSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depInput = Double.parseDouble(depTextField.getText());
                listOfAccounts.get(i).deposit(depInput);

                //balanceAmount = new JLabel(Double.toString(listOfAccounts.get(i).getBalance()));
                cardLayout.show(panelCont, "mainScreen");
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depTextField.setText("");
                cardLayout.show(panelCont, "deposit");
            }
        });

        depBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelCont, "mainScreen");
            }
        });


        // Withdraw Buttons

        withSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withInput = Double.parseDouble(withTextField.getText());
                if (listOfAccounts.get(i).withdraw(withInput))
                    cardLayout.show(panelCont, "mainScreen");
                else
                {
                    JOptionPane.showMessageDialog(frame,
                            "Insufficient Balance",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withTextField.setText("");
                cardLayout.show(panelCont, "withdraw");
            }
        });

        withBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelCont, "mainScreen");
            }
        });


        // Balance Buttons

        balanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                balanceAmount.setText("Balance: $" + listOfAccounts.get(i).getBalance());
                cardLayout.show(panelCont, "balance");
            }
        });

        balBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelCont, "mainScreen");
            }
        });


        // Transfer Buttons

        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelCont, "transfer");
            }
        });

        tranSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double transferAmountSubmitted = Double.parseDouble(tranAmountTextField.getText());
                if (listOfAccounts.get(i).withdraw(transferAmountSubmitted)) {
                    double transferAccountSubmitted = Integer.parseInt(tranAccountTextField.getText());
                    for (int j = 0; j < listOfAccounts.size(); j++){
                        if (transferAccountSubmitted == listOfAccounts.get(j).getAccountNumber()) {
                            listOfAccounts.get(j).deposit(transferAmountSubmitted);
                            break;
                        }
                    }
                    cardLayout.show(panelCont, "mainScreen");
                }
                else {
                    JOptionPane.showMessageDialog(frame,
                            "Insufficient Balance",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        tranBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelCont, "mainScreen");
            }
        });


        // Logout Button

        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountField.setText("");
                cardLayout.show(panelCont, "login");
            }
        });



/**********************************************************************************************************************
 // Finish panel settings
 **********************************************************************************************************************/

        frame.add(panelCont);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(600, 300);

    }



    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BankMain();
            }
        });

    }
}