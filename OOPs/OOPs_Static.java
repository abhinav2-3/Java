public class OOPs_Static {
    public static void main(String[] args) {
        student s1 = new student();
        s1.Name = "Abhinav Maurya";
        System.out.println(s1.Name);
        s1.Roll = 3;
        System.out.println(s1.Roll);
        s1.CollegeName = "AIMT";
        System.out.println(s1.CollegeName);

        student s2 = new student();
        s2.Name = "Aajad Verma";
        System.out.println(s2.Name);
        s2.Roll = 1;
        System.out.println(s2.Roll);
        System.out.println(s2.CollegeName);

    }
}

class student {
    String Name;
    int Roll;
    static String CollegeName;

    void setName(String Name) {
        this.Name = Name;
    }

    String getName() {
        return this.Name;
    }
}