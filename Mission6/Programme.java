class Programme
{
    public static void printAlbum(Chanson[] album, int count)
    {
        System.out.println("Album 1 (%d chansons, %s)", count, dureeTotale);
        for(int i = 0; i < count; i++)
            System.out.println("%d: %s - %s - %s", i+1, album[i].getTitre(), album[i].getAuteur(), album[i].getDuree());
        System.out.println();
    }

    public static void main(String[] args)
    {
        Chanson[] album = new Chanson[100];
        Temps dureeTotale = new Temps();
        int count = 0;
        while(count < 100 && dureeTotale.minutes() <= 75)
        {
            String titre = TextIO.getString();
            String auteur = TextIO.getString();
            int minutes = -1;
            while(minutes < 0 || minutes > 60)
            {
                int minutes = TextIO.getInt();
            }
            int secondes = -1;
            while(secondes < 0 || secondes > 60)
            {
                int secondes = TextIO.getInt();
            }
            Temps duree = new Temps(0, minutes, secondes);
            
            Chanson[count] = new Chanson(titre, auteur, duree);
            
            count++;
            dureeTotale.ajouter(duree);
        }
        
        printAlbum(album, count);
    }
}
