package bai14;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Employee {
    private String employeeId;
    private String employeeName;
    private LocalDate birthday;
    private boolean sex;
    private double salary;
    private Employee manager;
    private Department department;

    public Employee() {
    }

    public Employee(String employeeId, String employeeName, LocalDate birthday, boolean sex, double salary, Employee manager, Department department) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.sex = sex;
        this.salary = salary;
        this.manager = manager;
        this.department = department;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void input(Scanner scanner, List<Employee> listEmployee, List<Department> listDepart){
        employeeId = inputEmployeeId(scanner,listEmployee);
        employeeName = inputEmployeeName(scanner);
        birthday = inputBirthda(scanner);
        sex = inputSex(scanner);
        salary = inputSalary(scanner);
        manager = inputManager(scanner, listEmployee);
        department = inputDepartment(scanner, listDepart);
    }

    public void displayIdAndName(){
        System.out.println("----------------------------");
        System.out.printf("|%-5s|%-20s|\n",employeeId,employeeName);
    }

    public void displayDetail(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        NumberFormat nf = NumberFormat.getNumberInstance();
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.printf("|%-5s|%-20s|%-10s|%-5s|%-10s|%-20s|%-20s|\n",employeeId,employeeName,dateTimeFormatter.format(birthday),sex?"Nam":"Nữ",nf.format(salary),manager==null?"Quản lý":manager.getEmployeeName(),department.getDepartmentName());
    }

    private Department inputDepartment(Scanner scanner, List<Department> listDepart) {
        listDepart.forEach(Department::display);

        do{
            System.out.println("Nhập mã phòng ban: ");
            String id = scanner.nextLine();
            for(Department d : listDepart){
                if(d.getDepartmentId().equalsIgnoreCase(id))
                    return d;
            }
            System.out.println("Mã phòng ban chưa tồn tại!");
        }while (true);
    }

    private Employee inputManager(Scanner scanner, List<Employee> listEmployee) {
        do{
            System.out.println("Nhâp id người quản lý: ");
            String id = scanner.nextLine();
            if(id.isBlank()){
                return null;
            }else{
                for(Employee e : listEmployee){
                    if(e.getEmployeeId().equalsIgnoreCase(id))
                        return e;
                }
                System.out.println("Mã người quản lý chưa tồn tại");
            }
        }while (true);
    }

    private double inputSalary(Scanner scanner) {
        do{
            System.out.println("Nhập salary: ");
            try{
                double sl = Double.parseDouble(scanner.nextLine());
                if(sl<0)
                    System.out.println("Lương phải nhập >=0");
                else{
                    return sl;
                }
            }catch (Exception ex){
                System.out.println("Lương phải nhập là số");
            }
        }while (true);
    }

    private boolean inputSex(Scanner scanner) {
        do{
            System.out.println("Nhập giới tính: ");
            try{
                return Boolean.parseBoolean(scanner.nextLine());
            }catch (Exception ex){
                System.out.println("Giới tính phải nhập true/false");
            }
        }while (true);
    }

    private LocalDate inputBirthda(Scanner scanner) {
        System.out.println("Nhập ngày tháng năm sinh: ");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        do{
            try{
                return LocalDate.from(dateTimeFormatter.parse(scanner.nextLine()));
            }catch (Exception ex){
                System.out.println("Ngày tháng không đúng định dạng (tháng phải nhập 2 chữ số)");
            }
        }while (true);
    }

    private String inputEmployeeName(Scanner scanner) {
        System.out.println("Nhập họ tên nhân viên: ");
        do{
            String name = scanner.nextLine();
            if(name.isBlank()){
                System.out.println("Họ tên nhân viên không được để trống");
            }else{
                return name;
            }
        }while (true);
    }

    private String inputEmployeeId(Scanner scanner, List<Employee> listEmployee) {
        System.out.println("Nhập mã nhân viên: ");
        do{
            String id = scanner.nextLine();
            if(!id.matches("^E\\w{4}$")){
                System.out.println("Mã nhân viên bắt đầu bằng kí tự E và có chính xác 5 kí tự");
            }else{
                if(listEmployee.stream().anyMatch(e->e.employeeId.equalsIgnoreCase(id))){
                    System.out.println("Mã nhân viên đã tồn tại");
                }else{
                    return id;
                }
            }
        }while (true);
    }
}
