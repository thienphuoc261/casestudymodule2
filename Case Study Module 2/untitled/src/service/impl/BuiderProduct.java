package service.impl;

import entity.Product;
import service.IBuilderProduct;

public class BuiderProduct implements IBuilderProduct {
    private int id;
    private String productName;
    private int quantity;
    private int unitPriceOfProduct;
    private String manufactureDate;
    private String expirationDate;
    private String unit;
    private String discription;
    private String importer;
    private String importDate;
    @Override
    public IBuilderProduct buildID(int id) {
        this.id = id;
        return this;
    }

    @Override
    public IBuilderProduct buildProductName(String productName) {
        this.productName = productName;
        return this;
    }

    @Override
    public IBuilderProduct buildQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    @Override
    public IBuilderProduct buildUnitPriceOfProduct(int unitPriceOfProduct) {
        this.unitPriceOfProduct = unitPriceOfProduct;
        return this;
    }

    @Override
    public IBuilderProduct buildManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
        return this;
    }

    @Override
    public IBuilderProduct buildExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    @Override
    public IBuilderProduct buildUnit(String unit) {
        this.unit = unit;
        return this;
    }

    @Override
    public IBuilderProduct buildDiscription(String discription) {
        this.discription = discription;
        return this;
    }

    @Override
    public IBuilderProduct buildImporter(String importer) {
        this.importer = importer;
        return this;
    }

    @Override
    public IBuilderProduct buildImportDate(String importDate) {
        this.importDate = importDate;
        return this;
    }

    @Override
    public Product build() {
        return new Product(id,productName,quantity, unitPriceOfProduct,manufactureDate,expirationDate,unit,discription,importer,importDate);
    }
}
