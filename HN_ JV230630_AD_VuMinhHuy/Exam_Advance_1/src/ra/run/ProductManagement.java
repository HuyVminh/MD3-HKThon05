package ra.run;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ra.bussinessImp.Catalog;
import ra.bussinessImp.Product;

public class ProductManagement {
    public ProductManagement() {
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList();
        List<Catalog> catalogs = new ArrayList();
        catalogs.add(new Catalog("Thịt", 1, "Thịt gà, thịt lợn, thịt bò..."));
        catalogs.add(new Catalog("Cá", 1, "cá thu, cá quả, cá voi, cá mập..."));
        catalogs.add(new Catalog("Rau", 1, "rau muống, rau cải, rau dền..."));
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while(choice != 5) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-2-MENU***************\n1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục\n2. Nhập số sản phẩm và nhập thông tin các sản phẩm\n3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần (Comparable/Comparator)\n4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm\n5. Thoát");
            System.out.print("Nhập lựa chọn của bạn : ");
            choice = scanner.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                    StaticMethods.addCategory(scanner, catalogs);
                    break;
                case 2:
                    StaticMethods.addProduct(scanner, products, catalogs);
                    break;
                case 3:
                    StaticMethods.sort(products);
                    break;
                case 4:
                    StaticMethods.searchCategory(scanner, products);
                    break;
                case 5:
                    System.out.println("Đang thoát chương trình...");
                    break;
                default:
                    System.out.println("Không hợp lệ. Vui lòng nhập lại.");
            }
        }

    }
}
