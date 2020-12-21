package restaurant;

/**
 * @姓名 王瀚霆
 * @学号 2019302841
 * @描述
 */
public class Waiter {
    
    private String Order;
    
    public void getOrder(String Order) {
        this.Order = Order;
    }
    
    public void submitOrder(Cooker cooker) {
        cooker.getOrder(Order);
    }
}
