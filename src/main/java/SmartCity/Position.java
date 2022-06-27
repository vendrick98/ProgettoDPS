package SmartCity;

public class Position {
    public int ascissa ;
    public int ordinata;
    public Position(int x, int y){
        this.ascissa = x;
        this.ordinata = y;
    }
    @Override
    public String toString(){
        return "ascissa: " + ascissa + " ordinata: " + ordinata;
    }

}
