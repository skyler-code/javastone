/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callSession;

import java.util.ArrayList;

/**
 *
 * @author Michael Takrama
 * 04/27/2017
 */
public class EmergencyService {
    /**
     * Emergency Service ID
     */
    private int id;
    
    /**
     * Name of Emergency Service
     */
    private String name;
    
    /**
     * Name of Description
     */
    private String description;
    
    /**
     * Name of Specialty
     */
    private String specialty;
    
    /**
     * List of emergency services
     */
    private ArrayList<EmergencyService> emergencyServices;

    /**
     * Full constructor
     * @param id
     * @param name
     * @param description
     * @param specialty 
     */
    public EmergencyService(int id, String name, String description, String specialty) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.specialty = specialty;
    }

    /**
     * Parameterless constructor
     */
    public EmergencyService() {
        this.id = 0;
        this.name = "";
        this.description = "";
        this.specialty = "";
    }
    

    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the specialty
     */
    public String getSpecialty() {
        return specialty;
    }

    /**
     * @param specialty the specialty to set
     */
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }   

    /**
     * List of emergency services
     * @return the emergencyServices
     */
    public ArrayList<EmergencyService> getEmergencyServices() {
        if ( null == emergencyServices)
        {
            EmployeeServiceDAO dao = new EmployeeServiceDAOStub();
            this.emergencyServices = dao.getEmergencyServices();
        }
        return emergencyServices;
    }

    /**
     * List of emergency services
     * @param emergencyServices the emergencyServices to set
     */
    public void setEmergencyServices(ArrayList<EmergencyService> emergencyServices) {
        this.emergencyServices = emergencyServices;
    }
}
