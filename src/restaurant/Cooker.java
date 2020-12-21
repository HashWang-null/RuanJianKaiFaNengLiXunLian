package restaurant;


/**
 * @姓名 王瀚霆
 * @学号 2019302841
 * @描述
 */
public class Cooker {
    
    private String Order;
    
    public void getOrder(String Order) {
        this.Order = Order;
    } 
    
    public void CookOrder() {
        PrepareOrder();
        CookingOrder();
    }
    
    private void PrepareOrder() {
        System.out.println("Preparing "+Order);
    }
    
    private void CookingOrder() {
        System.out.println("Cooking "+Order);
    }
}
