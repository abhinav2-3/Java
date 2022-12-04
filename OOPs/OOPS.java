public class OOPS {
    public static void main(String[] args) {
        pen p1 = new pen();
        pen p2 = new pen();

        p1.setcolour("Blue");
        System.out.println(p1.colour);
        p1.settip(5);
        System.out.println(p1.tip);
        // p1.setcolour("yellow");
        p1.colour = "Yellow";
        System.out.println(p1.colour);
        p2.setcolour("Green");
        System.out.println(p2.colour);
        p2.settip(3);
        System.out.println(p2.tip);

        BankAccount Myacc = new BankAccount();
        Myacc.setPassword("12313434");
        Myacc.setUsername("ABhinav");
        System.out.println(Myacc.getPassword());
        System.out.println(Myacc.getUsername());
    }
}

class pen {
    // Qualities
    String colour;
    int tip;

    // Functions
    void setcolour(String newcolour) {
        colour = newcolour;
    }

    void settip(int newtip) {
        tip = newtip;
    }
}

class BankAccount {
    private String Username;
    private String Password;

    String getUsername() {
        return this.Username;
    }

    String getPassword() {
        return this.Password;
    }

    void setUsername(String newUsename) {
        this.Username = newUsename;
    }

    void setPassword(String Pwd) {
        this.Password = Pwd;
    }
}