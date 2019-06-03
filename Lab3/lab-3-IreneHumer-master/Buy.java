public class Buy {
    private String productId;
    private double price;
    private int quantity;

    public Buy(String p, double amount, int q) {
        productId = p;
        price = amount;
        quantity = q;
    }

    public String getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
