
/**
 * An interface for the data
 * structure for phone numbers
 * 
 */
public interface PhoneBase
{
    /**
     * A method to add a new phone number
     * @param long
     */
    public boolean add(long phoneNumbe);

    public long select(int k);
    
    
    public int getSize();
}
