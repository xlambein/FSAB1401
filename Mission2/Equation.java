
/**
 * Computes small integer solutions of x^a+y^b=z^c for given a,b,c.
 * Because of accuracy issues, this program doesn't use Math.pow().
 * 
 * @author Victor Lecomte & Xavier Lambein
 * @version 2013-10-03 14:00
 */

public class Equation
{
    // Computes the greatest common divisor
    public static long gcd(long a, long b)
    {
        if(b == 0)
            return a;
        else
            return gcd(b, a%b);
    }
    // Computes the integer power x^e
    public static long pow (long x, int e)
    {
        if (e == 0)
            return 1;
        else
        {
            long p = pow(x, e/2);
            if(e%2 == 0)
                return p*p;
            else
                return p*p*x;
        }
    }
    // Computes the integer part of the eth root of x.
    public static long root (long x, int e)
    {
        // Lower and upper bounds for the dichotomic search
        long a = 0;
        long b = 1;
        // Increases b until b^e is bigger than x
        while(pow(b, e) <= x)
            b *= 2;
        // Executing the dichotomic search
        while(a+1 < b)
        {
            if(pow((a+b)/2, e) <= x)
                a = (a+b)/2;
            else
                b = (a+b)/2;
        }
        return a;
    }
    
    public static void main (String args[])
    {
        int max;
        int a,b,c;
        int numSol=0;
        System.out.print("Enter the value of a: ");
        a=TextIO.getlnInt();

        System.out.print("Enter the value of b: ");
        b=TextIO.getlnInt();
        
        System.out.print("Enter the value of c: ");
        c=TextIO.getlnInt();

        System.out.print("Enter max values for x and y: ");
        max=TextIO.getlnInt();
       
        // Tests every (x,y) couple using brute force
        for(long x=1; x<=max; x++)
        {
            for(long y=1; y<=max; y++)
            {
                long zc = pow(x,a) + pow(y,b);
                long z = root(zc,c);
                // If z is the exact cth root of z^c AND the gcd of x,y,z is 1.
                if(pow(z,c) == zc && gcd(gcd(x,y),z) == 1)
                {
                    System.out.println("x=" + x + " y=" + y + " z=" + z);
                    numSol++;
                }
            }
        }
        if(numSol == 0)
            System.out.println("No solution found.");
        else 
            System.out.println(numSol + " solutions found.");
    }
}
