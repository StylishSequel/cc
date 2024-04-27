import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Manager newManager = new Manager(1, "duc",true, "123",true,1, 100, "manager");
        Hotel h = new Hotel("Threeboys","Ha Noi");
//        newManager.addEmployeeIntoDatabase(h);
        h.printAllEmployee();
//        newManager.removeEmployee(h);

    }
}