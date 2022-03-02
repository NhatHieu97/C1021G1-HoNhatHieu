package reponsitory.service;

import model.CodeCreating;
import model.person.Customer;
import model.person.CustomerType;
import model.service.RentType;
import model.service.ServiceType;
import reponsitory.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRentTypeRepository implements IServiceRentTypeRepository {
    private static String SELECT_ALL_SERVICE_RENT_TYPE = "SELECT * FROM rent_type";
    private static final String SELECT_SERVICE_TYPE_BY_ID = "SELECT * FROM service_type " +
            " where service_id =?";

    @Override
    public List<RentType> findAll() {
        Connection connection = DBConnection.getConnection();
        List<RentType> rentTypeList = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE_RENT_TYPE);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int renTypeId = resultSet.getInt("rent_type_id");
                    String rentTypename = resultSet.getString("rent_type_name");
                    double rentTypeCost = resultSet.getDouble("rent_type_cost");
                    rentTypeList.add(new RentType(renTypeId, rentTypename, rentTypeCost));
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
        return rentTypeList;
    }

    @Override
    public double getCodeById(int id) {
        RentType rentType = null;
        double cost = 0;
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE_TYPE_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int rentTypeId = resultSet.getInt("rent_type_id");
                String rentTypeName = resultSet.getString("rent_type_name");
                double rentTypeCost = resultSet.getDouble("rent_type_cost");


                rentType = new RentType(rentTypeId,rentTypeName,rentTypeCost);
                cost = rentType.getRentTypeCost();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cost;
    }
}
