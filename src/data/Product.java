package data;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private String title;
    private float importPrice;
    private float exportPrice;
    private int quantity;
    private String descriptions;
    private Boolean productStatus;
    private Catalog catalog;

    public Product() {
    }

    public Product(String productId, String productName, String title, float importPrice, float exportPrice, int quantity, String descriptions, Boolean productStatus, Catalog catalog) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.productStatus = productStatus;
        this.catalog = catalog;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Boolean getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Boolean productStatus) {
        this.productStatus = productStatus;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public void inputProduct(Scanner scanner, Catalog[] dataCatalog, int indexCatalog) {
        System.out.println("Enter Product ID: ");
        this.productId = scanner.nextLine();
        System.out.println("Enter Product Name: ");
        this.productName = scanner.nextLine();
        System.out.println("Enter Title: ");
        this.title = scanner.nextLine();
        System.out.println("Enter Import Price: ");
        this.importPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Enter the Quantity: ");
        this.quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Descriptions: ");
        this.descriptions = scanner.nextLine();
        System.out.println("Enter Product Status: ");
        this.productStatus = Boolean.parseBoolean(scanner.nextLine());

        System.out.println("Choose Catalog which Product belongs to: ");
        for (int i = 0; i < indexCatalog; i++) {
            System.out.printf("%d. %s\n",i+1,dataCatalog[i].getCatalogName());
        }
        System.out.println("Your choice is: ");
        int choiceCatalog = Integer.parseInt(scanner.nextLine());
        this.catalog = dataCatalog[choiceCatalog-1];
    }

    public void displayProduct(){
        System.out.printf("%-15s%-20s%-20s%-20s%-20s%-15s%-20s%-15s%-20s\n",this.productId,this.productName,this.title,this.importPrice,this.exportPrice,this.quantity,this.descriptions,this.productStatus,this.catalog.getCatalogName());
    }

    public void calExportPrice(){
        this.exportPrice = this.importPrice*1.2F;
    }
}
