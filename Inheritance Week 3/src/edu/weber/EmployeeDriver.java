package edu.weber;

public class EmployeeDriver {
    public static void main(String[] args) {
        Person[] people = new Person[4];
        Manager boss = new Manager("Bob", 1000000);
        boss.setBonus(5000);
        Employee e1 = new Employee("Harry", 80000);
        Employee e2 = new Employee("Mary", 55000);
        people[0] = boss;
        people[1] = e1;
        people[2] = e2;
        people[3] = new Student("Dave", 3.88);

        for(Person e : people)
        {
            System.out.println(e.getDescription());
        }
    }
}
