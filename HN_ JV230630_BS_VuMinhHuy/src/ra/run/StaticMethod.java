package ra.run;

import ra.bussinessImp.Book;

import java.util.*;

public class StaticMethod {
    public static void addNewBoook(Scanner scanner, List<Book> books) {
        System.out.println("Nhập số lượng sách muốn thêm mới : ");
        int numToAdd = scanner.nextInt();
        for (int i = 0; i < numToAdd; i++) {
            System.out.println("Nhập thông tin cuốn sách #" + (i + 1));
            Book book = new Book();
            book.inputData();
            books.add(book);
            System.out.println("Đã thêm sách thành công");
        }
        System.out.println();
    }

    public static void displayAllBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("Không có cuốn sách nào !");
        } else {
            System.out.println("==============DANH SÁCH================");
            for (Book b : books) {
                b.displayData();
            }
        }
        System.out.println();
    }

    public static void sortListBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("Không có cuốn sách nào !");
        } else {
            System.out.println("===========DANH SÁCH THEO THỨ TỰ LỢI NHUẬN GIẢM DẦN============= ");
            Collections.sort(books);
            for (Book b : books) {
                b.displayData();
            }
        }
        System.out.println();
    }

    public static void deleteBook(Scanner scanner, List<Book> books) {
        System.out.println("Nhập ID sách cần xóa : ");
        int idDel = scanner.nextInt();
        boolean check = true;
        for (Book b : books) {
            if (b.getBookId() == idDel) {
                books.remove(b);
                System.out.println("Đã xóa sách thành công");
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("Không tìm thấy cuốn sách có ID là " + idDel);
        }
        System.out.println();
    }

    public static void searchBook(Scanner scanner, List<Book> books) {
        scanner.nextLine();
        System.out.println("Nhập từ khóa cần tìm kiếm : ");
        String keyword = scanner.nextLine().trim().toLowerCase();
        boolean searchCheck = false;
        System.out.println("================= Kết quả tìm kiếm ========================");
        for (Book b : books) {
            if (b.getBookName().toLowerCase().contains(keyword)) {
                searchCheck = true;
                b.displayData();
            }
        }
        if (!searchCheck) {
            System.out.println("Không tìm thấy sách nào phù hợp với từ khóa tìm kiếm !");
        }
        System.out.println();
    }

    public static void updateBook(Scanner scanner, List<Book> books) {
        System.out.println("Nhập ID sách cần cập nhật thông tin : ");
        int idUpdate = scanner.nextInt();
        boolean check = false;
        for (Book b : books) {
            if (b.getBookId() == idUpdate) {
                b.inputData();
                System.out.println("Thông tin sácch đã được cập nhật thành công");
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("Không tìm thấy thông tin sách cần cập nhật !");
        }
        System.out.println();
    }
}
