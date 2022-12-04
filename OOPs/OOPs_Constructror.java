public class OOPs_Constructror {
    public static void main(String[] args) {
        student s1 = new student();
        s1.name = "Abhinav Maurya";
        s1.Rollno = 10;
        s1.Passward = "abcdefg";
        s1.marks[0] = 100;
        s1.marks[1] = 98;
        s1.marks[2] = 95;

        student s4 = new student(s1); // Copy S1 To S4
        s4.Passward = "xyz";
        s1.marks[1] = 105;
        for (int i = 0; i < 3; i++) {
            System.out.println(s4.marks[i]);
        }
        student s2 = new student("Abhinav");
        student s3 = new student(110);

        // System.out.println(s4.name);
        // System.out.println(s4.Rollno);
        // System.out.println(s4.Passward);

        // boys b1 = new boys();
    }
}

class student {
    String name;
    int Rollno;
    String Passward;
    int marks[];

    // Shalow Copy Constructor
    // student(student s1) {
    // this.name = s1.name;
    // this.Rollno = s1.Rollno;
    // marks = new int[3];
    // this.marks = s1.marks;
    // }
    // Deep copy Constructor
    student(student s1) {
        marks = new int[3];
        this.name = s1.name;
        this.Rollno = s1.Rollno;
        for (int i = 0; i < marks.length; i++) {
            this.marks[i] = s1.marks[i];
        }
    }

    student() { // Non - Parameterized
        System.out.println("This is Non - Parameterized Cunstructor");
        marks = new int[3];
    }

    student(String Name) { // Parameterized
        this.name = Name;
        marks = new int[3];
    }

    student(int roll) {
        this.Rollno = roll;
        marks = new int[3];
    }
}

class boys {
    String Name;
    int Age;

    boys() {
        System.out.println("Constructor is Called......");
    }
}
