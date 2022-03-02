package reponsitory.employee;

import model.CodeCreating;
import model.person.Customer;
import model.person.Employee;
import reponsitory.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements IEmployeeRepository {
    private static String SELECT_ALL_EMPLOYEE = "SELECT * FROM employee \n" +
            "JOIN position on position.position_id = employee.position_id \n" +
            "JOIN education_degree on education_degree.education_degree_id = employee.education_degree_id\n" +
            "JOIN division on division.division_id = employee.division_id;";
    private static String INSERT_EMPLOYEE = "INSERT INTO `furama_case_study`.`employee` " +
            "( `employee_name`, `employee_birthday`, `employee_id_card`, `employee_salary`" +
            ", `employee_phone`, `employee_email`, `employee_address`,`division_id`,`education_degree_id`,`position_id`,`username`) VALUES ( ?,?,?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_EMPLOYEE_BY_ID = "SELECT * FROM employee \n" +
            "JOIN position on position.position_id = employee.position_id \n" +
            "JOIN education_degree on education_degree.education_degree_id = employee.education_degree_id\n" +
            "JOIN division on division.division_id = employee.division_id where employee_id =?;";


    private static final String UPDATE_EMPLOYEE = "UPDATE employee SET `employee_name`=?, `employee_birthday`=?,`employee_id_card`=?, " +
            "`employee_salary`=?, `employee_phone`=?, `employee_email`=?, `employee_address`=?, `division_id`=?, `education_degree_id`=?, `position_id`=?, `username`=? WHERE employee_id=?;";

    private static String DELETE_EMPLOYEE = "delete from employee where employee_id = ?";
    @Override
    public List<Employee> findAll() {
        Connection connection = DBConnection.getConnection();
        List<Employee> employeeList = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("employee_id");
                    String name = resultSet.getString("employee_name");
                    String birthDay = resultSet.getString("employee_birthday");
                    String idCard = resultSet.getString("employee_id_card");
                    String phone = resultSet.getString("employee_phone");
                    String email = resultSet.getString("employee_email");
                    String address = resultSet.getString("employee_address");
                    String code = "NV-" + id;
                    String educationDegree = resultSet.getString("education_degree_name");
                    String position = resultSet.getString("position_name");
                    String division = resultSet.getString("division_name");
                    String userName = resultSet.getString("username");
                    int idPosition = resultSet.getInt("position_id");
                    int idDivision = resultSet.getInt("division_id");
                    int idEducationDegree = resultSet.getInt("education_degree_id");
                    int salary = resultSet.getInt("employee_salary");

                    employeeList.add(new Employee(id, name, birthDay, idCard, phone,
                            email, address, code, educationDegree, position, division, userName, idPosition, idDivision, idEducationDegree, salary));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return employeeList;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = null;
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("employee_name");
                String birthDay = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                String code = "NV-" + id;
                String educationDegree = resultSet.getString("education_degree_name");
                String position = resultSet.getString("position_name");
                String division = resultSet.getString("division_name");
                String userName = resultSet.getString("username");
                int idPosition = resultSet.getInt("position_id");
                int idDivision = resultSet.getInt("division_id");
                int idEducationDegree = resultSet.getInt("education_degree_id");
                int salary = resultSet.getInt("employee_salary");

                employee = new Employee(id, name, birthDay, idCard, phone,
                        email, address, code, educationDegree, position, division, userName, idPosition, idDivision, idEducationDegree, salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void create(Employee employee) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);
                preparedStatement.setString(1,employee.getName());
                preparedStatement.setString(2,employee.getBirthday());
                preparedStatement.setString(3,employee.getIdCard());
                preparedStatement.setInt(4,employee.getSalary());
                preparedStatement.setString(5,employee.getPhone());
                preparedStatement.setString(6,employee.getEmail());
                preparedStatement.setString(7,employee.getAddress());
                preparedStatement.setString(11,employee.getUserName());
                preparedStatement.setInt(8,employee.getIdPosition());
                preparedStatement.setInt(10,employee.getIdDivision());
                preparedStatement.setInt(9,employee.getIdEducationDegree());
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
    public void update(Employee employee) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE);
                preparedStatement.setString(1,employee.getName());
                preparedStatement.setString(2,employee.getBirthday());
                preparedStatement.setString(3,employee.getIdCard());
                preparedStatement.setInt(4,employee.getSalary());
                preparedStatement.setString(5,employee.getPhone());
                preparedStatement.setString(6,employee.getEmail());
                preparedStatement.setString(7,employee.getAddress());
                preparedStatement.setString(11,employee.getUserName());
                preparedStatement.setInt(8,employee.getIdPosition());
                preparedStatement.setInt(10,employee.getIdDivision());
                preparedStatement.setInt(9,employee.getIdEducationDegree());
                preparedStatement.setInt(12,employee.getId());
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
                preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
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

