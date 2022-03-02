package reponsitory.service;

import model.CodeCreating;
import model.person.Customer;
import model.service.RentType;
import model.service.ServiceType;
import reponsitory.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepository implements IServiceTypeRepository {
    private static String SELECT_ALL_SERVICE_TYPE = "SELECT * FROM service_type";

    @Override
    public List<ServiceType> findAll() {
        Connection connection = DBConnection.getConnection();
        List<ServiceType> serviceTypeList = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE_TYPE);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int serviceTypeId = resultSet.getInt("service_type_id");
                    String serviceTypeName = resultSet.getString("service_type_name");
                    serviceTypeList.add(new ServiceType(serviceTypeId, serviceTypeName));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return serviceTypeList;
    }
}
