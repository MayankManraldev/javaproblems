package program.designpattern;

// MotorVehicle interface
 interface MotorVehicle {
    void build();
}

// Concrete classes
 class Motorcycle implements MotorVehicle {
    @Override
    public void build() {
        System.out.println("Build Motorcycle");
    }
}

 class Car implements MotorVehicle {
    @Override
    public void build() {
        System.out.println("Build Car");
    }
}

// Abstract factory class
 abstract class MotorVehicleFactory {
    public MotorVehicle create() {
        MotorVehicle vehicle = createMotorVehicle();
        vehicle.build();
        return vehicle;
    }

    protected abstract MotorVehicle createMotorVehicle();
}

// Concrete factory classes
 class MotorcycleFactory extends MotorVehicleFactory {
    @Override
    protected MotorVehicle createMotorVehicle() {
        return new Motorcycle();
    }
}

 class CarFactory extends MotorVehicleFactory {
    @Override
    protected MotorVehicle createMotorVehicle() {
        return new Car();
    }
}

class FactoryDesignPattern{
    public static void main(String[] args) {
        MotorVehicleFactory motorVehicleFactory=new MotorcycleFactory();
        MotorVehicle motorVehicle = motorVehicleFactory.create();
        System.out.println(motorVehicle);
    }
}
