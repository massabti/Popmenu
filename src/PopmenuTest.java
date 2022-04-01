import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class PopmenuTest {


    @Test
    public void menuItemInstansiation5Arg() {
        MenuItem menuItemTest = new MenuItem("Chicken Shawarma", "Description", 9.99, 700, new HashSet<>());
        assertEquals("Chicken Shawarma", menuItemTest.getName());
        assertEquals("Description", menuItemTest.getDescription());
        assertEquals(9.99, menuItemTest.getPrice());
        assertEquals(700, menuItemTest.getCalories());
        assertEquals(0, menuItemTest.getLabels().size());
    }

    @Test
    public void menuItemInstansiation1Arg() {
        MenuItem menuItemTest2 = new MenuItem("Chicken Shawarma");
        assertEquals("Chicken Shawarma", menuItemTest2.getName());
        assertEquals("", menuItemTest2.getDescription());
        assertEquals(0.0, menuItemTest2.getPrice());
        assertEquals(0, menuItemTest2.getCalories());
        assertEquals(0, menuItemTest2.getLabels().size());
    }

    @Test
    public void menuItemInstansiationNoArg() {
        MenuItem menuItemTest2 = new MenuItem();
        assertEquals("Unnamed Item", menuItemTest2.getName());
        assertEquals("", menuItemTest2.getDescription());
        assertEquals(0.0, menuItemTest2.getPrice());
        assertEquals(0, menuItemTest2.getCalories());
        assertEquals(0, menuItemTest2.getLabels().size());
    }

    @Test
    public void createMenu() {
        Menu menuTest = new Menu();
        MenuItem fries = new MenuItem("French Fries");
        MenuItem burger = new MenuItem("Burger", "Desc", 7.99, 700, null);
        MenuItem pizza = new MenuItem("Cheese Pizza");
        menuTest.addMenuItem(fries);
        menuTest.addMenuItem(burger);
        menuTest.addMenuItem(pizza);
        assertEquals("French Fries", menuTest.getMenuItems().get(0).getName());
        assertEquals("",menuTest.getMenuItems().get(0).getDescription());
        assertEquals("Burger", menuTest.getMenuItems().get(1).getName());
        assertEquals("Desc", menuTest.getMenuItems().get(1).getDescription());
        assertEquals(700, menuTest.getMenuItems().get(1).getCalories());
        assertEquals(7.99, menuTest.getMenuItems().get(1).getPrice());
        assertEquals(new HashSet<MenuItemLabels>(), menuTest.getMenuItems().get(1).getLabels());
    }

    @Test
    public void noDubMenuItemName() {
        Menu menuTest = new Menu();
        assertEquals(0, menuTest.getMenuItems().size());
        MenuItem fries = new MenuItem("French Fries");
        menuTest.addMenuItem(fries);
        assertEquals("French Fries", menuTest.getMenuItems().get(0).getName());
        assertEquals(1, menuTest.getMenuItems().size());
        MenuItem dubFries = new MenuItem("French Fries");
        menuTest.addMenuItem(dubFries);
        assertEquals(1, menuTest.getMenuItems().size());
    }

    @Test
    public void createRestaurant() {
        Restaurant myRestaurant = new Restaurant("Popmenu Restaurant");
        //myRestaurant should have 2 menus
        //the first menu should contain: fries, burger, pizza
        // the second menu should contain: Chicken Pasta, Lasagna, Garlic Bread
        Menu menu1 = new Menu("MENU 1");
        MenuItem fries = new MenuItem("French Fries");
        MenuItem burger = new MenuItem("Burger", "Desc", 7.99, 700, null);
        MenuItem pizza = new MenuItem("Cheese Pizza");
        menu1.addMenuItem(fries);
        menu1.addMenuItem(burger);
        menu1.addMenuItem(pizza);
        Menu menu2 = new Menu("MENU 2");
        MenuItem chickenPasta = new MenuItem("Chicken Pasta");
        MenuItem lasagna = new MenuItem("Lasagna");
        MenuItem garlicBread = new MenuItem("Garlic Bread");
        garlicBread.getLabels().add(MenuItemLabels.APPETIZER);
        menu2.addMenuItem(chickenPasta);
        menu2.addMenuItem(lasagna);
        menu2.addMenuItem(garlicBread);
        menu2.addMenuItem(fries);
        assertEquals(0,myRestaurant.getMenus().size());
        myRestaurant.addMenu(menu1);
        assertEquals(1,myRestaurant.getMenus().size());
        myRestaurant.addMenu(menu2);
        assertEquals(2,myRestaurant.getMenus().size());
        assertEquals("French Fries", myRestaurant.getMenus().get(0).getMenuItems().get(0).getName());
        assertEquals("Burger", myRestaurant.getMenus().get(0).getMenuItems().get(1).getName());
        assertEquals("Cheese Pizza", myRestaurant.getMenus().get(0).getMenuItems().get(2).getName());
        assertEquals("Chicken Pasta", myRestaurant.getMenus().get(1).getMenuItems().get(0).getName());
        assertEquals("Lasagna", myRestaurant.getMenus().get(1).getMenuItems().get(1).getName());
        assertEquals("Garlic Bread", myRestaurant.getMenus().get(1).getMenuItems().get(2).getName());
        assertTrue(myRestaurant.getMenus().get(1).getMenuItems().get(2).getLabels().contains(MenuItemLabels.APPETIZER));
        assertEquals(3,myRestaurant.getMenus().get(0).getMenuItems().size());
        assertEquals(4,myRestaurant.getMenus().get(1).getMenuItems().size());
    }

    @Test
    public void testOrderSalad() {
        Restaurant myRestaurant = new Restaurant("Popmenu Restaurant");
        assertEquals(0, myRestaurant.getPendingItemsOrdered().size());
        MenuItem salad = new MenuItem("Chicken Salad");
        salad.addLabel(MenuItemLabels.DISH);
        salad.addLabel(MenuItemLabels.SIDEOFENTREE);
        MenuItem ranch = new MenuItem("Ranch");
        ranch.addLabel(MenuItemLabels.DRESSING);
        Order newOrder = new Order(myRestaurant);
        newOrder.orderSaladAndDressing(salad, ranch);
        assertEquals(2, newOrder.getOrderList().size());
        MenuItem entree = new MenuItem("Main Entree");
        entree.addLabel(MenuItemLabels.ENTREE);
        Order order2 = new Order(myRestaurant);
        assertEquals(0, order2.getOrderList().size());
        order2.orderSaladAsSide(entree, salad, ranch);
        assertEquals(3, order2.getOrderList().size());
        Order otherOrder = new Order(myRestaurant);
        assertEquals(0, otherOrder.getOrderList().size());
        otherOrder.orderSideCombo(ranch, entree, salad);
        assertEquals(3, otherOrder.getOrderList().size());
    }


}