/**
 * Main class.
 * 
 * @author Xavier Lambein & Victor Lecomte
 * @version 2013-10-29
 */
class Programme
{
    static int albumCount = 0;
    
    /**
     * @pre -
     * @post Prints an album's length and songs and increments albumCount.
     */
    public static void printAlbum(Chanson[] album, int count, Temps dureeTotale)
    {
        albumCount++;
        System.out.printf("Album %d (%d chansons, %s)\n", albumCount, count, dureeTotale.toString());
        for(int i = 0; i < count; i++)
            System.out.printf("%d: %s - %s - %s\n", i+1, album[i].getTitre(), album[i].getAuteur(), album[i].getDuree());
        System.out.println();
    }

    /**
     * @pre If it exists, args[0] contains a valid filename.
     * @post Organizes the songs provided in the file args[0] or in the standard input.
     *       Prints the songs as albums of max. 75min or 100 songs.
     */
    public static void main(String[] args)
    {
        // If the user passes a filename, we read from it
        boolean amIReadingAFile = false;
        if(args.length > 0)
        {
            TextIO.readFile(args[0]);
            amIReadingAFile = true;
        }
        
        Chanson current = null;
        do
        {
            Chanson[] album = new Chanson[100];
            Temps dureeTotale = new Temps(0,0,0);
            int count = 0;
            try {
                // Let's not get more than 100 songs, that would break the array
                while(count < 100)
                {
                    // Add the current song to the album
                    if(current != null)
                    {
                        dureeTotale.ajouter(current.getDuree());
                        album[count] = current;
                        count++;
                    }
                    current = null;
                    
                    // Read the title and the author of the song
                    String titre = TextIO.getWord();
                    String auteur = TextIO.getWord();
                    
                    // Read the minutes until it's between 0 and 59
                    int minutes = -1;
                    while(minutes < 0 || minutes > 60)
                    {
                        minutes = TextIO.getInt();
                    }
                    
                    // Read the seconds until it's between 0 and 59
                    int secondes = -1;
                    while(secondes < 0 || secondes > 60)
                    {
                        secondes = TextIO.getInt();
                    }
                    
                    Temps duree = new Temps(0, minutes, secondes);
                    
                    // Set the current song with the data we just got
                    current = new Chanson(titre, auteur, duree);
                    
                    // If it's over 75min, we break the loop without adding the song
                    if(dureeTotale.toSecondes()+duree.toSecondes() > 75*60)
                        break;
                }
            }
            // If we reach the end of file, a IllegalArgumentException is thrown.
            catch(IllegalArgumentException e){}
            
            printAlbum(album, count, dureeTotale);
        }
        // If we are reading a file, then we make multiple albums. Otherwise, we only make one.
        while(amIReadingAFile && !TextIO.eof());
    }
}
