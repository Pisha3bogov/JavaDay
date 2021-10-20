package ru.sapteh.dao.daoImpl;

import ru.sapteh.dao.Dao;
import ru.sapteh.model.Employee;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements Dao<Employee, Integer> {
    private Connection connection;

    public EmployeeDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Employee findById(Integer id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        Employee employee = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                employee = new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("departament"),
                        resultSet.getInt("salary")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employee";
        List<Employee> employee = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employee.add(new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("departament"),
                        resultSet.getInt("salary"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void save(Employee employee) {
        String sql = "INSERT INTO employee(first_name,last_name,departament,salary) VALUES (?,?,?,?)";
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, employee.getFirst_name());
                statement.setString(2, employee.getLast_name());
                statement.setString(3, employee.getDepartament());
                statement.setInt(4,employee.getSalary());
                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void delete(Employee employee) {
        String sql = "DELETE FROM employee WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, employee.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
