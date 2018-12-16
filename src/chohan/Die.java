package chohan;

/**
 *
 * @author Mikey
 */
public class Die {
    private int numDots;
    
    public Die() {
    }
    
    public void roll() {
        numDots = (int)(1 + 6 * Math.random());
    }
    
    public int getNumDots() {
        return numDots;
    }
}
