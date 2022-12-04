public class OOPs_Inhetance {
    public static void main(String[] args) {
        Fish shark = new Fish();
        shark.eat();
        shark.breathe();
        shark.Swim();
        Mammle Dog = new Mammle();
        Dog.Walk();
        Bird Parrot = new Bird();
        Parrot.Fly();
        Parrot p1 = new Parrot();
        p1.Talented();
        p1.Fly();
        p1.eat();
    }
}

// InnerInheritance
// Base Class
class Animal {
    String colour;

    void eat() {
        System.out.println("Eat");
    }

    void breathe() {
        System.out.println("Breathe");
    }
}

// Derived Class
class Fish extends Animal {
    int fins;

    void Swim() {
        System.out.println("Swim");
    }
}

class shark extends Fish {
    void Save() {
        System.out.println("Save People");
    }
}

class Mammle extends Animal {
    int legs;

    void Walk() {
        System.out.println("Walk");
    }
}

class Dog extends Mammle {
    void security() {
        System.out.println("Security");
    }
}

class Bird extends Animal {
    void Fly() {
        System.out.println("Fly");
    }
}

class Parrot extends Bird {
    void Talented() {
        System.out.println("Sing a song");
    }
}
