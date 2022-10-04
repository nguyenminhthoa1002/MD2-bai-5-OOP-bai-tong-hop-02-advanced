package data;

import java.util.Scanner;

public class Catalog {
    private int catalogId;
    private String catalogName;
    private int priority;
    private boolean catalogStatus;

    public Catalog() {
    }

    public Catalog(int catalogId, String catalogName, int priority, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.priority = priority;
        this.catalogStatus = catalogStatus;
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

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public void inputCatalog(Scanner scanner) {
        System.out.println("Enter Catalog ID: ");
        this.catalogId = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Catalog Name: ");
        this.catalogName = scanner.nextLine();
        System.out.println("Enter the priority: ");
        this.priority = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the Catalog Status: ");
        this.catalogStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    public void displayCatalog() {
        System.out.printf("%-20s%-30s%-15s%-15s\n",this.catalogId,this.catalogName,this.priority,this.catalogStatus);
    }
}
