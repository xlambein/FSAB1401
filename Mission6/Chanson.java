/**
 * Stores a song's information (author, title, length).
 * 
 * @author Xavier Lambein & Victor Lecomte
 * @version 2013-10-29
 */
class Chanson
{
    private String titre, auteur;
    private Temps duree;
    
    public Chanson(String t, String a, Temps d)
    {
        titre = t;
        auteur = a;
        duree = d;
    }
    
    public String getTitre()
    {
        return titre;
    }
    
    public String getAuteur()
    {
        return auteur;
    }
    
    public Temps getDuree()
    {
        return duree;
    }
    
    public String toString()
    {
        return String.format("%s - %s - %s", titre, auteur, duree);
    }
}
