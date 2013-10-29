/**
 * Stores time in hh:mm:ss format.
 * 
 * @author Xavier Lambein & Victor Lecomte
 * @version 2013-10-29
 */
public class Temps
{
    private int secondes;
    
    public Temps(int h, int m, int s)
    {
        assert h >= 0 : "h must be nonnegative";
        assert m >= 0 : "m must be nonnegative";
        assert m < 60 : "m must be strictly inferior to 60";
        assert s >= 0 : "s must be nonnegative";
        assert s < 60 : "s must be strictly inferior to 60";
        secondes = (h*60+m)*60+s;
    }
    
    public int getSecondes()
    {
        return secondes%60;
    }
    
    public int getMinutes()
    {
        return (secondes/60)%60;
    }
    
    public int getHeures()
    {
        return secondes/3600;
    }
    
    public void setSecondes(int s)
    {
        assert s >= 0 : "s must be nonnegative";
        assert s < 60 : "s must be strictly inferior to 60";
        secondes = secondes - secondes%60 + s;
    }
    
    public void setMinutes(int m)
    {
        assert m >= 0 : "m must be nonnegative";
        assert m < 60 : "m must be strictly inferior to 60";
        secondes = secondes - ((secondes/60)%60)*60 + m*60;
    }
    
    public void setHeures(int h)
    {
        assert h >= 0 : "h must be nonnegative";
        secondes = secondes % 3600 + h*3600;
    }
    
    public int toSecondes()
    {
        return secondes;
    }
    
    public int delta(Temps t)
    {
        return secondes-t.secondes;
    }
    
    public boolean apres(Temps t)
    {
        return (secondes > t.secondes);
    }
    
    public void ajouter(Temps t)
    {
        secondes += t.secondes;
    }
    
    public String toString()
    {
        return String.format("%02d:%02d:%02d", getHeures(), getMinutes(), getSecondes());
    }
}
