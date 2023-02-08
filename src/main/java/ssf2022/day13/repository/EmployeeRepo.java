package ssf2022.day13.repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.springframework.stereotype.Repository;

import ssf2022.day13.model.Employee;

@Repository
public class EmployeeRepo {
    
    private List<Employee> employees;

    public EmployeeRepo() throws ParseException {
        
        if(employees == null) {
          employees = new ArrayList<Employee>();  
        }

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        Date dt = df.parse("1980-10-15");
        Employee emp = new Employee("Derrick","Tan", "derrick@gmail.com" , "91234567", 7500, dt, "10 Ghim Moh", 272210);
        employees.add(emp);

        dt = df.parse("1979-02-18");
        emp = new Employee("Dennis","Lim", "dennis@gmail.com" , "97654321", 9000, dt, "89 Punggol Way", 888889);
        employees.add(emp);
    }

    public List<Employee> findAll() {
        return employees;
    }

    public Boolean save(Employee employee) {

        Boolean result = employees.add(employee);
        return result;
    }

    public Boolean delete(Employee employee) {
        // employees.stream().filter(emp -> emp.getEmail().equalsIgnoreCase(employee.getEmail())).findFirst().get();

        Boolean result = false;
        int employeeIndex = employees.indexOf(employee);

        if(employeeIndex >= 0) {
            employees.remove(employeeIndex);
            result = true;
        }
        
        return result;
    }

    public Employee findByEmployee(String email) {
        
        Employee emp = employees.stream().filter(e -> e.getEmail().equals(email)).findFirst().get();
        
        return emp;
    }

}
