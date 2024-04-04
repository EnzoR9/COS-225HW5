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
        size++;

    }

    public void addStock(int addedStock)
    {
        stock += addedStock;
    }

    public void CompleteOrder()
    {
        if (queue.isEmpty() != true && stock < 0)
        {
            CustomerOrder order = queue.getFront();
            order.shipProduct();
            stock--;
            if (order.quantity == 0)
            {
                queue.dequeue();
                queueSize--;
            }

        }

    }

    public void sellOut()
    {
        while (stock > 0 && queue.isEmpty() == false)
        {
           CompleteOrder(); 
        }
    }

    @Override
    public String toString()
    {
        
        return String.valueOf(queue.getFront().quantity);
    }


    
}
