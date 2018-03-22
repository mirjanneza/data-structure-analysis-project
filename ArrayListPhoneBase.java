
/**
 * A class for the array list implementation
 * of the list of phone numbers
 */
import java.lang.*;
import java.util.*;
public class ArrayListPhoneBase implements PhoneBase
{
    //Declaring the array list of type long for the phone numbers
    ArrayList<Long> phoneNumbers;

    /**
     * Constructor that creates the array list
     */
    public ArrayListPhoneBase(){
        //Creating the long array list
        phoneNumbers=new ArrayList<Long>();
    }

    /**
     * A method that adds a phone number 
     * into an array list of sorted phone numbers.
     * It returns true if add is successful otherwise
     * it throws an exception
     * @param long phone number
     * @return boolean
     */
    public boolean add(long phoneNumber){

        //uses binary search from the collections package
        int val=Collections.binarySearch(phoneNumbers,phoneNumber);

        //If the element is already present
        if(val>0)
            return false;

        //If the element is not present, convert the value from binarySearch to the value of the index
        else{

            val=val*(-1);
            val-=1;
            phoneNumbers.add(val,phoneNumber);
            return true;
        }
    }

    /**
     * A method that returns the kth smallest element
     * from the array list. It throws an exception
     * if the kth smallest element does not exit
     * @param k the rank of the number to be returned
     * @return long
     * @throws exception
     */
    public long select(int k) {

        //If there is atleast one element in the arrat list
        if(phoneNumbers.size()>0)
        {
            //If the rank of the element is less than equal to the size of the array list
            if(k<=phoneNumbers.size()&&k>0)
            //return the element at the index rank-1
                return(phoneNumbers.get(k-1));
            //The element cannot exist
            else
            //return -1
                return -1;

        }

        //If none of the conditions are satisfied, throw an exception
        return -1;
    }

    /**
     * A method that converts the array list into an array
     * containing the same elements
     * @return long[]
     */
    public long[] toArray(){

        //Creating an array of the same size as the array list
        long[] a=new long[phoneNumbers.size()];

        //Iterate through the array list
        for(int i=0;i<phoneNumbers.size();i++)
        //Add every nunber to the array
            a[i]=phoneNumbers.get(i);

        //return the array
        return a;
    }

    /**
     * A method that returns the size of the array list
     * @return int
     */
    public int getSize(){
        //calling size method for array list
        return(phoneNumbers.size());
    }
}
