import java.util.ArrayList;

public class Restaurant {

    private String name;
    private ArrayList<Customer> customersList;
    private ArrayList<Menu> menusList;
    private ArrayList<MenuItem> pendingItemsOrdered;
    //pendingItemsOrdered will contain all orders that are currently in progress
    // (The order might be just received in the software (maybe from DoorDash), it could be cooking up in the kitchen, etc)
    // whenever a MenuItem is done and the customer received it (it will be cleared from the List)

    public Restaurant(String name) {
        this.name = name;
        customersList = new ArrayList<>();
        menusList = new ArrayList<>();
        pendingItemsOrdered = new ArrayList<>();
    }

    public Restaurant() {
        name = "Unnamed Restaurant";
        customersList = new ArrayList<>();
        menusList = new ArrayList<>();
        pendingItemsOrdered = new ArrayList<>();
    }

    public ArrayList<Menu> getMenus() {
        return menusList;
    }

    public void setMenus(ArrayList<Menu> menus) {
        this.menusList = menus;
    }

    public void addMenu(Menu menuToBeAdded) {
        menusList.add(menuToBeAdded);
    }

    public void incomingOrder(Order incomingOrder) {
        pendingItemsOrdered.addAll(incomingOrder.getOrderList());
    }

    public void clearOrder(Order doneOrder) {
        pendingItemsOrdered.removeAll(doneOrder.getOrderList());
    }

    public void addCustomer(Customer newCustomer) {
        customersList.add(newCustomer);
    }

    public ArrayList<MenuItem> getPendingItemsOrdered() {
        return pendingItemsOrdered;
    }
}