public class OrderTester 
{
    public static void main(String[] args)
    {
        OrderQueue customerQueue = new OrderQueue<>(14);
        customerQueue.addOrder("Customer1", "date", 5);
        customerQueue.addOrder("Customer1", "date", 5);
        customerQueue.addOrder("Customer1", "date", 8);

        
        System.out.println(customerQueue);

        // clear stock
        customerQueue.sellOut();

        
        System.out.println(customerQueue);


        // add 10 units to stock
        customerQueue.addStock(10);
        
        // add three customer orders (3,3,5)
        customerQueue.addOrder("Customer1", "date", 5);
        customerQueue.addOrder("Customer1", "date", 5);
        customerQueue.addOrder("Customer1", "date", 8);

        // clear stock by filling orders with new stock of 8
        // print queue 
    }
}
