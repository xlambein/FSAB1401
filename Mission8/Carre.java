import java.awt.Color;

class Carre extends Rectangle
{
    /**
     * @pre  -
     * @post cree un {@code Carre} de couleur {@code color} et de cote {@code side}
     * situé au coin ({@code x}, {@code y})
     */
    public Carre(int x, int y, int side, Color color)
    {
        super(x, y, x+side, y+side, color);
    }
    
    /**
     * @pre  -
     * @post cree un {@code Carre} noir et de cote {@code side}
     * situé au coin ({@code x}, {@code y})
     */
    public Carre(int x, int y, int side)
    {
        this(x, y, side, Color.BLACK);
    }
}
