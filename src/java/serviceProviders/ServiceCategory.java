package serviceProviders;

/**
 *
 * @author Skyler Hiscock
 */
public class ServiceCategory {
    private String ServiceCategoryName;
    private String Description;
    
    public ServiceCategory(String serviceCategoryName, String description){
        this.ServiceCategoryName = serviceCategoryName;
        this.Description = description;
    }

    /**
     * @return the ServiceCategoryName
     */
    public String getServiceCategoryName() {
        return ServiceCategoryName;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }
    
    
}
