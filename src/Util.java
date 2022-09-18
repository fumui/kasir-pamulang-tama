import java.text.NumberFormat;
import java.util.Locale;

public class Util {
    public static String lpad(String s, int n){
        StringBuilder sBuilder = new StringBuilder(s);
        sBuilder.append(" ".repeat(Math.max(0, n - sBuilder.length())));
        return sBuilder.toString();
    }
    public static String rpFormat(int n){
        return NumberFormat.getCurrencyInstance(new Locale("id", "ID")).format(n);
    }
}
