package program.designpattern;

// Abstract factory interface
 interface EraAnimalFactory {
    LandAnimal makeLandAnimal();
    SkyAnimal makeSkyAnimal();
}

// Concrete factory classes
 class CenozoicAnimalFactory implements EraAnimalFactory {
    @Override
    public LandAnimal makeLandAnimal() {
       return new LandAnimal();
    }

    @Override
    public SkyAnimal makeSkyAnimal() {
       return new SkyAnimal();
    }
}

 class MesozoicAnimalFactory implements EraAnimalFactory {
    @Override
    public LandAnimal makeLandAnimal() {
       return new LandAnimal();
    }

    @Override
    public SkyAnimal makeSkyAnimal() {
       return new SkyAnimal();
    }
}

// Abstract product class
 abstract class Animal {
    // Common attributes and abstract create() method
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// Concrete product classes
 class LandAnimal extends Animal {
    // Implementation for creating land animals
}

 class SkyAnimal extends Animal {
    // Implementation for creating sky animals
}

class AbstractFactory{
    public static void main(String[] args) {
        EraAnimalFactory cenozoicFactory = new CenozoicAnimalFactory();

        // Create a Cenozoic land animal
        LandAnimal cenozoicLandAnimal = cenozoicFactory.makeLandAnimal();
        System.out.println("Cenozoic Land Animal: " + cenozoicLandAnimal.getName());
    }
}
