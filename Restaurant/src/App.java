public class App {
    public static void main(String[] args) {
        
        Food food1 = new Food("Telor Goreng", 15000, "Nasi Putih", "Mie Goreng");
        Drink drink1 = new Drink("Teh Manis", 5000, "Hangat", "Dingin");

        Customer customer1 = new Customer("Athaya Ihsan", "0895 3456 7891");
 
        Menu[] items = { food1, drink1 };

        Order order1 = new Order(customer1, items, false); 

        order1.displayOrderDetails();

        Result result = new Result();
        result.addOrder(order1);
        result.displayOrderHistory();
    }
}
