package edu.weber;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee
{
    private String name;
    private int salary;
    private Date hireDay;
    private int id;
    private static int nextId = 1;

    public Employee(String name, int salary,
                    int year, int month, int day)
    {
        this.name = name;
        this.salary = salary;
        GregorianCalendar calender = new GregorianCalendar(year, month - 1, day);
        hireDay = calender.getTime();
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getHireDay() {
        return (Date)hireDay.clone(); //will copy hireDate then cast it to Date type and return the copy
    }

    //byPercent = 10 representing 10%
    public void raiseSalary(int byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public int getId() {
        return id;
    }

    public static int getNextId() {
        return nextId;
    }

    @Override
    public String toString() {
        return("Name = " + this.getName() + " Salary = " + this.getSalary() + " Hire Day = " + this.getHireDay()
                + " Id = " + this.getId());
    }
}
