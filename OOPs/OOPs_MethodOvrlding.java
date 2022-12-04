public class OOPs_MethodOvrlding {
    public static void main(String[] args) {
        // Calculator c1 = new Calculator();
        // System.out.println(c1.sum(5, 9));
        // System.out.println(c1.sum((float) 5.5, (float) 0.5));
        // System.out.println(c1.sum(5, 9, 5));

        Animal d = new Animal();
        d.eat();
    }

}

class Calculator {
    int sum(int a, int b) {
        return a + b;
    }

    float sum(float a, float b) {
        return a + b;
    }

    int sum(int a, int b, int c) {
        return a + b + c;
    }
}

class Animal {
    void eat() {
        System.out.println("Eat anythings");
    }
}

class Deer extends Animal {
    void eat() {
        System.out.println("Eat Grass");
    }
}
