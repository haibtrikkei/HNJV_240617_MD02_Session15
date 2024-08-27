package bai14;

import java.util.Scanner;

public class DepartmentProgram {
    public static void showMenu(Scanner scanner) {
        int choose;
        boolean blExist = true;
        Department depart = new Department();

        do {
            System.out.println("--------- QUẢN LÝ PHÒNG BAN ---------");
            System.out.println("1. Danh sách phòng ban");
            System.out.println("2. Thêm mới phòng ban");
            System.out.println("3. Chỉnh sửa tên phòng ban");
            System.out.println("4. Hiển thị danh sách nhân viên theo mã phòng");
            System.out.println("5. Xóa phòng ban");
            System.out.println("6. Thoát");
            System.out.println("Hãy chọn chức năng: ");
            choose = Program.inputNumber(scanner);
            switch (choose) {
                case 1:
                    if (Data.listDepart.isEmpty()) {
                        System.out.println("Chưa có phòng ban nào");
                    } else {
                        System.out.println("Danh sách phòng ban");
                        Data.listDepart.forEach(Department::display);
                        System.out.println("----------------------------------");
                    }
                    break;
                case 2:
                    System.out.println("Nhập số phòng ban cần thêm mới: ");
                    int n = Program.inputNumber(scanner);
                    for (int i = 1; i <= n; i++) {
                        System.out.println("Nhập thông tin phòng ban: " + i);
                        Department d = new Department();
                        d.input(scanner, Data.listDepart);
                        Data.listDepart.add(d);
                    }
                    break;
                case 3:
                    String depId;
                    do{
                        System.out.println("Nhập mã phòng ban cần sửa tên: ");
                        depId = scanner.nextLine();
                        String finalDepId = depId;
                        if(Data.listDepart.stream().noneMatch(d->d.getDepartmentId().equalsIgnoreCase(finalDepId))){
                            System.out.println("Mã phòng ban không tòn tại");
                        }else{
                            break;
                        }
                    }while (true);


                    System.out.println("Nhập tên phòng ban cần sửa: ");
                    String name = depart.inputDepartmentName(scanner,Data.listDepart);
                    for (Department d : Data.listDepart) {
                        if (d.getDepartmentId().equalsIgnoreCase(depId)) {
                            d.setDepartmentName(name);
                            System.out.println("Đã cập nhật tên phòng ban");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Thông tin các nhân viên theo mã phòng: ");
                    for(Department d: Data.listDepart){
                        System.out.println("Thông tin nhân viên phòng : "+d.getDepartmentName());
                        int count = 0;
                        for(Employee e : Data.listEmp){
                            if(e.getDepartment().getDepartmentId().equalsIgnoreCase(d.getDepartmentId())){
                                e.displayDetail();
                                count++;
                            }
                        }
                        if(count==0)
                            System.out.println("\tChưa có nhân viên");
                        else{
                            System.out.println("------------------------------------------------------------------------------------------");
                            System.out.println("Có "+count+" nhân viên!");
                        }
                    }

                    break;
                case 5:
                    String depIdDelete;
                    do{
                        System.out.println("Nhập mã phòng ban cần xóa: ");
                        depIdDelete = scanner.nextLine();
                        String finalDepIdDelete = depIdDelete;
                        if(Data.listDepart.stream().noneMatch(d->d.getDepartmentId().equalsIgnoreCase(finalDepIdDelete))){
                            System.out.println("Mã phòng ban không tòn tại");
                        }else{
                            break;
                        }
                    }while (true);

                    String finalDepIdDelete1 = depIdDelete;
                    if(Data.listEmp.stream().anyMatch(e->e.getDepartment().getDepartmentId().equalsIgnoreCase(finalDepIdDelete1))){
                        System.out.println("Phòng ban đang có nhân viên, không được xóa");
                    }else{
                        for(Department d : Data.listDepart){
                            if(d.getDepartmentId().equalsIgnoreCase(depIdDelete)){
                                Data.listDepart.remove(d);
                                System.out.println("Đã xóa thành công");
                                break;
                            }
                        }
                    }
                    break;
                case 6:
                    blExist = false;
                    break;
                default:
                    System.out.println("Phải nhập từ 1 đến 6");
            }
        } while (blExist);
    }
}
