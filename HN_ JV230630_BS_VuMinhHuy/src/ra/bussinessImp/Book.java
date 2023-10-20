package ra.bussinessImp;

import ra.bussiness.IBook;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Book implements IBook, Comparable<Book> {
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean bookStatus;
    static int count = 1;

    public Book() {
        this.bookId = count++;
        this.interest = exportPrice - importPrice;
        this.bookStatus = true;
    }

    public Book(String bookName, String title, int numberOfPages, float importPrice, float exportPrice) {
        this.bookId = count++;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = exportPrice - importPrice;
        this.bookStatus = true;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mã sách : " + bookId);
        System.out.println("Nhập tên sách : ");
        this.bookName = scanner.nextLine().trim();
        System.out.println("Nhập tiêu đề sách : ");
        this.title = scanner.nextLine().trim();
        System.out.println("Nhập số trang sách :");
        this.numberOfPages = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập giá thu vào : ");
        float importP = Float.parseFloat(scanner.nextLine());
        this.importPrice = importP;
        System.out.println("Nhập giá bán ra :");
        float exportP = scanner.nextFloat();
        while (exportP <= 1.2 * importPrice) {
            System.out.println("Giá bán ra phải > 1.2 lần giá nhập vào, vui lòng nhập lại :");
            exportP = scanner.nextFloat();
        }
        this.exportPrice = exportP;
        this.interest = exportP - importP;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName +
                ", title='" + title +
                ", numberOfPages=" + numberOfPages +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                ", interest=" + interest +
                ", bookStatus=" + bookStatus +
                '}';
    }

    @Override
    public void displayData() {
        Locale locale = new Locale("vi", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        String importPriceFormatted = currencyFormatter.format(importPrice);
        String exportPriceFormatted = currencyFormatter.format(exportPrice);
        System.out.println("{ " +
                "Mã sách : " + bookId +
                ", Tên sách : " + bookName +
                ", Tiêu đề : " + title +
                ", Số trang : " + numberOfPages +
                ", Giá nhập : " + importPriceFormatted +
                ", Giá bán : " + exportPriceFormatted +
                ", Lợi nhuận : " + interest +
                ", Trạng thái : " + (bookStatus ? "Đang bán" : "Dừng bán") +
                " }");
    }

    @Override
    public int compareTo(Book o) {
        return (int) -(this.getInterest() - o.getInterest());
    }
}
