import java.util.*;
public class Game {
    Player[] players;
    Board board;
    int turn;
    int noofmoves;
    boolean gameOver;
    String zero;
    String cross;

    Scanner scn = new Scanner(System.in);

    public Game(Player[] players,Board board){
        this.players = players;
        this.board = board;
        this.turn = 0;
        this.noofmoves = 0;
        this.gameOver = false;
        StringBuilder z = new StringBuilder();
        StringBuilder c = new StringBuilder();
        for(int i=0;i<board.size;i++){
            z.append('O');
            c.append('X');
        }
        zero = z.toString();
        cross = c.toString();
    }

    public void printBoard(){
        for(char[] oneD : board.board){
            for(char c : oneD){
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }

    public void play(){
        printBoard();
        while(!this.gameOver){
            this.noofmoves++;
            int idx =  getIndex();
            int row = idx/board.size;
            int col = idx%board.size;
            board.board[row][col] = players[turn].getSymbol();
            if(this.noofmoves == board.size * board.size){
                printBoard();
                System.out.println("No winner");
                return;
            }
            if(this.noofmoves >= 2 * board.size-1 && check_if_ended() == true){
                gameOver = true;
                System.out.println(players[turn].getName()+" has won!!!");
                return;
            }
            turn = (turn+1)%2;
            printBoard();
        }
    }

    public boolean check_if_ended(){

        // ROW-WISE TRAVERSAL
        StringBuilder sb;
        int n = board.size;
        for(int i=0;i<n;i++){
            sb = new StringBuilder();
            for(int j=0;j<n;j++){
                sb.append(board.board[i][j]);
            }
            String rowString = sb.toString();
            if(rowString.equals(zero) || rowString.equals(cross)){
                return true;
            }
        }

        // COLUMN-WISE TRAVERSAL
        for(int i=0;i<n;i++){
            sb = new StringBuilder();
            for(int j=0;j<n;j++){
                sb.append(board.board[j][i]);
            }
            String colString = sb.toString();
            if(colString.equals(zero) || colString.equals(cross)){
                return true;
            }
        }

        // MAJOR-DIAGNOL TRAVERSAL
        int i=0;
        int j=0;
        sb = new StringBuilder();
        while(i < n){
            sb.append(board.board[i][j]);
            i++;
            j++;
        }
        String majordiagString = sb.toString();
        if(majordiagString.equals(zero) || majordiagString.equals(cross)){
            return true;
        }

        // MINOR-DIAGNOL TRAVERSAL
        i=0;
        j=n-1;
        sb = new StringBuilder();
        while(i < n){
            sb.append(board.board[i][j]);
            i++;
            j--;
        }
        String minordiagString = sb.toString();
        if(minordiagString.equals(zero) || minordiagString.equals(cross)){
            return true;
        }

        return false;
    }


    public int getIndex(){
        while(true){
            int pos = scn.nextInt()-1;
            int n = board.size;
            int rn = pos/n;
            int cn = pos%n;
            if(rn < 0 || cn < 0 || rn >= n || cn >= n){
                System.out.println("Invalid Position");
                continue;
            }
            if(board.board[rn][cn] != '-'){
                System.out.println("Position already filled");
                continue;
            }
            return pos;
        }
    }
}
