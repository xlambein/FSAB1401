/**
 * Une facture, sous forme d'une liste d'articles.
 * 
 * @author Charles Pecheur, Xavier Lambein & Victor Lecomte
 * @version 2013-11-05
 */
public class Facture {

    private Article[] articles;
    private String reference;
    private int numero;
    private static int nombreFactures = 0;

    /**
     * @pre  reference != null
     * @post A cree une facture avec {description} et {articles}.
     */
    public Facture(String reference, Article[] articles) {
        nombreFactures++;
        this.numero = nombreFactures;
        this.reference = reference;
        this.articles = articles;
    }

    /**
     * @pre  -
     * @post A imprime la facture.
     */
    public void printFacture() {
        printEntete();
        double totalPrix = 0.0;
        double totalTVA = 0.0;
        for(int i = 0; i < articles.length; i++) {
            Article art = articles[i];
            printArticle(art);
            totalPrix = totalPrix + art.getPrix();
            totalTVA = totalTVA + art.getTVA();
        }
        printTotaux(totalPrix, totalTVA);
        System.out.println();
    }

    /**
     * @pre  -
     * @post A imprime l'en-tete de la facture, comprenant le descriptif
     *       et les tetes de colonnes.
     */
    public void printEntete() {
        System.out.printf("Facture No %d : %s\n", numero, reference);
        System.out.println();
        printBarre();
        System.out.println("| Description                              |  prix HTVA |        TVA |  prix TVAC |");
        printBarre();
    }

    /**
     * @pre  -
     * @post A imprime l'en-tete de livraison de la facture, comprenant le descriptif
     *       et les tetes de colonnes.
     */
    public void printEnteteLivraison() {
        System.out.printf("Livraison - Facture No %d : %s\n", numero, reference);
        System.out.println();
        printBarre();
        System.out.println("| Description                              |  poids/pce |     nombre |      masse |");
        printBarre();
    }

    /**
     * @pre  -
     * @post A imprime une barre sur la largeur de la facture.
     */
    public void printBarre() {
        System.out.println("===================================================================================");
    }

    /**
     * @pre  -
     * @post A imprime une ligne de facture pour l'article {art}.
     */
    public void printArticle(Article art) {
        System.out.printf("| %-40s | %10.2f | %10.2f | %10.2f |\n",
            art.getDescription(), art.getPrix(), art.getTVA(), art.getPrixTVAC());
    }

    /**
     * @pre  -
     * @post A imprime une ligne de facture pour l'article {art}.
     */
    public void printArticleLivraison(ArticlePiece art) {
        String description = art.getPiece().getDescription();
        if(art.getPiece().isFragile())
            description += " (!)";
        System.out.printf("| %-40s | %8.3fkg | %10d | %8.3fkg |\n",
            description, art.getPiece().getMasse(), art.getNombreDePieces(), art.getMasseTotale());
    }
    
    /**
     * @pre  -
     * @post A imprime une ligne de facture avec les totaux {prix} et {tva}.
     */
    public void printTotaux(double prix, double tva) {
        printBarre();
        System.out.printf("| %-40s | %10.2f | %10.2f | %10.2f |\n",
            "T O T A L", prix, tva, prix+tva);
    }
    
    /**
     * @pre  -
     * @post A imprime une ligne de livraison avec les totaux {nombreArticles}, {nombrePieces} et {masse}.
     */
    public void printTotauxLivraison(int nombreArticles, int nombrePieces, double masse) {
        printBarre();
        System.out.printf("| %-40s |            | %10d | %8.3fkg |\n",
            nombreArticles+" articles", nombrePieces, masse);
    }

    /**
     * @pre  -
     * @post A imprime une liste de livraison, comprenant toutes les
     *       pieces facturees avec leur poids.
     */
    public void printLivraison() {
        printEnteteLivraison();
        int totalNombreArticles = 0;
        int totalNombrePieces = 0;
        double totalMasse = 0.0;
        for(Article article : articles)
        {
            if (article instanceof ArticlePiece)
            {
                ArticlePiece art = (ArticlePiece) article;
                
                printArticleLivraison(art);
                totalNombrePieces += art.getNombreDePieces();
                totalMasse += art.getMasseTotale();
                totalNombreArticles++;
            }
        }
        printTotauxLivraison(totalNombreArticles, totalNombrePieces, totalMasse);
        System.out.println(" (!) *** livraison fragile ***\n");
    }

    /**
     * @pre  pce != null
     * @post Retourne le nombre d'exemplaires de {pce} factures,
     *       en totalisant sur plusieurs articles si necessaire.
     */
    public int getNombre(Piece pce) {
        int count = 0;
        for(Article article : articles)
        {
            if (article instanceof ArticlePiece)
            {
                ArticlePiece artPiece = (ArticlePiece) article;
                if(artPiece.getPiece().equals(pce))
                    count += artPiece.getNombreDePieces();
            }
        }
        
        return count;
    }
}
