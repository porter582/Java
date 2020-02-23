package edu.weber;

public class EmployeeDriver {

    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl", 75000, 1987, 12, 15);
        staff[1] = new Employee("Jack", 50000, 1996, 3, 1);
        staff[2] = new Employee("Tony", 100000, 2002, 5, 13);

        for(Employee e : staff)
        {
            e.raiseSalary(5);
        }

        for (Employee e : staff) {
            System.out.println(e.toString());
        }

        int n = Employee.getNextId();
        System.out.println("Next available Id = " + n);
    }
}
