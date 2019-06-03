public class View {
    private String productId;
    private double price;
    private int numViews;

    public View(String p, double amt) {
        productId = p;
        price = amt;
    }

    public String getProduct() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public int getNumViews() {
        return numViews;
    }
}
