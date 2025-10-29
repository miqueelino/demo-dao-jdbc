package model.dao;

import java.util.List;

import model.entities.Department;
import model.entities.Seller;

//Interface com os metodos que a implementaçao SellerDaoJDBC deve implementar
public interface SellerDao {

//CRUD
    void insert(Seller obj);
    void update (Seller obj);
    void deleteById(Integer id);
    Seller findById(Integer id);
    List<Seller> findAll();
    List<Seller> findByDepartment(Department department);

}
