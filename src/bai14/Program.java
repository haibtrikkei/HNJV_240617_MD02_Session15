package bai14;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choose;

        do{
            System.out.println("--------- CHUONG TRÌNH ---------");
            System.out.println("1. Quản lý phòng ban");
            System.out.println("2. Quản lý nhân viên");
            System.out.println("3. Thoát");
            System.out.println("Hãy chọn chức năng: ");
            choose = inputNumber(scanner);
            switch (choose){
                case  1:
                    DepartmentProgram.showMenu(scanner);
                    break;
                case  2:
                    EmployeeProgram.showMenu(scanner);
                    break;
                case  3:
                    System.exit(0);
                default:
                    System.out.println("Phải nhập từ 1 đến 3");
            }
        }while (true);
    }

    public static int inputNumber(Scanner scanner) {
        do{
            try{
                int number = Integer.parseInt(scanner.nextLine());
                if(number<1)
                    System.out.println("Phải nhập lựa chon >0");
                else
                    return number;
            }catch (Exception ex){
                System.out.println("Lựa chọn phải là số");
            }
        }while (true);
    }
}
