package reponsitory.customer.impl;

import model.CodeCreating;
import model.person.Customer;
import reponsitory.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements ICustomerRepository {
    private static String SELECT_ALL_CUSTOMER = "SELECT * FROM customer \n" +
            "join customer_type on customer.customer_type_id = customer_type.customer_type_id;";

    private static String INSERT_CUSTOMER = "INSERT INTO `furama_case_study`.`customer` " +
            "( `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`" +
            ", `customer_phone`, `customer_email`, `customer_address`,`customer_type_id`) VALUES ( ?,?,?,?,?,?,?,?);";

    private static final String UPDATE_CUSTOMER = "UPDATE customer SET `customer_name`=?, `customer_birthday`=?,`customer_gender`=?, " +
            "`customer_id_card`=?, `customer_phone`=?, `customer_email`=?, `customer_address`=?, `customer_type_id`=? WHERE customer_id=?;";

    private static final String SELECT_CUSTOMER_BY_ID = "SELECT * FROM customer \n" +
            "join customer_type on customer.customer_type_id = customer_type.customer_type_id where customer_id =?";

    private static String DELETE_CUSTOMER = "delete from customer where customer_id = ?";

    @Override
    public List<Customer> findAll() {
        Connection connection = DBConnection.getConnection();
        List<Customer> customerList = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        if(connection != null){
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    int idCustomer = resultSet.getInt("customer_id");
                    String nameCustomer = resultSet.getString("customer_name");
                    String birthDay = resultSet.getString("customer_birthday");
                    String idCard = resultSet.getString("customer_id_card");
                    String phone = resultSet.getString("customer_phone");
                    String email = resultSet.getString("customer_email");
                    String address = resultSet.getString("customer_address");
                    String code = "KH-" + idCustomer;
                    Boolean gender = resultSet.getBoolean("customer_gender");
                    String customerType = resultSet.getString("customer_type_name");
                    int idCustomerType = resultSet.getInt("customer_type_id");

                    customerList.add(new Customer(idCustomer,nameCustomer,birthDay,idCard,phone,
                            email,address,code,gender,customerType,idCustomerType));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return customerList;
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                boolean gender = resultSet.getBoolean("customer_gender");
                String code = CodeCreating.setCode("KH-",id);
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                String customerType = resultSet.getString("customer_type_name");
                int customerTypeId = resultSet.getInt("customer_type_id");

                customer = new Customer(id,name,birthday,idCard,phone,email,address,code,gender,customerType,customerTypeId);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }


    @Override
    public void create(Customer customer) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(INSERT_CUSTOMER);
                preparedStatement.setString(1,customer.getName());
                preparedStatement.setString(2,customer.getBirthday());
                preparedStatement.setBoolean(3,customer.getGender());
                preparedStatement.setString(4,customer.getIdCard());
                preparedStatement.setString(5,customer.getPhone());
                preparedStatement.setString(6,customer.getEmail());
                preparedStatement.setString(7,customer.getAddress());
                preparedStatement.setInt(8,customer.getIdCustomerType());
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
    @Override
    public void update(Customer customer) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
                preparedStatement.setString(1,customer.getName());
                preparedStatement.setString(2,customer.getBirthday());
                preparedStatement.setBoolean(3,customer.getGender());
                preparedStatement.setString(4,customer.getIdCard());
                preparedStatement.setString(5,customer.getPhone());
                preparedStatement.setString(6,customer.getEmail());
                preparedStatement.setString(7,customer.getAddress());
                preparedStatement.setInt(8,customer.getIdCustomerType());
                preparedStatement.setInt(9,customer.getId());
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

    @Override
    public void delete(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
                preparedStatement.setInt(1,id);
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
