
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class ArrayListContainerTest.
 * It tests the add, select and size methods
 */
import java.util.*;
import java.lang.*;
public class ArrayListPhoneBaseTest
{
    /**
     * A method that checks that 4 elements can be added to the array
     * list. 
     */
    @Test
    public void testAddNumbers(){

        //Creating object of array list container
        ArrayListPhoneBase a=new ArrayListPhoneBase();

        //Adding numbers to the array list
        System.out.println(a.add(987654323));
        System.out.println(a.add(987654321));
        System.out.println(a.add(987654322));
        System.out.println(a.add(987654325));

        //Creating a test array of expected results
        long[] test={987654321,987654322,987654323,987654325};

        //Gettings the result of the toArray class from the class
        long[] b=a.toArray();

        assertArrayEquals(test,b);
    }

    /**
     * A test method to see that the program returns false
     * if the user attempts to add a duplicate element to it
     */
    @Test
    public void testAddDuplicate(){

        //Creating object of array list container
        ArrayListPhoneBase a=new ArrayListPhoneBase();

        //Adding numbers to the array list
        a.add(987654323);
        a.add(987654321);
        a.add(987654322);

        //Adding duplicate element
        assertEquals(a.add(987654322),false);

    }

    /**
     * A method that checks that 3 elements can be added to the array
     * list and then removed using select in the correct order
     */
    @Test
    public void testRemoveNumbers(){

        //Creating object of array list container
        ArrayListPhoneBase a=new ArrayListPhoneBase();

        //Adding numbers to the array list
        a.add(987654323);
        a.add(987654321);
        a.add(987654322);

        //Creating an array of expected results
        long[] test={987654321,987654322,987654323};

        //Creating an array of the same size as the expected array to store the results
        long[] b=new long[3];

        //iterating over the kth positons we are interested in
        for(int i=0;i<b.length;i++){

            try{
                //Retrieveing i+1th smallest elements from the array list, going form 1 to 4
                b[i]=a.select(i+1);
            }
            catch(Exception e){
                //handling the exception by printing it
                System.out.println(e);
            }

        }

        //asserting that the test array and the results are the same
        assertArrayEquals(test,b);

    }

    /**
     * A method that checks that the program return a -1
     * when asked to find k-th with k<=0
     */
    @Test
    public void select0(){

        //Creating object of array list container
        ArrayListPhoneBase a=new ArrayListPhoneBase();

        //Adding numbers to the array list
        a.add(987654323);
        a.add(987654321);
        a.add(987654322);

        assertEquals(a.select(0),-1);
    }

    /**
     * A method that checks that the program return a -1
     * when asked to find k-th with k> size of data structure
     */
    @Test
    public void select4(){
        //Creating object of array list container
        ArrayListPhoneBase a=new ArrayListPhoneBase();

        //Adding numbers to the array list
        a.add(987654323);
        a.add(987654321);
        a.add(987654322);

        assertEquals(a.select(4),-1);

    }

    /**
     * A test which checks that the program throws an error when you 
     * try to select from an empty array list
     */
    @Test
    public void testRemoveEmpty(){

        //Creating object of array list container
        ArrayListPhoneBase a=new ArrayListPhoneBase();

        long flag=0;

        flag= a.select(1);

        assertEquals(flag,-1);
    }

    /**
     * Testing that the program can add 100 numbers and return the 
     * time taken to do so
     */
    @Test
    public void add100(){

        Random rand=new Random();

        //Creating object of array list container
        ArrayListPhoneBase a=new ArrayListPhoneBase();

        //starting time
        long startTime=System.currentTimeMillis();
        for(int i=0;i<100;i++){
            a.add(rand.nextLong());
        }
        //Stopping time
        long stopTime=System.currentTimeMillis();
        System.out.println("Array List Add:"+(stopTime-startTime));
    }

    /**
     * Testing that the program can remove 10 numbers and return the 
     * time taken to do so
     */
    @Test
    public void remove10(){
        Random rand=new Random();

        //Creating object of array list container
        ArrayListPhoneBase a=new ArrayListPhoneBase();

        for(int i=0;i<100;i++){

            a.add(rand.nextLong());
        }
        Random rand2=new Random();

        //starting time
        long startTime=System.currentTimeMillis();

        for(int i=0;i<100;i++){
            a.select(rand2.nextInt(100)+1);
        }

        //Stopping time
        long stopTime=System.currentTimeMillis();
        System.out.println("Array List Remove:"+(stopTime-startTime));
    }

    /**
     * A method that tests the size method to return the correct size
     */
    @Test
    public void testSize(){
        //Creating object of array list container
        ArrayListPhoneBase a=new ArrayListPhoneBase();

        //Adding numbers to the array list
        a.add(987654323);
        a.add(987654321);
        a.add(987654322);
        a.add(987654325);

        assertEquals(a.getSize(),4);

    }

    /**
     * A method that tests the size method to return the correct 
     * for an empty 
     */
    @Test
    public void testSizeEmpty(){
        //Creating object of array list container
        ArrayListPhoneBase a=new ArrayListPhoneBase();

        assertEquals(a.getSize(),0);
    }
}
