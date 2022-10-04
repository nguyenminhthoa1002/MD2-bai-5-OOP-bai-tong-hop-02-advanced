package run;

import data.Catalog;
import data.Product;

import java.util.Scanner;

public class ProductManagement {
    static Scanner scanner = new Scanner(System.in);
    static Catalog[] dataCatalog = new Catalog[100];
    static int indexCatalog = 0;
    static Product[] dataProduct = new Product[1000];
    static int indexProduct = 0;

    public static void main(String[] args) {
        do {
            System.out.println("********************QUẢN LÝ CỬA HÀNG*****************");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.println("Your choice is: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    ProductManagement.menuCatalog(scanner);
                    break;
                case 2:
                    ProductManagement.menuProduct(scanner);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println("Please choose 1-3");
            }
        } while (true);
    }

    public static void menuCatalog(Scanner scanner) {
        boolean exitMenuCatalog = true;
        do {
            System.out.println("********************QUẢN LÝ DANH MỤC******************");
            System.out.println("1. Nhập thông tin n danh mục");
            System.out.println("2. Hiển thị thông tin danh mục theo độ ưu tiên");
            System.out.println("3. Cập nhật thông tin danh mục theo mã danh mục");
            System.out.println("4. Thoát");
            System.out.println("Your choice is: ");
            int choiceMenuCatalog = Integer.parseInt(scanner.nextLine());
            switch (choiceMenuCatalog) {
                case 1:
                    ProductManagement.inputCatalog(scanner);
                    break;
                case 2:
                    ProductManagement.displayCatalog();
                    break;
                case 3:
                    ProductManagement.updateCatalog(scanner);
                    break;
                case 4:
                    exitMenuCatalog = false;
                    break;
                default:
                    System.err.println("Please choose 1-4");
            }
        } while (exitMenuCatalog);
    }

