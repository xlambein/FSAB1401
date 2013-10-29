
/**
 * Abstract class AbstractTest - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class AbstractTest
{
    protected boolean everythingWorksFine = true;
    
    /**
     * @pre -
     * @post prints text if condition is false.
     */
    protected void test(boolean condition, String text) {
        if(!condition)
        {
            System.out.println(text);
            everythingWorksFine = false;
        }
    }
    
    public abstract void runTests();
}
