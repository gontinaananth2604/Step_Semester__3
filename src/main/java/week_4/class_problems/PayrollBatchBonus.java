package week_4.class_problems;

class Employee {
    String empId;
    double salary;

    public Employee(String empId, double salary) {
        this.empId = empId;
        this.salary = salary;
    }

    public void raiseSalary(double salary) {
        this.salary += salary;
    }

    public void printFinalSalary() {
        System.out.println(empId + " | Final Salary: Rs " + salary);
    }
}

public class PayrollBatchBonus {
    public static void main(String[] args) {
        double[] salaries = {40000, 55000, 62000, 48000};
        String[] empIds = {"E-101", "E-102", "E-103", "E-104"};
        Employee[] employees = new Employee[4];

        for (int i = 0; i < salaries.length; i++) {
            employees[i] = new Employee(empIds[i], salaries[i]);
            employees[i].raiseSalary(5000);
            employees[i].printFinalSalary();
        }
    }
}
