package ra.bussiness;

import java.util.List;

import ra.bussinessImp.Catalog;

public interface IShop {
    float RATE = 1.3F;

    void inputData();

    void inputData(List<Catalog> var1);

    void displayData();
}

