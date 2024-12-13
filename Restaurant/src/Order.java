public class Order {
    private Customer customer;
    private Menu[] items;
    private boolean isTakeAway;
    private double totalAmount;
    private String status;

    public Order(Customer customer, Menu[] items, boolean isTakeAway) {
        this.customer = customer;
        this.items = items;
        this.isTakeAway = isTakeAway;
        this.status = "Pending";
        calculateTotal();
    }

    private void calculateTotal() {
        totalAmount = 0;
        for (Menu item : items) {
            totalAmount += item.getHarga();
        }
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void displayOrderDetails() {
        System.out.println("Customer: " + customer.getNamaPelanggan());
        System.out.println("Contact: " + customer.getKontak());
        System.out.println("Order Type: " + (isTakeAway ? "Take-Away" : "Dine-In"));
        System.out.println("Items Ordered:");
        for (Menu item : items) {
            item.displayMenu();
        }
        System.out.println("Total Amount: Rp" + totalAmount);
        System.out.println("Order Status: " + status);
    }
}
