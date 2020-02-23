package edu.weber;

abstract class Person {
    private String name;

    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getDescription();
}

public class Employee extends  Person{
    private String name;
    private int salary;

    public Employee(String name, int salary)
    {
        super(name);
        this.salary = salary;
    }

    public String getDescription()
    {
        return String.format("An employee with a salary of $%.2f", (double)salary);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void raiseSalaryByPercent(int percent)
    {
        salary += salary * (percent / 100.0);
    }

    @Override
    public boolean equals(Object otherObj) {
        // a quick test to see if the objects are identical
        if(this == otherObj) return true;

        // must return false if the other object is null
        if(otherObj == null) return false;

        // if classes don't match return false
        if(getClass() != otherObj.getClass()) return false;

        Employee other = (Employee)otherObj;

        return this.salary == other.salary && this.getName().equals(other.getName());
    }
}

class Manager extends Employee{
    private int bonus;

    public Manager(String name, int salary)
    {
        super(name, salary);
        this.bonus = 0;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public int getSalary() {
        return super.getSalary() + bonus;
    }
}

final class Executive extends Manager{
    private int clubFee;

    public Executive(String name, int salary)
    {
        super(name, salary);
        clubFee = 0;
    }
}

class Student extends Person
{
    private double gpa;

    public Student(String name, double gpa)
    {
        super(name);
        this.gpa = gpa;
    }

    public String getDescription()
    {
        return String.format("A student with GPA of %2f", gpa);
    }
}