import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        System.out.println("DATA PENJUALAN BARANG");
        System.out.println("PT \"PAMULANG TAMA\"");
        System.out.println("Nama Kasir: Fuad Mustamirrul Ishlah");
        Transaction trx = new Transaction();
        Scanner input = new Scanner(System.in);
        while (true){
            trx.display();
            System.out.println("Ganti Cara Bayar [Ya/Tidak]?: ");
            String in = input.nextLine();
            if (in.equals("Ya")){
                System.out.println("Pilih cara bayar:");
                System.out.println("\t1. Visa-Master");
                System.out.println("\t2. Debit");
                System.out.println("\t3. Cash");
                int paymentMethodIn = input.nextInt();
                switch (paymentMethodIn){
                    case 1:
                        trx.setPaymentMethod(PaymentMethod.VISA_MASTER);
                        break;
                    case 2:
                        trx.setPaymentMethod(PaymentMethod.DEBIT);
                        break;
                    default:
                        trx.setPaymentMethod(PaymentMethod.CASH);
                        break;
                }
                input.nextLine();
            }

            System.out.println("Ada data lagi [Ya/Tidak]?");
            in = input.nextLine();
            if (!in.equals("Ya")){
                break;
            }
            Product newProduct = new Product();
            System.out.println("Kode Barang: ");
            newProduct.code = input.nextLine();
            System.out.println("Nama Barang: ");
            newProduct.name = input.nextLine();
            System.out.println("Harga Barang: ");
            newProduct.price = input.nextInt();
            System.out.println("Jumlah Beli: ");
            newProduct.amount = input.nextInt();
            input.nextLine();
            newProduct.calcTotalPrice();
            trx.addProduct(newProduct);
        }
    }
}
