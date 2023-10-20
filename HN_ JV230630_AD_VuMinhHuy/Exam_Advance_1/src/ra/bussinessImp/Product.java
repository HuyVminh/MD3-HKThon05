package ra.bussinessImp;

import ra.bussiness.IShop;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

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
        this.exportPrice = importPrice * RATE;
        this.productStatus = true;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    @Override
    public void inputData() {

    }

    @Override
    public void inputData(List<Catalog> catalogs) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mã sản phẩm : " + productId);
        System.out.println("Nhập tên sản phẩm : ");
        this.productName = scanner.nextLine();
        System.out.println("Nhập tiêu đề sản phẩm :");
        this.title = scanner.nextLine();
        System.out.println("===== Danh mục sản phẩm ========");
        for (Catalog catalog : catalogs) {
            System.out.println(catalog.getCatalogId() + ". " + catalog.getCatalogName());
        }
        System.out.println("Nhập danh mục muốn thêm vào :");
        int catagory = scanner.nextInt();
        for (Catalog catalog : catalogs) {
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
        this.exportPrice = imp * RATE;
    }

    @Override
    public void displayData() {
        Locale locale = new Locale("vi", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        String exportPriceFormatted = currencyFormatter.format(exportPrice);
        System.out.println("{ Mã sản phẩm : " + productId +
                ", Tên sản phẩm : " + productName +
                ", Mô tả sản phẩm : " + descriptions +
                ", Tiêu đề : " + title +
                ", Danh mục sản phẩm : " + catalog.getCatalogName() +
                ", Giá bán ra : " + exportPriceFormatted +
                ", Trạng thái : " + (productStatus ? "Đang bán" : "Dừng bán") + "}");
    }
}
