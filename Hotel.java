import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private String address;
    private List<Employee> employees;
    public Hotel(String name, String address) {
        this.name = name;
        this.address = address;
        this.employees = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public List<Employee> getEmployees() {
        return employees;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    public void printAllEmployee() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
