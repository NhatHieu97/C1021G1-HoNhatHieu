package reponsitory.service;

import model.person.Customer;
import model.service.Service;
import reponsitory.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements IServiceRepository {
    private static String SELECT_ALL_SERVICE = "SELECT * FROM service \n" +
            "JOIN rent_type On service.rent_type_id = rent_type.rent_type_id\n" +
            "LEFT JOIN service_type On service_type.service_type_id=service.service_type_id;";
    private static String INSERT_SERVICE = "INSERT INTO `furama_case_study`.`service` " +
            "( `service_name`, `service_area`, `service_cost`, `service_max_people`" +
            ", `standard_room`, `description_other_convenience`, `pool_area`,`number_of_floors`,`rent_type_id`,`service_type_id`) VALUES ( ?,?,?,?,?,?,?,?,?,?);";
    @Override
    public List<Service> findAll() {
        Connection connection = DBConnection.getConnection();
        List<Service> serviceList = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        if(connection != null){
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    int idService = resultSet.getInt("service_id");
                    String name = resultSet.getString("service_name");
                    int service_area = resultSet.getInt("service_area");
                    double serviceCost = resultSet.getDouble("service_cost");
                    int serviceMaxPeople = resultSet.getInt("service_max_people");
                    String standardRoom = resultSet.getString("standard_room");
                    String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                    double poolArea = resultSet.getDouble("pool_area");
                    int numberOfFloors = resultSet.getInt("number_of_floors");
                    int rentTypeId = resultSet.getInt("rent_type_id");
                    int serviceTypeId = resultSet.getInt("service_type_id");
                    String rentTypeName = resultSet.getString("rent_type_name");
                    double renTypeCost = resultSet.getDouble("rent_type_cost");
                    String serviceTypeName = resultSet.getString("service_type_name");


                    serviceList.add(new Service(idService,name,service_area,serviceCost,serviceMaxPeople,
                            standardRoom,descriptionOtherConvenience,poolArea,numberOfFloors,rentTypeId,serviceTypeId,rentTypeName,renTypeCost,serviceTypeName));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return serviceList;
    }

    @Override
    public void create(Service service) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(INSERT_SERVICE);
                preparedStatement.setString(1,service.getName());
                preparedStatement.setInt(2,service.getServiceArea());
                preparedStatement.setDouble(3,service.getServiceCost());
                preparedStatement.setInt(4,service.getServiceMaxPeople());
                preparedStatement.setString(5,service.getStandardRoom());
                preparedStatement.setString(6,service.getDescriptionOtherConvenience());
                preparedStatement.setDouble(7,service.getPoolArea());
                preparedStatement.setInt(8,service.getNumberOfFloors());
                preparedStatement.setInt(9,service.getRentTypeId());
                preparedStatement.setInt(10,service.getServiceTypeId());
                preparedStatement.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
