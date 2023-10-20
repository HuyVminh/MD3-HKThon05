package ra.run;

import ra.bussinessImp.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Dạy nấu ăn", "Minh Huy", 100, 100000, 250000));
        books.add(new Book("Dạy làm giàu", "Đào Thịnh", 200, 80000, 260000));
        books.add(new Book("Dạy tán gái", "Việt Anh", 300, 90000, 270000));
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 7) {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************\n" +
                    "1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách \n" +
                    "2. Hiển thị thông tin tất cả sách trong thư viện\n" +
                    "3. Sắp xếp sách theo lợi nhuận tăng dần \n" +
                    "4. Xóa sách theo mã sách \n" +
                    "5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả \n" +
                    "6. Thay đổi thông tin sách theo mã sách \n" +
                    "7. Thoát \n" +
                    "Nhập lựa chọn của bạn :");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    StaticMethod.addNewBoook(scanner, books);
                    break;
                case 2:
                    StaticMethod.displayAllBooks(books);
                    break;
                case 3:
                    StaticMethod.sortListBooks(books);
                    break;
                case 4:
                    StaticMethod.deleteBook(scanner, books);
                    break;
                case 5:
                    StaticMethod.searchBook(scanner, books);
                    break;
                case 6:
                    StaticMethod.updateBook(scanner, books);
                    break;
                case 7:
                    System.out.println("Đang thoát chương trình...");
                    break;
                default:
                    System.out.println("Không hợp lệ. Vui lòng chọn lại");
                    break;
            }
        }
    }
}
