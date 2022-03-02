package reponsitory.employee;

import model.person.Employee;
import model.person.EmployeeDivision;
import model.person.EmployeeEducationDegree;
import reponsitory.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeEducationDegreeRepositoryImpl implements IEmployeeEducationDegreeRepository {
    private static String SELECT_ALL_EMPLOYEE_DEGREE_EDUCATION = "SELECT * FROM education_degree";

    @Override
    public List<EmployeeEducationDegree> findAll() {
        Connection connection = DBConnection.getConnection();
        List<EmployeeEducationDegree> employeeEducationDegreeList = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE_DEGREE_EDUCATION);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int idEducationDegree = resultSet.getInt("education_degree_id");
                    String nameEducationDegree = resultSet.getString("education_degree_name");
                    employeeEducationDegreeList.add(new EmployeeEducationDegree(idEducationDegree, nameEducationDegree));
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
        return employeeEducationDegreeList;
    }
}
