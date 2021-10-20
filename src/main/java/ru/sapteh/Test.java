package ru.sapteh;

import ru.sapteh.dao.Dao;
import ru.sapteh.dao.daoImpl.EmployeeDaoImpl;
import ru.sapteh.model.Employee;
import ru.sapteh.utils.Connector;
import java.sql.Connection;

public class Test {
    public static void main(String[] args) {
        Connection connection = Connector.getInstance();
        Dao<Employee, Integer> employeeDaoImpl = new EmployeeDaoImpl(connection);
        Employee employeeAdd = new Employee("Vladimir", "Putin", "President" , 1000000);

        employeeDaoImpl.delete(employeeDaoImpl.findById(7));

        System.out.println(employeeDaoImpl.findById(7));

        System.out.println("============================================");

        employeeDaoImpl.findAll().forEach(System.out::println);


    }
}
