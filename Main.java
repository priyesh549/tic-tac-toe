public class Main{
    public static void main(String[] args) {
        Player p1 = new Player("Priyes",'X');
        Player p2 = new Player("Anushka",'O');

        Board board = new Board(3);
        Game game = new Game(new Player[]{p1,p2},board);
        game.play();
    }
}
