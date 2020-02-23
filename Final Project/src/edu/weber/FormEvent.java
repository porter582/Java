package edu.weber;

import java.util.EventObject;

public class FormEvent extends EventObject {

    private String accountNumber;

    public FormEvent(Object source, String accountNumber)
    {
        super(source);
        this.accountNumber = accountNumber;
    }

    public String getaccountNumber() {
        return accountNumber;
    }

    public void setaccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }


}