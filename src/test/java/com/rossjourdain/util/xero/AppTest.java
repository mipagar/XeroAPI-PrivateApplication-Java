package com.rossjourdain.util.xero;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        // Prepare the Xero Client
        XeroClient xeroClient = null;
        try {
            XeroClientProperties clientProperties = new XeroClientProperties();
            clientProperties.load(new FileInputStream("./xeroApi.properties"));
            xeroClient = new XeroClient(clientProperties);
            
            xeroClient.getInvoiceByReference("91fcf5d743114ee4960128083dd38e87");
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (XeroClientException ex) {
            Logger.getLogger(AppTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XeroClientUnexpectedException ex) {
            Logger.getLogger(AppTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
