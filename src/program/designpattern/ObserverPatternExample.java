package program.designpattern;

import java.util.ArrayList;
import java.util.List;

// Subject (WeatherStation)
interface WeatherStation {
    void registerObserver(WeatherObserver observer);
    void removeObserver(WeatherObserver observer);
    void notifyObservers();
}

// Concrete Subject
class ConcreteWeatherStation implements WeatherStation {
    private double temperature;
    private List<WeatherObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }

    // Simulate weather changes
    void setTemperature(double temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
}

// Observer
interface WeatherObserver {
    void update(double temperature);
}

// Concrete Observer
class DisplayDevice implements WeatherObserver {
    @Override
    public void update(double temperature) {
        System.out.println("Temperature updated: " + temperature);
        // Display logic here
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        ConcreteWeatherStation weatherStation = new ConcreteWeatherStation();
        DisplayDevice display1 = new DisplayDevice();
        DisplayDevice display2 = new DisplayDevice();

        weatherStation.registerObserver(display1);
        weatherStation.registerObserver(display2);

        // Simulate temperature change
        weatherStation.setTemperature(25.5); // Notifies both displays
    }
}
