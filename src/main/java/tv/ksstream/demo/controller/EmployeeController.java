package tv.ksstream.demo.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import tv.ksstream.demo.Employee;
import tv.ksstream.demo.EmployeeAlreadyAddedException;
import tv.ksstream.demo.EmployeeNotFoundException;
import tv.ksstream.demo.EmployeeStorageIsFullException;
import tv.ksstream.demo.service.EmployeeService;
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            employeeService.addEmployee(firstName, lastName);
        } catch (EmployeeStorageIsFullException e) {
            System.out.println("Список сотрудников полон");
        } catch (EmployeeAlreadyAddedException e) {
            System.out.println("Сотрудник уже есть в списке");
        }
        return employeeService.addEmployee(firstName, lastName);
    }
    @GetMapping(path = "/remove")
    public Employee deleteEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            employeeService.deleteEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            System.out.println("Сотрудник не найден");
        }
        return employeeService.deleteEmployee(firstName, lastName);
    }
    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            employeeService.findEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            System.out.println("Сотрудник не найден");
        }
        return employeeService.findEmployee(firstName, lastName);
    }
}
