package ra.bussinessImp;

import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import ra.bussiness.IShop;

public class Product implements IShop {
    private int productId;
    private String productName;
    private String title;
    private String descriptions;
    private Catalog catalog;
    private float importPrice;
    private float exportPrice;
    private boolean productStatus;
    static int count = 1;

    public Product() {
        this.productId = count++;
        this.productStatus = true;
    }

    public Product(String productName, String title, String descriptions, Catalog catalog, float importPrice) {
        this.productId = count++;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.exportPrice = importPrice * 1.3F;
        this.productStatus = true;
    }

    public Catalog getCatalog() {
        return this.catalog;
    }

    public float getExportPrice() {
        return this.exportPrice;
    }

    public void inputData() {
    }

    public void inputData(List<Catalog> catalogs) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mã sản phẩm : " + this.productId);
        System.out.println("Nhập tên sản phẩm : ");
        this.productName = scanner.nextLine();
        System.out.println("Nhập tiêu đề sản phẩm :");
        this.title = scanner.nextLine();
        System.out.println("===== Danh mục sản phẩm ========");
        Iterator var3 = catalogs.iterator();

        while(var3.hasNext()) {
            Catalog catalog = (Catalog)var3.next();
            System.out.println(catalog.getCatalogId() + ". " + catalog.getCatalogName());
        }

        System.out.println("Nhập danh mục muốn thêm vào :");
        int catagory = scanner.nextInt();
        Iterator var7 = catalogs.iterator();

        while(var7.hasNext()) {
            Catalog catalog = (Catalog)var7.next();
            if (catalog.getCatalogId() == catagory) {
                this.catalog = catalog;
            }
        }

        scanner.nextLine();
        System.out.println("Nhập mô tả sản phẩm :");
        this.descriptions = scanner.nextLine();
        System.out.println("Nhập giá mua vào :");
        float imp = scanner.nextFloat();
        this.importPrice = imp;
        this.exportPrice = imp * 1.3F;
    }

    public void displayData() {
        Locale locale = new Locale("vi", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        String exportPriceFormatted = currencyFormatter.format((double)this.exportPrice);
        System.out.println("{ Mã sản phẩm : " + this.productId + ", Tên sản phẩm : " + this.productName + ", Mô tả sản phẩm : " + this.descriptions + ", Tiêu đề : " + this.title + ", Danh mục sản phẩm : " + this.catalog.getCatalogName() + ", Giá bán ra : " + exportPriceFormatted + ", Trạng thái : " + (this.productStatus ? "Đang bán" : "Dừng bán") + "}");
    }
}
