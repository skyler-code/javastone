package serviceProviders;

import database.DatabaseConnectionFactory;
import database.DatabaseType;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Skyler Hiscock
 */
public class ServiceProviderDAO {
    
    /**
     * @author: Skyler Hiscock
     * @return ArrayList<ServiceProvider>
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public ArrayList<ServiceProvider> retrieveServiceProviderList() throws SQLException, ClassNotFoundException{
        ArrayList<ServiceProvider> serviceProviders = new ArrayList<>();
        
        //Call the stored procedure
        DatabaseConnectionFactory factory = DatabaseConnectionFactory.getInstance();
        Connection conn = factory.getConnection(DatabaseType.MYSQL);
        CallableStatement statement = conn.prepareCall("call sp_retrieve_service_providers");
        ResultSet resultSet = statement.executeQuery();
        
        int serviceProviderID;
        String serviceCategoryName;
        String serviceProviderName;
        String serviceProviderPhoneNumber;
        
        while(resultSet.next()){
            serviceProviderID = resultSet.getInt(1);
            serviceCategoryName = resultSet.getString(2);
            serviceProviderName = resultSet.getString(3);
            serviceProviderPhoneNumber = resultSet.getString(4);
            
            ServiceProvider serviceProvider = new ServiceProvider(serviceProviderID, serviceCategoryName, serviceProviderName, serviceProviderPhoneNumber);
            serviceProviders.add(serviceProvider);
        }
        
        return serviceProviders;
    }
    
    /**
     * @author: Skyler Hiscock
     * @return ArrayList<ServiceCategory>
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    
    public ArrayList<ServiceCategory> retrieveServiceCategoryList() throws SQLException, ClassNotFoundException{
        ArrayList<ServiceCategory> serviceCategories = new ArrayList<>();
        
        //Call the stored procedure
        DatabaseConnectionFactory factory = DatabaseConnectionFactory.getInstance();
        Connection conn = factory.getConnection(DatabaseType.MYSQL);
        CallableStatement statement = conn.prepareCall("call sp_retrieve_service_categories");
        ResultSet resultSet = statement.executeQuery();
        
        String serviceCategoryName;
        String description;
        
        while(resultSet.next()){
            serviceCategoryName = resultSet.getString(1);
            description = resultSet.getString(2);
            
            ServiceCategory serviceCategory = new ServiceCategory(serviceCategoryName, description);
            serviceCategories.add(serviceCategory);
        }
        
        return serviceCategories;
    }
}
