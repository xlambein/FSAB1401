/**
 * Classe de test pour la classe Chanson
 * 
 * @author Xavier Lambein & Victor Lecomte
 * @version 2013-10-29
 */
public class TestChanson extends AbstractTest {
    
    public void runTests() {
        // Hommage à une grande Rock Star, décédée il y a peu... =/
		Chanson ch = new Chanson("Walk on the wild side", "Lou Reed", new Temps(0,4,15));
		System.out.println(ch);
        
        test(ch.getTitre().equals("Walk on the wild side"), "getTitre() doesn't work");
        test(ch.getAuteur().equals("Lou Reed"), "getAuteur() doesn't work");
        test(ch.getDuree().toSecondes() == 255, "getDuree() doesn't work");
        test(ch.toString().equals("Walk on the wild side - Lou Reed - 00:04:15"), "toString() doesn't work");
        
        if(everythingWorksFine)
            System.out.println("Everything works fine!");
    }
    
    public static void main(String[] args) {
        (new TestChanson()).runTests();
    }

}