/**
 * Classe de test pour la classe Temps
 * 
 * @author Xavier Lambein & Victor Lecomte
 * @version Oct 2012
 */
public class TestTemps extends AbstractTest{
    
    public void runTests() {
        Temps t = new Temps(12, 34, 56);
        Temps t2 = new Temps(5, 12, 32);
        System.out.println(t);
        System.out.println(t2);
        
        test(t.toSecondes() == 45296, "toSecondes() doesn't work");
        test(t.delta(t2) == 26544, "delta() doesn't work");
        test(t.apres(t2) == true, "apres() doesn't work");
        t2.ajouter(t);
        test(t2.toSecondes() == 64048, "ajouter() doesn't work");
        test(t.toString().equals("12:34:56"), "toString() doesn't work");
        
        if(everythingWorksFine)
            System.out.println("Everything works fine!");
    }
    
    public static void main(String[] args) {
        (new TestTemps()).runTests();
    }

}
