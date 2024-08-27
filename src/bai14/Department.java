package bai14;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Department {
    private String departmentId;
    private String departmentName;
    private int totalMembers;

    public Department() {
    }

    public Department(String departmentId, String departmentName, int totalMembers) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.totalMembers = totalMembers;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(int totalMembers) {
        this.totalMembers = totalMembers;
    }
    public void input(Scanner scanner, List<Department> listDepart){
        departmentId = inputDepartmentId(scanner, listDepart);
        departmentName = inputDepartmentName(scanner, listDepart);
        totalMembers = inputTotalMembers(scanner);
    }

    private int inputTotalMembers(Scanner scanner) {
        System.out.println("Nhập vào tổng số nhân viên: ");
        do{
            try{
                int total = Integer.parseInt(scanner.nextLine());
                if(total<0)
                    System.out.println("Số nhân viên phải >=0");
                else{
                    return total;
                }
            }catch (Exception ex){
                System.out.println("Phải nhập vào là số");
            }
        }while (true);
    }

    public String inputDepartmentName(Scanner scanner, List<Department> listDepart) {
        System.out.println("Nhập department name: ");
        do{
            String name = scanner.nextLine();
            if(name.isBlank()){
                System.out.println("Tên phòng ban không được để trống");
            }else{
                if(listDepart.stream().anyMatch(d->d.departmentName.equalsIgnoreCase(name))){
                    System.out.println("Department name đã tòn tại");
                }else{
                    return name;
                }
            }
        }while (true);
    }

    public String inputDepartmentId(Scanner scanner, List<Department> listDepart) {
        System.out.println("Nhập mã phòng ban: ");
        do{
            String id = scanner.nextLine();
            if(!id.matches("^D\\w{3}$")) {
                System.out.println("Mã phòng ban bắt đầu bằng kí tự D và có chính xác 4 kí tự");
            }else{
                if(listDepart.stream().anyMatch(department -> department.departmentId.equalsIgnoreCase(id))){
                    System.out.println("Mã phòng ban đã trung");
                }else{
                    return id;
                }
            }
        }while (true);
    }

    public void display(){
        System.out.println("----------------------------------");
        System.out.printf("|%-5s|%-20s|%-5d|\n",departmentId,departmentName,totalMembers);
    }
}
