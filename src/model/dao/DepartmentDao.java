package model.dao;

import java.util.List;

import model.entities.Department;

//interface com os metodos que a implementaçao DepartmentDaoJDBC deve implementar
public interface DepartmentDao {

//CRUD
    void insert(Department obj);
    void update(Department obj);
    void deleteById(Integer id);
    Department findById(Integer id);
    List<Department> findAll();

}