    public static void inputCatalog(Scanner scanner) {
        System.out.println("Enter the number Catalog you want to input: ");
        int inputCatalog = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < inputCatalog; i++) {
            System.out.printf("Input Catalog %d\n", i + 1);
            dataCatalog[i] = new Catalog();
            dataCatalog[i].inputCatalog(scanner);
            indexCatalog++;
        }
    }

    public static void displayCatalog() {
        System.out.printf("%-20s%-30s%-15s%-15s\n", "Catalog ID", "Catalog Name", "Priority", "Status");
        for (int i = 0; i < indexCatalog - 1; i++) {
            for (int j = i + 1; j < indexCatalog; j++) {
                if (dataCatalog[i].getPriority() > dataCatalog[j].getPriority()) {
                    Catalog tempt = dataCatalog[i];
                    dataCatalog[i] = dataCatalog[j];
                    dataCatalog[j] = tempt;
                }
            }
        }
        for (int i = 0; i < indexCatalog; i++) {
            dataCatalog[i].displayCatalog();
        }
    }

    public static void updateCatalog(Scanner scanner) {
        System.out.println("Enter Catalog Id to update information: ");
        int catalogIdUpdate = Integer.parseInt(scanner.nextLine());
        int indexCatalogUpdate = -1;
        for (int i = 0; i < indexCatalog; i++) {
            if (dataCatalog[i].getCatalogId() == catalogIdUpdate) {
                indexCatalogUpdate = i;
                break;
            }
        }
        if (indexCatalogUpdate != -1) {
            System.out.println("Enter Catalog Name Update: ");
            String catalogName = scanner.nextLine();
            if (catalogName != "" && catalogName.length() != 0) {
                dataCatalog[indexCatalogUpdate].setCatalogName(catalogName);
            }
            System.out.println("Enter Catalog Priority Update: ");
            String priority = scanner.nextLine();
            if (priority != "" && priority.length() != 0) {
                dataCatalog[indexCatalogUpdate].setPriority(Integer.parseInt(priority));
            }
            System.out.println("Enter Catalog Status Update: ");
            String status = scanner.nextLine();
            if (status != "" && status.length() != 0) {
                dataCatalog[indexCatalogUpdate].setCatalogStatus(Boolean.parseBoolean(status));
            }

        } else {
            System.err.println("This Catalog doesn't exist");
        }
    }

    public static void menuProduct(Scanner scanner) {
        boolean exitMenuProduct = true;
        do {
            System.out.println("********************QUẢN LÝ SẢN PHẨM*******************");
            System.out.println("1. Nhập thông tin cho n sản phẩm");
            System.out.println("2. Tính giá bán cho tất cả sản phẩm");
            System.out.println("3. Hiển thị thông tin các sản phẩm");
            System.out.println("4. Sắp xếp sản phẩm theo giá bán tăng dần");
            System.out.println("5. Tìm kiếm sản phẩm theo tên sản phẩm");
            System.out.println("6. Thống kê số lượng và in thông tin các sản phẩm sắp hết hàng (quantity<=5)");
            System.out.println("7. Cập nhật trạng thái của sản phẩm theo mã sản phẩm");
            System.out.println("8. Bán sản phẩm");
            System.out.println("9. Nhập thêm sản phẩm");
            System.out.println("10. Thoát");
            System.out.println("Your choice is: ");
            int choiceMenuProduct = Integer.parseInt(scanner.nextLine());
            switch (choiceMenuProduct) {
                case 1:
                    ProductManagement.inputProduct(scanner);
                    break;
                case 2:
                    ProductManagement.calExportPriceProduct();
                    break;
                case 3:
                    ProductManagement.displayProduct();
                    break;
                case 4:
                    ProductManagement.sortProductByExportPriceACS();
                    break;
                case 5:
                    ProductManagement.searchProductByName(scanner);
                    break;
                case 6:
                    ProductManagement.displayProductOutOfStock();
                    break;
                case 7:
                    ProductManagement.updateProductStatus();
                    break;
                case 8:
                    ProductManagement.soldProduct(scanner);
                    break;
                case 9:
                    ProductManagement.addProduct();
                    break;
                case 10:
                    exitMenuProduct = false;
                    break;
                default:
                    System.err.println("Please choose 1-10");
            }
        } while (exitMenuProduct);
    }

    public static void inputProduct(Scanner scanner) {
        System.out.println("Enter the number Product you want to input: ");
        int inputProduct = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < inputProduct; i++) {
            System.out.printf("Input Product %d\n", i + 1);
            dataProduct[indexProduct] = new Product();
            dataProduct[indexProduct].inputProduct(scanner, dataCatalog, indexCatalog);
            indexProduct++;
        }
    }

    public static void calExportPriceProduct() {
        for (int i = 0; i < indexProduct; i++) {
            dataProduct[i].calExportPrice();
        }
        System.out.println("All export price have been calculated!");
    }

    public static void displayProduct() {
        System.out.println("******************************Product Information*********************************");
        System.out.printf("%-15s%-20s%-20s%-20s%-20s%-15s%-20s%-15s%-20s\n", "Product Id", "Product Name", "Title", "Import Price", "Export Price", "Quantity", "Descriptions", "Status", "Catalog");
        for (int i = 0; i < indexProduct; i++) {
            dataProduct[i].displayProduct();
        }
    }

    public static void sortProductByExportPriceACS() {
        System.out.println("******************************Product Information*********************************");
        System.out.printf("%-15s%-20s%-20s%-20s%-20s%-15s%-20s%-15s%-20s\n", "Product Id", "Product Name", "Title", "Import Price", "Export Price", "Quantity", "Descriptions", "Status", "Catalog");
        for (int i = 0; i < indexProduct - 1; i++) {
            for (int j = i + 1; j < indexProduct; j++) {
                if (dataProduct[i].getExportPrice() > dataProduct[j].getExportPrice()) {
                    Product tempt = dataProduct[i];
                    dataProduct[i] = dataProduct[j];
                    dataProduct[j] = tempt;
                }
            }
        }
        for (int i = 0; i < indexProduct; i++) {
            dataProduct[i].displayProduct();
        }
    }

    public static void searchProductByName(Scanner scanner) {
        System.out.println("Enter Product Name to Search: ");
        String searchProduct = scanner.nextLine();
        System.out.println("******************************Product Information*********************************");
        System.out.printf("%-15s%-20s%-20s%-20s%-20s%-15s%-20s%-15s%-20s\n", "Product Id", "Product Name", "Title", "Import Price", "Export Price", "Quantity", "Descriptions", "Status", "Catalog");
        for (int i = 0; i < indexProduct; i++) {
            if (dataProduct[i].getProductName().startsWith(searchProduct)) {
                dataProduct[i].displayProduct();
            }
        }
    }

    public static void displayProductOutOfStock() {
        System.out.println("******************************Product Information*********************************");
        System.out.printf("%-15s%-20s%-20s%-20s%-20s%-15s%-20s%-15s%-20s\n", "Product Id", "Product Name", "Title", "Import Price", "Export Price", "Quantity", "Descriptions", "Status", "Catalog");
        for (int i = 0; i < indexProduct; i++) {
            if (dataProduct[i].getQuantity() <= 5) {
                dataProduct[i].displayProduct();
            }
        }
    }

    public static void updateProductStatus() {
        System.out.println("Enter Product ID to change status: ");
        String changeProductStatus = scanner.nextLine();
        boolean checkChangeStatus = false;
        for (int i = 0; i < indexProduct; i++) {
            if (dataProduct[i].getProductId().equals(changeProductStatus)) {
                dataProduct[i].setProductStatus(!dataProduct[i].getProductStatus());
                checkChangeStatus = true;
                break;
            } else {
                checkChangeStatus = false;
            }
        }
        if (checkChangeStatus) {
            System.out.println("Change Product Status success!!!");
        } else {
            System.err.println("This Product doesn't exist! Please try again");
        }
    }

    public static void soldProduct(Scanner scanner) {
        System.out.println("Enter the name of Product you have sold: ");
        String nameSoldProduct = scanner.nextLine();
        System.out.println("Enter the number of Product you have sold: ");
        int numberSoldProduct = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < indexProduct; i++) {
            if (dataProduct[i].getProductName().equals(nameSoldProduct)) {
                int oldQuantity = dataProduct[i].getQuantity();
                dataProduct[i].setQuantity(oldQuantity -= numberSoldProduct);
                System.out.println("******************************Product Information*********************************");
                System.out.printf("%-15s%-20s%-20s%-20s%-20s%-15s%-20s%-15s%-20s\n", "Product Id", "Product Name", "Title", "Import Price", "Export Price", "Quantity", "Descriptions", "Status", "Catalog");
                dataProduct[i].displayProduct();
            }
        }
    }

    public static void addProduct() {
        System.out.println("Enter the name of Product you want to add: ");
        String nameProductAdd = scanner.nextLine();

        for (int i = 0; i < indexProduct; i++) {
            if (dataProduct[i].getProductName().equals(nameProductAdd)) {
                System.out.println("Enter the number of Product you want to add: ");
                int numberAddProduct = Integer.parseInt(scanner.nextLine());
                int oldQuantity = dataProduct[i].getQuantity();
                dataProduct[i].setQuantity(oldQuantity += numberAddProduct);
                System.out.println("******************************Product Information*********************************");
                System.out.printf("%-15s%-20s%-20s%-20s%-20s%-15s%-20s%-15s%-20s\n", "Product Id", "Product Name", "Title", "Import Price", "Export Price", "Quantity", "Descriptions", "Status", "Catalog");
                dataProduct[i].displayProduct();
                break;
            } else {
                System.err.println("This Product doesn't exist! Please add new Product!");
                ProductManagement.inputProduct(scanner);
                break;
            }
        }
    }
}

