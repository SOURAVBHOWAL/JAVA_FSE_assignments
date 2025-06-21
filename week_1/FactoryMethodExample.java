// Product interface
interface Animal {
    void speak();
}

// Concrete products
class Dog implements Animal {
    public void speak() {
        System.out.println("Woof!");
    }
}

class Cat implements Animal {
    public void speak() {
        System.out.println("Meow!");
    }
}

// Creator abstract class
abstract class AnimalFactory {
    public abstract Animal createAnimal();
}

// Concrete factories
class DogFactory extends AnimalFactory {
    public Animal createAnimal() {
        return new Dog();
    }
}

class CatFactory extends AnimalFactory {
    public Animal createAnimal() {
        return new Cat();
    }
}

// Client
public class FactoryMethodExample {
    public static void main(String[] args) {
        AnimalFactory factory1 = new DogFactory();
        Animal animal1 = factory1.createAnimal();
        animal1.speak();

        AnimalFactory factory2 = new CatFactory();
        Animal animal2 = factory2.createAnimal();
        animal2.speak();
    }
}
