import java.util.ArrayList;

public class Order {

    private ArrayList<MenuItem> orderList;
    private int orderPrice;

    public Order() {
        orderList = new ArrayList<MenuItem>();
        orderPrice = 0;
    }

    public ArrayList<MenuItem> getOrderList() {
        return orderList;
    }



    public void orderSaladAndDressing(MenuItem item1, MenuItem item2) {
        if (!item1.getLabels().contains(MenuItemLabels.DINNERSALAD)
                && !item2.getLabels().contains(MenuItemLabels.DINNERSALAD) ) {
            System.out.println("You have to select a salad");
            return;
        }
        if (!item1.getLabels().contains(MenuItemLabels.DRESSING)
                && !item2.getLabels().contains(MenuItemLabels.DRESSING)) {
            System.out.println("You have to select a dressing");
            return;
        }
        orderList.add(item1);
        orderList.add(item2);
        updateOrderPrice();
    }

    public void orderSaladAsSide(MenuItem item1, MenuItem item2, MenuItem item3) {
        if (!item1.getLabels().contains(MenuItemLabels.DRESSING)
                && !item2.getLabels().contains(MenuItemLabels.DRESSING)
                    && !item3.getLabels().contains(MenuItemLabels.DRESSING)) {
            System.out.println("You have to select a dressing");
            return;
        }
        if (!item1.getLabels().contains(MenuItemLabels.DINNERSALAD)
                && !item2.getLabels().contains(MenuItemLabels.DINNERSALAD)
                && !item3.getLabels().contains(MenuItemLabels.DINNERSALAD)) {
            System.out.println("You have to select a salad");
            return;
        }
        if (!item1.getLabels().contains(MenuItemLabels.ENTREE)
                && !item2.getLabels().contains(MenuItemLabels.ENTREE)
                && !item3.getLabels().contains(MenuItemLabels.ENTREE)) {
            System.out.println("You have to select an entree");
            return;
        }
        orderList.add(item1);
        orderList.add(item2);
        orderList.add(item3);
        updateOrderPrice();
    }

    public void orderSideCombo(MenuItem item1, MenuItem item2, MenuItem item3) {
        if (!item1.getLabels().contains(MenuItemLabels.DRESSING)
                && !item2.getLabels().contains(MenuItemLabels.DRESSING)
                && !item3.getLabels().contains(MenuItemLabels.DRESSING)) {
            System.out.println("You have to select a dressing");
            return;
        }

        if (!item1.getLabels().contains(MenuItemLabels.SIDEOFENTREE)
                && !item2.getLabels().contains(MenuItemLabels.SIDEOFENTREE)
                && !item3.getLabels().contains(MenuItemLabels.SIDEOFENTREE)) {
            System.out.println("You have to select a side");
            return;
        }

        if (!item1.getLabels().contains(MenuItemLabels.APPETIZER)
                && !item2.getLabels().contains(MenuItemLabels.APPETIZER)
                && !item3.getLabels().contains(MenuItemLabels.APPETIZER)
                && !item1.getLabels().contains(MenuItemLabels.ENTREE)
                && !item2.getLabels().contains(MenuItemLabels.ENTREE)
                && !item3.getLabels().contains(MenuItemLabels.ENTREE)) {
            System.out.println("You have to select an appetizer or an entree");
            return;
        }
        orderList.add(item1);
        orderList.add(item2);
        orderList.add(item3);
        updateOrderPrice();
    }

    public void setOrderList(ArrayList<MenuItem> orderList) {

        this.orderList = orderList;
        updateOrderPrice();
    }

    public void updateOrderPrice() {
        for (int i = 0; i < orderList.size(); i++) {
            orderPrice += orderList.get(i).getPrice();
        }
    }
}
