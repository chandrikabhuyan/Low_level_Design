package org.example.Solid.InterfaceSegregation;

public interface RestaurantEmployee {
    void cookFood();
    void serveCustomers();
    void washDishes();
}

class Waiter implements RestaurantEmployee{
    @Override
    public void cookFood() {

    }
    @Override
    public void serveCustomers() {
        System.out.println("Serving Customers");
    }
    @Override
    public void washDishes() {

    }
}
//Here methods that are not required are also being implemented. Thus principle is not followed. Eg waiter doesn't washDishes or cookFood
//but still he has to implement those methods.
//Break down interfaces into multiple interfaces.

interface WaiterInterface{
    void serveCustomers();
    void takeOrders();
}

interface ChefInterface{
    void cookFood();
    void decideMenu();
}