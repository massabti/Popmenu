import java.util.HashSet;
import java.util.Set;

public class MenuItem {

    private String name;
    private String description;
    private double price;
    private int calories;
    private Set<MenuItemLabels> labels;
    //menu Item picture?
    //menut Item rating (out of 5 stars?)
    //space for reviews?


    public MenuItem(String name, String description, double price, int calories, Set<MenuItemLabels> labels) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.calories = calories;
        if (labels == null) {
            this.labels = new HashSet<MenuItemLabels>();
        } else {
            this.labels = labels;
        }
    }

    public MenuItem(String name) {
        this.name = name;
        description = "";
        price = 0.0;
        calories = 0;
        labels = new HashSet<MenuItemLabels>();
    }

    public MenuItem() {
        name = "Unnamed Item";
        description = "";
        price = 0.0;
        calories = 0;
        labels = new HashSet<MenuItemLabels>();
    }


    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String newDescription) {
        name = newDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        price = newPrice;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int newCalories) {
        calories = newCalories;
    }

    public Set<MenuItemLabels> getLabels() {
        return labels;
    }

    public void setLabels(Set<MenuItemLabels> labelsSet) {
        labels = labelsSet;
    }

    public void addLabel(MenuItemLabels newLabel) {
        labels.add(newLabel);
    }
}
