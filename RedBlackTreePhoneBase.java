
/**
 * A class that stores phone numbers in a red-black
 * tree of type long. It allows the user to add, select
 * the k-th smallest element and get the size
 * Implements PhoneBase
 */
import java.util.*;
public class RedBlackTreePhoneBase implements PhoneBase
{
    //object of class red-black tree
    private RedBlackTree<Long> tree;

    /**
     * Contructor for the class red black tree
     */
    public RedBlackTreePhoneBase(){
        //create object of red-black tree
        tree=new RedBlackTree<Long>();

    }

    /**
     * A method that adds a given element to the red
     * black tree. Returns true if successful, false if
     * duplicate element
     * @param long phone number to be added
     * @return boolean
     */
    public boolean add(long item){

        try{
           //calling insert method from red-black tree
            tree.insert(item);
            return true;
        }
        catch(Exception e){
            //Return false if there is an exception
            return false;
        }

    }
    
    /**
     * Returns the k-th smallest phone number in the tree
     * @param int k
     * @return long
     */
    public long select(int k){
        try{
            //Call find k-th
            return(tree.findKth(k));
        }
        //If you get an exception return -1
        catch(Exception e){
            System.out.println(e);
            return -1;
        }

    }
    
    /**
     * Returns the current size of the tree
     * @return int
     */
    public int getSize(){
        //calling size method from red-black tree
        return(tree.size());
    }

    /**
     * Prints the tree
     */
    public void print(){
        //calling printTree method from red-black tree
        tree.printTree();
    }
}
