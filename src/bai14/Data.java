package bai14;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<Department> listDepart = new ArrayList<>();
    public static List<Employee> listEmp = new ArrayList<>();

    static {
        Department d1 = new Department("D001", "Phong 1", 20);
        listDepart.add(d1);
        Department d2 = new Department("D002", "Phong 2", 50);
        listDepart.add(d2);
        Department d3 = new Department("D003", "Phong 3", 30);
        listDepart.add(d3);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        listEmp.add(new Employee("E0001", "Nguyen Lan Anh", LocalDate.from(dateTimeFormatter.parse("21/12/2002")),false,10000000, null,d1));
        listEmp.add(new Employee("E0002", "Tran Manh Hung", LocalDate.from(dateTimeFormatter.parse("09/05/2003")),true,8000000, null,d2));
        listEmp.add(new Employee("E0003", "Nguyen Duc Nam", LocalDate.from(dateTimeFormatter.parse("21/06/2001")),true,12000000, null,d2));
    }
}
