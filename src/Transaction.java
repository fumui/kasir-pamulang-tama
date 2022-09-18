import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private final List<Product> products = new ArrayList<>();
    private int sumPrice = 0,discount = 0, ppn = 0, cardFee = 0, totalPrice = 0;
    private PaymentMethod paymentMethod = PaymentMethod.CASH;

    void display(){
        System.out.println("=============================================================================");
        System.out.println("No.   Kode Barang   Nama Barang   Harga Barang   Jumlah Beli   Bayar         ");
        System.out.println("=============================================================================");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(
                    Util.lpad((i+1)+"", 6) +
                    Util.lpad(products.get(i).code, 14) +
                    Util.lpad(products.get(i).name, 14) +
                    Util.lpad(Util.rpFormat(products.get(i).price) + "", 15) +
                    Util.lpad(Util.rpFormat(products.get(i).amount) + "", 14) +
                    Util.lpad(Util.rpFormat(products.get(i).getTotalPrice()) + "", 14));
        }
        System.out.println("=============================================================================");
        System.out.println("Jumlah Bayar                       : "+ Util.rpFormat(sumPrice));
        System.out.println("Diskon                             : "+ Util.rpFormat(discount));
        System.out.println("PPN                                : "+ Util.rpFormat(ppn));
        System.out.println("Cara Bayar (Visa-Master/Debit/Cash): "+ paymentMethod.toString() +
                "\tBiaya Kartu: "+ Util.rpFormat(cardFee));
        System.out.println("Total Bayar                        : "+ Util.rpFormat(totalPrice));
    }

    void addProduct(Product newProduct){
        products.add(newProduct);
        sumPrice += newProduct.getTotalPrice();
        discount = sumPrice > 500000 ? sumPrice * 5 / 100 : 0;
        ppn = sumPrice * 10 / 100;
        cardFee = paymentMethod == PaymentMethod.VISA_MASTER ? sumPrice * 3 / 100 : 0;
        totalPrice = sumPrice + ppn + cardFee - discount;
    }

    void setPaymentMethod(PaymentMethod newPaymentMethod){
        paymentMethod = newPaymentMethod;
    }

    public List<Product> getProducts() {
        return products;
    }

    public int getSumPrice() {
        return sumPrice;
    }

    public float getDiscount() {
        return discount;
    }

    public float getPpn() {
        return ppn;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public float getCardFee() {
        return cardFee;
    }

    public float getTotalPrice() {
        return totalPrice;
    }
}
