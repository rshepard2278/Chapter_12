

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AddressBookDemoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AddressBookDemoTest
{
    private AddressBookDemo addressB1;

    /**
     * Default constructor for test class AddressBookDemoTest
     */
    public AddressBookDemoTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        addressB1 = new AddressBookDemo();
        addressB1.showInterface();
        
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
