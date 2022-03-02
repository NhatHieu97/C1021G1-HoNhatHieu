package reponsitory.employee;

import model.person.Employee;
import model.person.EmployeeDivision;
import model.person.EmployeePosition;
import reponsitory.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeePositionRepositoryImpl implements IEmployeePositionRepository {
    private static String SELECT_ALL_EMPLOYEE_POSITION = "SELECT * FROM position";
    @Override
    public List<EmployeePosition> findAll() {
        Connection connection = DBConnection.getConnection();
        List<EmployeePosition> employeePositionList = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE_POSITION);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int idPosition = resultSet.getInt("position_id");
                    String namePosition = resultSet.getString("position_name");
                    employeePositionList.add(new EmployeePosition(idPosition, namePosition));
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
        return employeePositionList;
    }
}
