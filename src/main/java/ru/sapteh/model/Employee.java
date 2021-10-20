package ru.sapteh.model;

import java.util.Objects;

public class Employee {
    private int id;
    private String first_name;
    private String last_name;
    private String departament;
    private int salary;

    public Employee () {

    }

    public Employee(int id, String first_name, String last_name,String departament, int salary) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.departament = departament;
        this.salary = salary;
    }

    public Employee(String first_name,String last_name,String departament, int salary) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.departament = departament;
        this.salary = salary;
    }

    public int getId(){
        return id;
    }

    public String getFirst_name () {
        return first_name;
    }

    public String getLast_name () {
        return last_name;
    }

    public String getDepartament () {
        return departament;
    }

    public int getSalary() {
        return salary;
    }

    public void setId (int id){
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && salary == employee.salary && Objects.equals(first_name, employee.first_name) && Objects.equals(last_name, employee.last_name) && Objects.equals(departament, employee.departament);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, departament, salary);
    }

    @Override
    public String toString () {
        return "ID : " + id + "\n" +
                "First name : " + first_name + "\n" +
                "Last name : " + last_name + "\n" +
                "Departament : " + departament + "\n" +
                "Salary : " + salary + "\n";
    }
}
