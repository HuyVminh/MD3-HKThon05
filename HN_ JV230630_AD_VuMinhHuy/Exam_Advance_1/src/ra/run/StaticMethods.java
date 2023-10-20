package ra.run;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import ra.bussinessImp.Catalog;
import ra.bussinessImp.Product;

public class StaticMethods {
    public StaticMethods() {
    }

    public static void addCategory(Scanner scanner, List<Catalog> catalogs) {
        System.out.println("Nhập số lượng danh mục muốn thêm vào");
        int numToAddCate = scanner.nextInt();

        for(int i = 0; i < numToAddCate; ++i) {
            System.out.println("Nhập thông tin của danh mục thứ #" + (i + 1) + " :");
            Catalog catalog = new Catalog();
            catalog.inputData();
            catalogs.add(catalog);
            System.out.println("Đã thêm danh mục thành công!");
        }

        System.out.println();
    }

    public static void addProduct(Scanner scanner, List<Product> products, List<Catalog> catalogs) {
        System.out.println("Nhập số lượng sản phẩm muốn thêm vào");
        int numToAdd = scanner.nextInt();

        for(int i = 0; i < numToAdd; ++i) {
            System.out.println("Nhập thông tin của sản phẩm thứ #" + (i + 1) + " :");
            Product product = new Product();
            product.inputData(catalogs);
            products.add(product);
            System.out.println("Đã thêm sản phẩm thành công!");
        }

        System.out.println();
    }

    public static void sort(List<Product> products) {
        products.sort(new Comparator<Product>() {
            public int compare(Product o1, Product o2) {
                return (int)(o1.getExportPrice() - o2.getExportPrice());
            }
        });
        System.out.println("Danh sách sản phẩm được sắp xếp theoo giá sản phẩm tăng dần : ");
        Iterator var1 = products.iterator();

        while(var1.hasNext()) {
            Product p = (Product)var1.next();
            p.displayData();
        }

        System.out.println();
    }

    public static void searchCategory(Scanner scanner, List<Product> products) {
        List<Product> productFound = new ArrayList();
        scanner.nextLine();
        System.out.println("Nhập tên danh mục sản phẩm cần tìm kiếm :");
        String search = scanner.nextLine().trim().toLowerCase();
        boolean checked = false;
        Iterator var5 = products.iterator();

        Product p;
        while(var5.hasNext()) {
            p = (Product)var5.next();
            if (p.getCatalog().getCatalogName().toLowerCase().contains(search)) {
                productFound.add(p);
                checked = true;
            }
        }

        if (!checked) {
            System.out.println("Không tìm thấy sản phẩm có tên danh mục là : " + search);
        } else {
            System.out.println("Danh sách sản phẩm có tên danh mục " + search + " là : ");
            var5 = productFound.iterator();

            while(var5.hasNext()) {
                p = (Product)var5.next();
                p.displayData();
            }
        }

        System.out.println();
    }
}
