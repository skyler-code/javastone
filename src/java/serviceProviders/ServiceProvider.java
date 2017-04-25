package serviceProviders;

/**
 *
 * @author Skyler Hiscock
 */
public class ServiceProvider {
    
    private int ServiceProviderID;
    private String ServiceCategory;
    private String ServiceProviderName;
    private String ServiceProviderPhoneNumber;

    public ServiceProvider(int serviceProviderID, String serviceCategory, String serviceProviderName, String serviceProviderPhoneNumber){
        this.ServiceProviderID = serviceProviderID;
        this.ServiceCategory = serviceCategory;
        this.ServiceProviderName = serviceProviderName;
        this.ServiceProviderPhoneNumber = serviceProviderPhoneNumber;
    }
    
    /**
     * @return the ServiceProviderID
     */
    public int getServiceProviderID() {
        return ServiceProviderID;
    }

    /**
     * @return the ServiceCategoryName
     */
    public String getServiceCategoryName() {
        return ServiceCategory;
    }

    /**
     * @return the ServiceProviderName
     */
    public String getServiceProviderName() {
        return ServiceProviderName;
    }

    /**
     * @return the ServiceProviderPhoneNumber
     */
    public String getServiceProviderPhoneNumber() {
        return ServiceProviderPhoneNumber;
    }
    
}
