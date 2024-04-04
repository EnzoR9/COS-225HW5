public class OrderQueue<T> extends LinkedQueue<T>
{
    public LinkedQueue<CustomerOrder> queue;

    public int stock; 
    public int queueSize;

    public OrderQueue()
    {
        this.queue = new LinkedQueue<>();
        this.stock = 0;
        this.queueSize = 0;
    }

    public OrderQueue(int s)
    {
        this.queue = new LinkedQueue<>();
        this.queueSize = 0;
        this.stock = s;
    }


    public void addOrder(String name, String date, int quantity)
    {
        CustomerOrder order = new CustomerOrder(name, date, quantity);
        queue.enqueue(order);
        

    }

    public void addStock(int addedStock)
    {
        stock += addedStock;
    }

    public void CompleteOrder()
    {
        if (!queue.isEmpty() && stock > 0)
        {
            CustomerOrder order = queue.getFront();
            int orderQuantity = order.quantity;
            if(orderQuantity <= stock)
            {
                order.shipProduct();
                stock -= orderQuantity;
                queue.dequeue();

            }
            else
            {
                order.quantity -= stock;
                stock = 0;
            }
            
        }

    }

    public void sellOut()
    {
        while (!queue.isEmpty() && stock > 0)
        {
           CompleteOrder(); 
        }
    }

    @Override
    public String toString()
    {
        if (!queue.isEmpty())
        {
            return String.valueOf(queue.getFront().quantity);
        }
        return "";
    }


    
}
