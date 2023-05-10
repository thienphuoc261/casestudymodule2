package service;

import entity.Product;

public interface IBuilderProduct {
    public IBuilderProduct buildID (int id);
    public IBuilderProduct buildProductName (String productName);
    public IBuilderProduct buildQuantity (int quantity);
    public IBuilderProduct buildUnitPriceOfProduct (int unitPriceOfProduct);
    public IBuilderProduct buildManufactureDate (String manufactureDate);
    public IBuilderProduct buildExpirationDate (String expirationDate);
    public IBuilderProduct buildUnit (String unit);
    public IBuilderProduct buildDiscription (String discription);
    public IBuilderProduct buildImporter (String importer);
    public IBuilderProduct buildImportDate (String importDate);
    public Product build ();
}
