
/**
 * A class that creates a data base using a hash set
 * of phone numbers
 * Implements PhoneBase
 */
import java.util.*;
public class HashSetPhoneBase implements PhoneBase
{   
    //Instance variables 
    HashSet<Long> h;
    //Global array for quick select
    Long[] array;
    //Cutoff value for quick select
    final int CUTOFF=10;
    
    /**
     * Constructor for HashSetPhoneBase
     */
    public HashSetPhoneBase(){
        //Creating object
        h=new HashSet<Long>();
    }
    
    /**
     * Adds an item to a hash set.
     * Returns true if successful, else false
     * @param long phone number
     * @return boolean
     */
    public boolean add(long item){
        //calling inbuilt add
        return(h.add(item));

    }

    /**
     * Selects the k-th smallest element in the hash set
     * @param int k
     * @return long
     */
    public long select(int k){
        
        //If k is smaller than 0 or bigger than the size of the hash set
        if(k<=0||k>h.size())
            return -1;
        array=h.toArray(new Long[h.size()]);

        //calling quick select
        quickSelect(0,h.size()-1,k);

        //return the k-1 th element from the global array
        return(array[k-1]);

    }

    /**
     *A method to quick select a given linked list by recursively calling
     *the quick select method. A seperate method swaps the elements
     *@param int lowest index currently in consideration
     *@param int highest index currently in consideration
     */
    public void  quickSelect(int low, int high, int k) {
        //If there are 10 or less than 10 elements, do insertion sort
        if(low+CUTOFF>high)
            insertionSort(low,high);
        //quick select
        else{

            //Ordereing 3 elements
            int middle=(low+high)/2;

            // System.out.println("Middle:"+middle);
            if((array[middle].compareTo(array[low]))<0)
                swapReferences(low,middle);
            if((array[high].compareTo(array[low]))<0)
                swapReferences(low,high);
            if((array[high].compareTo(array[middle]))<0)
                swapReferences(middle,high);

            //Placing pivot at high-1
            swapReferences(middle, high-1);
            long pivot=array[high-1];

            int i,j;
            //paritioning arrays
            for(i=low,j=high-1;;){
                while(array[++i]-pivot<0);

                while(pivot-array[--j]<0);
                if(i>=j){
                    break;
                }
                swapReferences(i,j);
            }
            //Putting pivot in place
            swapReferences(i,high-1);
            if(k<=i)
            //Sort small elememts
                quickSelect(low,i-1,k);
            else if(k>i+1)
            //Sort large elements   
                quickSelect(i+1,high,k);

        }

    }

    /**
     *Method to swap elements in the instance variable between
     *two indices
     *@param int first index
     *@param int next index
     */
    public void swapReferences(int first, int next){
        long temp;

        temp=array[first];
        array[first]=array[next];
        array[next]= temp;
    }
    /**
     * Performs insertion sort ont the the given 
     * bounds of the array
     * @param int lowest bound being used
     * @param int highest bound being used
     */
    public void insertionSort(int low, int high){
        
        for(int i=low;i<=high;i++){
            Long temp=array[i];
            int j=i;
            for(;j>0&&temp.compareTo(array[j-1])<0;j--)
                array[j]=array[j-1];
            array[j]=temp;

        }
    }

    /**
     * Putting the hash Set into an array 
     * @return Long[]
     */
    public Long[] toArray(){

        return(h.toArray(new Long[h.size()]));
    }

    
    
    public int getSize(){
        
       return(h.size()); 
    }
}
