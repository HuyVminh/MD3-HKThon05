package ra.bussiness;

import ra.bussinessImp.Catalog;

import java.util.List;

public interface IShop {
    float RATE = 1.3F;
    void inputData();

    void inputData(List<Catalog> catalogs);

    void displayData();
}
