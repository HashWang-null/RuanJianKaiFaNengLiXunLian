package restaurant;

/**
 * @姓名 王瀚霆
 * @学号 2019302841
 * @描述
 */
public class Restaurant {
    public static void main(String[] args) {
        Customer customer = new Customer();
        Waiter waiter = new Waiter();
        Cooker cooker = new Cooker();

        customer.orderDishes(waiter, "西红柿炒鸡蛋");
        waiter.submitOrder(cooker);
        cooker.CookOrder();
    }
}
