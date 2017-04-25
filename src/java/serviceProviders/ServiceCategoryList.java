package serviceProviders;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Skyler Hiscock
 */
public class ServiceCategoryList {
    
    private ArrayList<ServiceCategory> serviceCategories = null;
    
    public ServiceCategoryList() throws SQLException, ClassNotFoundException{
        ServiceProviderDAO spDAO = new ServiceProviderDAO();
        serviceCategories = spDAO.retrieveServiceCategoryList();
    }

    /**
     * @return the serviceCategories
     */
    public ArrayList<ServiceCategory> getServiceCategories() {
        return serviceCategories;
    }
}
