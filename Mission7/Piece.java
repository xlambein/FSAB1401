
/**
 * Une piece simple, comprenant un descriptif, un prix, une masse, et qui indique si elle est
 * fragile et à TVA réduite.
 * 
 * @author Xavier Lambein & Victor Lecomte 
 * @version 2013-11-05
 */
public class Piece
{
    private String description;
    private double prix;
    private double masse;
    private boolean fragile;
    private boolean tvaReduite;
    
    /**
     * @pre  description != null
     * @post cree une piece avec {description}, {prix}, {masse}, {fragile}, {tvaReduite}.
     */
    public Piece(String description, double prix, double masse, boolean fragile, boolean tvaReduite) {
        this.description = description;
        this.prix = prix;
        this.masse = masse;
        this.fragile = fragile;
        this.tvaReduite = tvaReduite;
    }
    
    /**
     * @pre  description != null
     * @post cree une piece avec {description} et {prix}.
     */
    public Piece(String description, double prix) {
        this.description = description;
        this.prix = prix;
        this.masse = 0;
        this.fragile = false;
        this.tvaReduite = false;
    }
    
    /**
     * @pre  -
     * @post retourne la description de cette piece.
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * @pre  -
     * @post retourne le prix (HTVA) de cette piece.
     */
    public double getPrix() {
        return prix;
    }
    
    /**
     * @pre  -
     * @post retourne la masse de cette piece.
     */
    public double getMasse() {
        return masse;
    }
    
    /**
     * @pre  -
     * @post retourne la fragilite de cette piece.
     */
    public boolean isFragile() {
        return fragile;
    }
    
    /**
     * @pre  -
     * @post retourne si la piece a une TVA reduite.
     */
    public boolean isTVAReduite() {
        return tvaReduite;
    }
    
    /**
     * @pre  -
     * @post retourne un texte decrivant cet article, au format:
     *       "{description}: {prix}".
     */
    public String toString() {
        return String.format("%s: %.2f", getDescription(), getPrix());
    }
    
    public boolean equals(Object obj) {
        if (obj==this)
            return true;
 
        if (obj instanceof Piece)
        {
            Piece other = (Piece) obj;
            
            if(other.getPrix() == getPrix()
            && other.getDescription().equals(getDescription()))
                return true;
        }
        
        return false;
    }
}
