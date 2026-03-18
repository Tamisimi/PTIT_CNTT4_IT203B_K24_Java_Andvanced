package KiemTraDauGio_Session09;

import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    private static ProductDatabase instance;
    private List<Product> products = new ArrayList<>();

    private ProductDatabase() {
    }

    public static ProductDatabase getInstance() {
        if (instance == null) {
            instance = new ProductDatabase();
        }
        return instance;
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Đã thêm sản phẩm: " + product.getName());
    }

    public boolean updateProduct(String id, String newName, double newPrice) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                p.setName(newName);
                p.setPrice(newPrice);
                System.out.println("Đã cập nhật sản phẩm ID: " + id);
                return true;
            }
        }
        System.out.println("Không tìm thấy sản phẩm ID: " + id);
        return false;
    }

    public boolean deleteProduct(String id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                System.out.println("Đã xóa sản phẩm: " + products.get(i).getName());
                products.remove(i);
                return true;
            }
        }
        System.out.println("Không tìm thấy sản phẩm ID: " + id);
        return false;
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
}