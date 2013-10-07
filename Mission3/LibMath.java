/*
 *
 * @author: VOUS
 * @version: Octobre 2013
 */

public class LibMath
{
    /**
     * @pre -
     * @post returns the average of numbers a,b,c.
     */
    public static double average(double a, double b, double c)
    {
        return (a+b+c)/3;
    }
    
    /**
     * @pre -
     * @post returns the smallest number out of a and b
     */
    public static double minimum(double a, double b)
    {
        return (a < b) ? a : b;
    }
    /**
     * @pre -
     * @post returns the smallest number out of a, b and c
     */
    public static double minimum(double a, double b, double c)
    {
        return minimum(a, minimum(b, c));
    }
    
    /**
     * @pre -
     * @post returns the biggest number out of a and b
     */
    public static double maximum(double a, double b)
    {
        return (a > b) ? a : b;
    }
    /**
     * @pre -
     * @post returns the biggest number out of a, b and c
     */
    public static double maximum(double a, double b, double c)
    {
        return maximum(a, maximum(b, c));
    }
    
    /**
     * @pre -
     * @post returns the median of numbers a,b,c.
     */
    public static double median(double a, double b, double c)
    {
        return a+b+c - minimum(a,b,c) - maximum(a,b,c);
    }
    
    /**
     * @pre n>0
     * @post returns the number of positive divisors of n.
     */
    public static int numDiv(int n)
    {
        int num=0;
        for(int i=1; i<=n; i++)
            if(n%i == 0)
                num++;
        return num;
    }
    /**
     * @pre n>0
     * @post returns the sum of all positive divisors of n.
     */
    public static int sumDiv(int n)
    {
        int sum=0;
        for(int i=1; i<=n; i++)
            if(n%i == 0)
                sum += i;
        return sum;
    }
    /**
     * @pre x > 0
     * @post returns true if x is a perfect number, false instead
     */
    public static boolean parfait(int x)
    {
        return sumDiv(x) == x*2;
    }
    /**
     * @pre x > 0
     * @post returns true if x is a sublime number, false instead
     */
    public static boolean sublime(int x)
    {
        return (parfait(sumDiv(x)) && parfait(numDiv(x)));
    }
    /*
     * @pre -
     * @post A teste la methode minimum
     */
    public static void test_minimum() {

    double a=1.0;
    double b=2.0;
    double c=3.0;
    int erreur=0;

    if(minimum(a,b,c)!=1.0) {
        System.out.println("Erreur : minimum(1.0,2.0,3.0)!=1.0");
        erreur++;
    }

    if(minimum(a,a,a)!=1.0) {
        System.out.println("Erreur : minimum(1.0,1.0,1.0)!=1.0");
        erreur++;
    }

    if(minimum(c,c,c)!=3.0) {
        System.out.println("Erreur : minimum(3.0,3.0,3.0)!=3.0");
        erreur++;
    }

    if(minimum(c,b,a)!=1.0) {
        System.out.println("Erreur : minimum(3.0,2.0,1.0)!=1.0");
        erreur++;
    }

    if(minimum(c,b,c)!=2.0) {
        System.out.println("Erreur : minimum(3.0,2.0,3.0)!=2.0");
        erreur++;
    }

    if(erreur==0) {
        System.out.println("Aucune erreur n'a ete trouvee en utilisant la methode minimum");
    }
    else {
        System.out.print(erreur);
        System.out.print(" erreurs ont ete trouvees en utilisant la methode minimum");
    }

    }

    /*
     * @pre -
     * @post A teste la methode maximum
     */

    public static void test_maximum() {

    double a=1.0;
    double b=2.0;
    double c=3.0;
    int erreur=0;

    if(maximum(a,b,c)!=3.0) {
        System.out.println("Erreur : maximum(1.0,2.0,3.0)!=3.0");
        erreur++;
    }

    if(maximum(a,a,a)!=1.0) {
        System.out.println("Erreur : maximum(1.0,1.0,1.0)!=1.0");
        erreur++;
    }

    if(maximum(c,c,c)!=3.0) {
        System.out.println("Erreur : maximum(3.0,3.0,3.0)!=3.0");
        erreur++;
    }

    if(maximum(c,b,a)!=3.0) {
        System.out.println("Erreur : maximum(3.0,2.0,1.0)!=3.0");
        erreur++;
    }

    if(maximum(a,b,a)!=2.0) {
        System.out.println("Erreur : maximum(1.0,2.0,1.0)!=2.0");
        erreur++;
    }

    if(erreur==0) {
        System.out.println("Aucune erreur n'a ete trouvee en utilisant la methode maximum");
    }
    else {
        System.out.print(erreur);
        System.out.print(" erreurs ont ete trouvees en utilisant la methode maximum");
    }
    
    }


