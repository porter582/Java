package edu.weber;
import java.util.Arrays;
import java.util.Date;

public class EmployeeInterface {

    public static void main(String[] args) throws CloneNotSupportedException{
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Zade", 75_000);
        staff[1] = new Employee("Mary", 65_000);
        staff[2] = new Employee("Luke", 55_000);

        Arrays.sort(staff);

        for(Employee e : staff)
        {
            System.out.println("Name = " + e.getName() + " Salary = " + e.getSalary());
        }

        Comparable<Employee> com;
        com = new Employee("Fred", 12_000);

        //clone
        Employee copy = staff[0].clone();
    }
}

class Employee implements Comparable<Employee>, Cloneable
{
    private String name;
    private double salary;
    private Date hireDate;

    public Employee(String name, double salary)
    {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee o)
    {
        return this.name.compareTo(o.name);

        /*if(this.salary < o.salary)
        {
            return -1;
        }
        else if(this.salary == o.salary)
        {
            return 0;
        }
        else
        {
            return 1;
        }*/
    }

    //clone
    public Employee clone() throws CloneNotSupportedException
    {
        Employee cloned = (Employee)super.clone();
        cloned.hireDate = (Date)this.hireDate.clone();
        return cloned;
    }
}