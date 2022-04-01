import java.util.HashMap;

public class Customer {

    private Restaurant restaurant;
    public int[] dayFreq;
    private double[] probArr;
    // size 7 , ind 0 = Monday, ind1 = Tues, ind2 = Wed
    private HashMap<MenuItem, Integer> dishFreqOrdered;
    private HashMap<MenuItem, Double> dishProb;
    int itemsInRestaurantCount = 0;

    public Customer() {
        dayFreq = new int[7];
        probArr = new double[7];
        for (int i = 0; i < probArr.length; i++) {
            probArr[i] = 1.0/7;
        }


        for (Menu singleMenu: restaurant.getMenus()) {
            for (MenuItem singleItem: singleMenu.getMenuItems()) {
                dishFreqOrdered.put(singleItem, 0);
                itemsInRestaurantCount += 1;
            }
        }

        for (Menu singleMenu: restaurant.getMenus()) {
            for (MenuItem singleItem: singleMenu.getMenuItems()) {
                dishProb.put(singleItem, 1.0 / itemsInRestaurantCount);
            }
        }


    }

    public void visit(int Day) {
        dayFreq[Day] += 1;
        updateProbArr(Day);
    }

    public double calcProbDay(int Day) {
        double[] probDayArr = new double[7];
        int sumTotalDays = 0;
        for (int i = 0; i < 7; i++) {
            sumTotalDays += dayFreq[i];
            probDayArr[i] = dayFreq[i] + 0.1;
        }
        for (int i = 0; i < 7; i++) {
            probDayArr[i] /= sumTotalDays + 0.7;
        }
        return probDayArr[Day];
    }
    public void updateProbArr(int Day) {
        for (int i = 0; i < 7; i++) {
            if (i == Day) {
                continue;
            }
            probArr[i] -= (probArr[Day] * 0.5) / 6;
        }
        probArr[Day] = probArr[Day] + 0.5 * probArr[Day];
    }

    public void orderedItem(MenuItem itemOrdered) {
        dishFreqOrdered.put(itemOrdered, 1 + dishFreqOrdered.get(itemOrdered));
        updateDishProb(itemOrdered);
    }

    public void updateDishProb(MenuItem dish) {
        for (Menu singleMenu: restaurant.getMenus()) {
            for (MenuItem singleItem: singleMenu.getMenuItems()) {
                if (singleItem != dish) {
                    dishProb.put(singleItem, dishProb.get(singleItem) - dishProb.get(dish) * 0.5 / itemsInRestaurantCount);
                }
            }
        }
        dishProb.put(dish, dishProb.get(dish) + dishProb.get(dish) * 0.5);
    }






}
