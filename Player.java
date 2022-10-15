public class Player{
    String name;
    char Symbol;

    public char getSymbol(){
        return Symbol;
    }

    public String getName(){
        return name;
    }

    Player(String name,char Symbol){
        this.name = name;
        this.Symbol = Symbol;
    }
}