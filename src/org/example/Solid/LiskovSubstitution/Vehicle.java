package org.example.Solid.LiskovSubstitution;

import java.util.ArrayList;
import java.util.List;

//The LSP helps guide the use of inheritance in design so that the application does not break.
// It states that the objects of a subclass should behave the same way as the objects of the superclass, such that they are replaceable.

public class Vehicle {
    public Boolean hasEngine(){
        return true;
    }
    public Integer numOfWheels(){
        return 2;
    }
}
class Car extends Vehicle{
    public Integer numOfWheels(){
        return 4;
    }
}

class Bicycle extends Vehicle{
    public Boolean hasEngine(){
        return null;
    }
}

class Motorcycle extends Vehicle{

}

class Main{
    public static void main(String[] args) {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Car());
        vehicleList.add(new Motorcycle());
        vehicleList.add(new Bicycle());
        for(Vehicle vehicle:vehicleList){
            System.out.println(vehicle.hasEngine().toString()); // here for hasEngine() method bicyle returns null so it throws NULL pointer exception
        }
    }
}
// so now we change the code to such that replacing the child code with the parent doesn't break the code.

class Vehicle1 {
    public Integer numOfWheels(){
        return 2;
    }
}

class EngineVehicle extends Vehicle1{
    public Boolean hasEngine(){
        return true;
    }
}
class Bicycle1 extends Vehicle1{

}

class Car1 extends EngineVehicle{

}
class Motorcycle1 extends EngineVehicle{

}

class MainNew{
    public static void main(String[] args) {
        List<Vehicle1> vehicleList = new ArrayList<>();
        vehicleList.add(new Car1());
        vehicleList.add(new Motorcycle1());
        vehicleList.add(new Bicycle1());
        for(Vehicle1 vehicle:vehicleList){
            //System.out.println(vehicle.hasEngine().toString()); // here we get compile time error because Vehicle do not have hasEngine() method which saves the code from breaking.
        }
    }
}

//just for example
class MainNewExample{
    public static void main(String[] args) {
        List<EngineVehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Car1());
        vehicleList.add(new Motorcycle1());
        //vehicleList.add(new Bicycle1());
        for(EngineVehicle vehicle:vehicleList){
            System.out.println(vehicle.hasEngine().toString());
        }
    }
}