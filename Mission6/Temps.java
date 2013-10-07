public class Temps
{
    private int secondes;
    
    public Temps(int h = 0, int m = 0, int s = 0)
    {
        assert h >= 0 : "h must be positive";
        assert m >= 0 : "m must be positive";
        assert m < 60 : "m must be strictly inferior to 60";
        assert s >= 0 : "s must be positive";
        assert s < 60 : "s must be strictly inferior to 60";
        secondes = (h*60+m)*60+s;
    }
    
    public int secondes()
    {
        return secondes%60;
    }
    
    public int minutes()
    {
        return (secondes/60)%60;
    }
    
    public int heures()
    {
        return secondes/3600;
    }
    
    public void setSecondes(int s)
    {
        assert s >= 0 : "s must be positive";
        assert s < 60 : "s must be strictly inferior to 60";
        secondes = secondes - secondes%60 + s;
    }
    
    public void setMinutes(int m)
    {
        assert m >= 0 : "m must be positive";
        assert m < 60 : "m must be strictly inferior to 60";
        secondes = secondes - ((secondes/60)%60)*60 + m*60;
    }
    
    public void setHeures(int h)
    {
        assert h >= 0 : "h must be positive";
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
        return String.format("%02d:%02d:%02d", heures(), minutes(), secondes());
    }
}
