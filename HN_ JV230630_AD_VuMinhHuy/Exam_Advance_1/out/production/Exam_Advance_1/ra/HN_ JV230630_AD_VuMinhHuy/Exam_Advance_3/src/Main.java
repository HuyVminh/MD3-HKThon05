import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Queue<String> listPhuHuynh = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 3) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập tên phụ huynh nộp hồ sơ\n" +
                    "2. Phụ huynh tiếp theo\n" +
                    "3. Thoát\n" +
                    "*******************************************************************");
            System.out.print("Nhập vào lựa chọn của bạn : ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Nhập tên phụ huynh  : ");
                    String name = scanner.nextLine();
                    listPhuHuynh.add(name);
                    System.out.println("======Danh sách phụ huynh đang chờ nộp hồ sơ=======");
                    for (String p : listPhuHuynh) {
                        System.out.println(p);
                    }
                    System.out.println("==========================================");
                    System.out.println();
                    break;
                case 2:
                    if (!listPhuHuynh.isEmpty()) {
                        String phuHuynhDauTien = listPhuHuynh.poll();
                        System.out.println("Xin mời phụ huynh tiếp theo : " + phuHuynhDauTien);
                        System.out.println("======Danh sách phụ huynh đang chờ nộp hồ sơ=======");
                        for (String p : listPhuHuynh) {
                            System.out.println(p);
                        }
                        System.out.println("==========================================");
                    } else {
                        System.out.println("==========================================");
                        System.out.println("Danh sách phụ huynh rỗng.");
                        System.out.println("==========================================");
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Đang thoát chương trình...");
                    break;
                default:
                    System.out.println("Không hợp lệ. Vui lòng nhập lại");
                    break;
            }
        }
    }
}
