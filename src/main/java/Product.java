public class Product
{
    String productName;
    Double productPrice;

    public Product(){}

    public Product(String p, Double d)
    {
        this.productName = p;
        this.productPrice = d;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public Double getProductPrice()
    {
        return productPrice;
    }

    public void setProductPrice(Double productPrice)
    {
        this.productPrice = productPrice;
    }
}