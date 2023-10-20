package ra.bussinessImp;

import ra.bussiness.IShop;

import java.util.List;
import java.util.Scanner;

public class Catalog implements IShop {
    private int catalogId;
    private String catalogName;
    private int priority;
    private String descriptions;
    private boolean catalogStatus;
    static int count = 1;

    public Catalog() {
        this.catalogId = count++;
        this.catalogStatus = true;
    }

    public Catalog(String catalogName, int priority, String descriptions) {
        this.catalogId = count++;
        this.catalogName = catalogName;
        this.priority = priority;
        this.descriptions = descriptions;
        this.catalogStatus = true;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mã danh mục sản phẩm : " + catalogId);
        System.out.println("Nhập tên dạnh mục sản phẩm :");
        this.catalogName = scanner.nextLine();
        System.out.println("Nhập độ ưu tiên :");
        this.priority = scanner.nextInt();
        System.out.println("Nhập mô tả :");
        this.descriptions = scanner.nextLine();
    }

    @Override
    public void inputData(List<Catalog> catalogs) {

    }

    @Override
    public void displayData() {
        System.out.println("{ Mã danh mục sản phẩm : " + catalogId + " , " +
                "Tên danh mục sản phẩm : " + catalogName + " , " +
                "Độ ưu tiên : " + priority + " , " +
                "Mô tả : " + descriptions + " , " +
                "Trạng thái : " + catalogStatus + "}");
    }
}
