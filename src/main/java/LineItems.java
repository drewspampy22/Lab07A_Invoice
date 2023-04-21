public class LineItems {
    public double total;
    public static double amountDue = 0;

    public static String listFormat(Product p, int q)
    {
        double total = (p.getProductPrice()) * q;
        amountDue += total;
        String output = p.getProductName() + "\t" + q + "\t" + p.getProductPrice() + "\t" + total;
        return output;
    }
}