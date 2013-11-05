/**
 * Classe de test pour la classe Facture
 * 
 * @author Charles Pecheur
 * @version 27 octobre 2012
 */
public class TestFacture {

	static Piece[] pieces = {
		new Piece("disque dur 350 Gb", 49.99, 0.355, true, false),
		new Piece("souris bluetooth", 15.99, 0.176, false, false),
		new Piece("adaptateur DVI - VGA", 12.00),
		new Piece("Java in a Nutshell", 24.00, 0.321, false, true),
	};

    static Article[] articles = {
        new Article("laptop 15\" 4Gb", 4.50),
        new Article("stage LaTeX", 12.0),
        new Article("installation wifi", 45.22),
        new Article("carte graphique", 119.49),
        /**/new ArticlePiece(pieces[0],1),
        new ArticlePiece(pieces[1],3),
        new ArticleReparation(0.75),
        new ArticlePiece(pieces[2],5),
        new ArticlePiece(pieces[3],2),
        new ArticlePiece(pieces[1],5),
    };
    
    public static void main(String[] args) {
        Facture fac = new Facture("PC store 22 octobre", articles);
        fac.printFacture();
        /**/fac.printLivraison();
        /**/for (int i = 0; i < pieces.length; i++) {
        	int n = fac.getNombre(pieces[i]);
        	System.out.printf("  %3d * %s\n", n, pieces[i].getDescription());
        }
    }
    
}
