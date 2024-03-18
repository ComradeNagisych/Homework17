package tv.ksstream.demo;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Employee employee = (Employee) other;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }
    @Override
    public int hashCode () {
        return Objects.hash(firstName, lastName);
    }
    @Override
    public String toString() {
        return "Employee{" +
                "firstName = " + firstName +
                ", lastName = " + lastName +
                "}";
    }
}
