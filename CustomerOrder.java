public class CustomerOrder
{
    public String name;
    public String date;
    public int quantity;

    public CustomerOrder()
    {
        this.name = null;
        this.date = null;
        this.quantity = 0;
        
    }

    public CustomerOrder(String n, String d, int q)
    {
        this.name = n;
        this.date = d;
        this.quantity = q;
    }
    
    public void shipProduct()
    {
        if (quantity > 0)
        {
            quantity--;
        }
    }
    
}