
/**
 * Un article de facture representant une reparation d'une certaine duree.
 * 
 * @author Xavier Lambein & Victor Lecomte 
 * @version 2013-11-05
 */
public class ArticleReparation extends Article
{
    private double duree;
    private static final double PRIX_FIXE = 20;
    private static final double PRIX_HORAIRE = 35;
    
    /**
     * @pre  description != null
     * @post cree un article en réparation avec {description}, {prix} et {duree}.
     */
    public ArticleReparation(double duree) {
        super();
        this.duree = duree;
    }
    
    /**
     * @pre  -
     * @post retourne la description de cette reparation.
     */
    public String getDescription() {
        return String.format("Reparation (%.2f heures)", duree);
    }
    
    /**
     * @pre  -
     * @post retourne le prix (HTVA) de cette reparation.
     */
    public double getPrix() {
        return PRIX_FIXE+duree*PRIX_HORAIRE;
    }
}