    /*
     * @pre -
     * @post A teste la methode average
     */
    public static void test_average() {

    double a=1.0;
    double b=2.0;
    double c=3.0;
    int erreur=0;

    if(average(a,b,c)!=2.0) {
        System.out.println("Erreur : average(1.0,2.0,3.0)!=2.0");
        erreur++;
    }

    if(average(a,a,a)!=1.0) {
        System.out.println("Erreur : average(1.0,1.0,1.0)!=1.0");
        erreur++;
    }

    if(average(c,c,c)!=3.0) {
        System.out.println("Erreur : average(3.0,3.0,3.0)!=3.0");
        erreur++;
    }

    if(average(c,b,a)!=2.0) {
        System.out.println("Erreur : average(3.0,2.0,1.0)!=2.0");
        erreur++;
    }

    if(average(a,b,a)!=1.3333333333333333) {
        System.out.println("Erreur : average(1.0,2.0,1.0)!=1.3333333333333333");
        erreur++;
    }

    if(erreur==0) {
        System.out.println("Aucune erreur n'a ete trouvee en utilisant la methode average");
    }
    else {
        System.out.print(erreur);
        System.out.print(" erreurs ont ete trouvees en utilisant la methode average");
    }
    
    }


    /*
     * @pre -
     * @post A teste la methode median
     */
    public static void test_median() {

    double a=1.0;
    double b=2.0;
    double c=3.0;
    int erreur=0;

    if(median(a,b,c)!=2.0) {
        System.out.println("Erreur : median(1.0,2.0,3.0)!=2.0");
        erreur++;
    }

    if(median(a,a,a)!=1.0) {
        System.out.println("Erreur : median(1.0,1.0,1.0)!=1.0");
        erreur++;
    }

    if(median(c,c,c)!=3.0) {
        System.out.println("Erreur : median(3.0,3.0,3.0)!=3.0");
        erreur++;
    }

    if(median(c,b,a)!=2.0) {
        System.out.println("Erreur : median(3.0,2.0,1.0)!=2.0");
        erreur++;
    }

    if(median(a,b,a)!=1.0) {
        System.out.println("Erreur : median(1.0,2.0,1.0)!=1.0");
        erreur++;
    }

    if(erreur==0) {
        System.out.println("Aucune erreur n'a ete trouvee en utilisant la methode median");
    }
    else {
        System.out.print(erreur);
        System.out.print(" erreurs ont ete trouvees en utilisant la methode median");
    }
    
    }
    
    public static void testsSublime()
    {
        int err=0;
        if(numDiv(1) != 1) err++;
        if(numDiv(2) != 2) err++;
        if(numDiv(4) != 3) err++;
        if(numDiv(6) != 4) err++;
        if(err == 0) TextIO.putln("No error in numDiv().");
        else TextIO.putln(err+" errors in numDiv().");
        
        err=0;
        if(sumDiv(1) != 1) err++;
        if(sumDiv(2) != 3) err++;
        if(sumDiv(4) != 7) err++;
        if(sumDiv(6) != 12) err++;
        if(err == 0) TextIO.putln("No error in sumDiv().");
        else TextIO.putln(err+" errors in sumDiv().");
        
        err=0;
        if(parfait(1)) err++;
        if(parfait(2)) err++;
        if(!parfait(6)) err++;
        if(!parfait(28)) err++;
        if(parfait(999)) err++;
        if(err == 0) TextIO.putln("No error in parfait().");
        else TextIO.putln(err+" errors in parfait().");
        
        err=0;
        if(sublime(1)) err++;
        if(sublime(2)) err++;
        if(sublime(6)) err++;
        if(!sublime(12)) err++;
        if(sublime(28)) err++;
        if(err == 0) TextIO.putln("No error in sublime().");
        else TextIO.putln(err+" errors in sublime().");
    }

    public static void main (String[] args) {

    // appel aux differentes methodes de test

    test_minimum();
    test_maximum();
    test_average();
    test_median();

    }


}
