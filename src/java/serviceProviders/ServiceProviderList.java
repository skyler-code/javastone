package serviceProviders;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Skyler Hiscock
 */
public class ServiceProviderList {
    private ArrayList<ServiceProvider> serviceProviders = null;
    
    public ServiceProviderList() throws SQLException, ClassNotFoundException{
        ServiceProviderDAO spDAO = new ServiceProviderDAO();
        serviceProviders = spDAO.retrieveServiceProviderList();
    }

    /**
     * @return the serviceCategories
     */
    public ArrayList<ServiceProvider> getServiceProviders() {
        return serviceProviders;
    }
}
