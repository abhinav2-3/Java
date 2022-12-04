public class OOPsAbstract {
    public static void main(String[] args) {
        horse h = new horse();
        h.eat();
        h.Walk();
        System.out.println(h.color);

        human man = new human();
        man.eat();
        man.Walk();
    }
}

abstract class Animal {
    String color;

    Animal() {
        color = "Brown";
    }

    void eat() {
        System.out.println("Animal Eat");
    }

    abstract void Walk();
}

class horse extends Animal {
    void change() {
        color = "Dark brown";

    }

    void Walk() {
        System.out.println("They walk on 4 legs");
    }
}

class human extends Animal {
    void changecolor() {
        System.out.println("Yellowsish");
    }

    void Walk() {
        System.out.println("They walk on 2 legs");
    }
}
