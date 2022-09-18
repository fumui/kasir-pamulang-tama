public class Product {
    String code, name;
    int price, amount;
    private int totalPrice;

    public int getTotalPrice() {
        return totalPrice;
    }

    public void calcTotalPrice() {
        this.totalPrice = price * amount;
    }
}
