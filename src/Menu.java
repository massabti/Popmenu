import java.util.ArrayList;

public class Menu {

    private String name;
    private ArrayList<MenuItem> menuItems;


    public Menu() {
        name = "Unnamed menu";
        menuItems = new ArrayList<MenuItem>();
    }

    public Menu(String name) {
        this.name = name;
        menuItems = new ArrayList<MenuItem>();
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(ArrayList<MenuItem> menuItems) {
        menuItems = new ArrayList<MenuItem>();
        for (MenuItem singleItem: menuItems) {
            addMenuItem(singleItem);
        }
    }

    public void addMenuItem(MenuItem newItem) {
        boolean dupFound = false;
        for (MenuItem item: menuItems) {
            if (newItem.getName().equals(item.getName())) {
                    dupFound = true;
                    break;
            }
        }
        if (!dupFound) {
            menuItems.add(newItem);
        }

    }


}

