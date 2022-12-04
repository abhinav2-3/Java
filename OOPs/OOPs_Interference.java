public class OOPs_Interference {
    public static void main(String[] args) {
        Queen q = new Queen();
        q.moves();
        Rook R = new Rook();
        R.moves();
        King k = new King();
        k.moves();
        // c1.seat();
    }
}

interface chessplayer {
    void moves();
}

class Queen implements chessplayer {
    public void moves() {
        System.out.println("Up, Down, Left, Right, Diagonal (in all 4 direction");
    }
}

class Rook implements chessplayer {
    public void moves() {
        System.out.println("Up, Down, Left, Right");
    }
}

class King implements chessplayer {
    public void moves() {
        System.out.println("Up, Down, Left, Right, Diagonal (By 1 step");
    }
}