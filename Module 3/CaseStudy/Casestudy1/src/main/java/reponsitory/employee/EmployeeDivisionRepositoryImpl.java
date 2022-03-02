package reponsitory.employee;

import model.person.CustomerType;
import model.person.Employee;
import model.person.EmployeeDivision;
import reponsitory.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDivisionRepositoryImpl implements IEmployeeDivisionRepository {
    private static String SELECT_ALL_EMPLOYEE_DIVISION = "SELECT * FROM division";
    @Override
    public List<EmployeeDivision> findAll() {
        Connection connection = DBConnection.getConnection();
        List<EmployeeDivision> employeeDivisionList = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE_DIVISION);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int idDivision = resultSet.getInt("division_id");
                    String nameDivision = resultSet.getString("division_name");
                    employeeDivisionList.add(new EmployeeDivision(idDivision, nameDivision));
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
        return employeeDivisionList;
    }
}
