/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callTransfersTests;

import callTransfers.EmergencyRoute;
import callTransfers.EmergencyServiceDAOStub;
import callTransfers.EmergencyServiceLogDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mike T
 */
public class EmergencyServiceDAOStubTests{
    
    public EmergencyServiceDAOStubTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void getEmergencyServiceLog() {
        System.out.println("Write to Emergency Log");
        EmergencyServiceDAOStub instance = new EmergencyServiceDAOStub();
        int expectedServiceId = 1;
        int expectedUserId = 3;
        
        ArrayList<EmergencyRoute> emrs =  instance.getEmergencyServiceLog();
        
        assertEquals(expectedUserId, emrs.get(0).getUserId());
        assertEquals(expectedServiceId, emrs.get(0).getServiceProviderId());
    }

    @Test
    public void createEmergencyServiceLogEntry() {
        System.out.println("Write to Emergency Log");
        EmergencyServiceDAOStub instance = new EmergencyServiceDAOStub();
        int expResult = -1; //wrong from db
        
        EmergencyRoute routeData = new EmergencyRoute(1,1,LocalDate.now(), "This is test data"); 
        
        int result = instance.createEmergencyServiceLogEntry(routeData);
        assertEquals(expResult, result);

    }
    

}
