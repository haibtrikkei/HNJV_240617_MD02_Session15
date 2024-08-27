package bai14;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Stream;

public class EmployeeProgram {

    public static void showMenu(Scanner scanner) {
        question5();
    }

    public static void question5(){
        System.out.println("5 Nhan vien co tuoi cao nhat cong ty: ");
        Stream<Employee> limit2 = Data.listEmp.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(2);
        limit2.forEach(Employee::displayDetail);
    }
}
