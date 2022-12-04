public class OOPs_Super {
    public static void main(String[] args) {
        Horse h = new Horse();
        System.out.println(h.Colour);
    }
}

class Animal {
    String Colour;

    Animal() {
        System.out.println("Animal costructor is called");
    }
}

class Horse extends Animal {
    Horse() {
        super.Colour = "White";
        System.out.println("Horse Costructor is called");
    }
}