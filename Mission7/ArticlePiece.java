/**
 * Un article de facture représentant un certain nombre de pièces.
 * 
 * @author Xavier Lambein & Victor Lecomte 
 * @version 2013-11-05
 */
public class ArticlePiece extends Article
{
    private static final double TAUX_TVA_REDUITE = 0.06;
    private Piece piece;
    private int nombreDePieces;
    
    /**
     * Constructor for objects of class ArticlePiece
     */
    public ArticlePiece(Piece piece, int nombreDePieces)
    {
        super();
        this.piece = piece;
        this.nombreDePieces = nombreDePieces;
    }
    
    /**
     * @pre  -
     * @post retourne la piece de cet article.
     */
    public Piece getPiece() {
        return piece;
    }
    
    /**
     * @pre  -
     * @post retourne le nombre de pieces de cet article.
     */
    public int getNombreDePieces() {
        return nombreDePieces;
    }
    
    /**
     * @pre  -
     * @post retourne la masse totale des pieces de cet article.
     */
    public double getMasseTotale() {
        return nombreDePieces*piece.getMasse();
    }
    
    /**
     * @pre  -
     * @post retourne la description de cet article.
     */
    public String getDescription() {
        return String.format("%d * %s @ %.2f",
                             nombreDePieces,
                             piece.getDescription(),
                             piece.getPrix());
    }
    
    /**
     * @pre  -
     * @post retourne le prix (HTVA) de cet article.
     */
    public double getPrix() {
        return nombreDePieces * piece.getPrix();
    }
    
    /**
     * @pre  -
     * @post retourne la TVA sur cet article.
     */
    public double getTVA() {
        if(piece.isTVAReduite())
            return getPrix() * TAUX_TVA_REDUITE;
        else
            return super.getTVA();
    }
}
