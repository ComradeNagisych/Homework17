package tv.ksstream.demo.service;
import org.springframework.stereotype.Service;
import tv.ksstream.demo.Employee;
import tv.ksstream.demo.EmployeeAlreadyAddedException;
import tv.ksstream.demo.EmployeeNotFoundException;
import tv.ksstream.demo.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;
@Service

public class EmployeeService {
    private static final int maxEmployeeNumber = 50;
    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Alexey", "Alexeev"),
            new Employee("Alexandr", "Alexandrov"),
            new Employee("Alla", "Antonova"),
            new Employee("Boris", "Borisov"),
            new Employee("Victor", "Victorov"),
            new Employee("Valentina", "Valentinova"),
            new Employee("Maria", "Maximova"),
            new Employee("Natalia", "Nikolaeva"),
            new Employee("Sergey", "Sergeev"),
            new Employee("Tatiana", "Timofeeva")
    ));
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() >= maxEmployeeNumber) {
            throw new EmployeeStorageIsFullException();
        } else if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }
    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
        } else {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }
    public Employee findEmployee (String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            System.out.println("Сотрудник " + firstName + " " + lastName + " найден");
        } else {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }
}
