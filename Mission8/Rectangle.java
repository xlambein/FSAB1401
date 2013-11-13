import java.awt.Graphics;
import java.awt.Color;

class Rectangle implements Shape
{
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Color color;
    
    /**
     * @pre  -
     * @post cree un {@code Rectangle} de couleur {@code color}
     * dont les coins sont les points ({@code x1}, {@code y1}) et ({@code x2}, {@code y2})
     */
    public Rectangle(int x1, int y1, int x2, int y2, Color color)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }
    
    /**
     * @pre  -
     * @post cree un {@code Rectangle} noir
     * dont les coins sont les points ({@code x1}, {@code y1}) et ({@code x2}, {@code y2})
     */
    public Rectangle(int x1, int y1, int x2, int y2)
    {
        this(x1, y1, x2, y2, Color.BLACK);
    }
    
    /**
     * @pre  {@code g} est initialise
     * @post dessine un rectangle sur {@code g}.
     */
    public void draw(Graphics g) {
        g.setColor(color);
        (new Segment(x1, y1, x2, y1)).draw(g);
        (new Segment(x1, y2, x2, y2)).draw(g);
        (new Segment(x1, y1, x1, y2)).draw(g);
        (new Segment(x2, y1, x2, y2)).draw(g);
    }
}