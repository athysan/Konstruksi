public class Result {
    private Order[] orderHistory;
    private int orderCount;

    public Result() {
        orderHistory = new Order[10]; 
        orderCount = 0;
    }

    public void addOrder(Order order) {
        if (orderCount < orderHistory.length) {
            orderHistory[orderCount++] = order;
            System.out.println("Order added to history.");
        } else {
            System.out.println("Order history is full.");
        }
    }

    public void displayOrderHistory() {
        System.out.println("Order History:");
        for (int i = 0; i < orderCount; i++) {
            System.out.println("Order " + (i + 1) + ":");
            orderHistory[i].displayOrderDetails();
            System.out.println("-------------------");
        }
    }
}
