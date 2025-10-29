package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

//implementaçao da interface SellerDao que protege os metodos que devem ser implementados
public class SellerDaoJDBC implements SellerDao {

    //atributo de conexao com o banco de dados
    private Connection conn;   
    
    //construtor que recebe a conexao como parametro
    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void update(Seller obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }


    //metodo auxiliar para instanciar um departamento a partir do ResultSet
    
    @Override
    public Seller findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT seller.*,department.Name as DepName "
                    + "FROM seller INNER JOIN department "
                    + "ON seller.DepartmentId = department.Id "
                    + "WHERE seller.Id = ?");

                    st.setInt(1, id);
                    rs = st.executeQuery();
                    if (rs.next()) {
                        Department dep = instantiateDepartment(rs);
                        dep.setID(rs.getInt("(DepartmentId"));
                        dep.setName(rs.getString("DepName"));
                        Seller obj = new Seller();
                        obj.setId(rs.getInt("Id"));
                        obj.setName(rs.getString("Name"));
                        obj.setEmail(rs.getString("Email"));
                        obj.setBaseSalary(rs.getDouble("BaseSalary"));
                        obj.setBirthDate(rs.getDate("BirthDate"));
                        obj.setDepartment(dep);
                        return obj;

        }
                    return null;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);  

        }

        }

       

    //metodo auxiliar para instanciar um vendedor a partir do ResultSet e propagar a exceçao SQLException
    private Seller instantiateDeller(ResultSet rs, Department dep) throws SQLException {
        Seller obj = new Seller();
                obj.setId(rs.getInt("Id"));
                obj.setName(rs.getString("Name"));
                obj.setEmail(rs.getString("Email"));
                obj.setBaseSalary(rs.getDouble("BaseSalary"));
                obj.setBirthDate(rs.getDate("BirthDate"));
                obj.setDepartment(dep);
                return obj;
    }

    //metodo auxiliar para instanciar um departamento a partir do ResultSet e propagar a exceçao SQLException
    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setID(rs.getInt("DepartmentId"));
        dep.setName(rs.getString("DepName"));
        return dep;
    }

    @Override
    public List<Seller> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public List<Seller> findByDepartment(Department department) {
       PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT seller.*,department.Name as DepName "
                    + "FROM seller INNER JOIN department "
                    + "ON seller.DepartmentId = department.Id "
                    + "WHERE seller.Id = ?"
                    + "ORDER BY Name");
            
            st.setInt(department.getId(), 0);

            rs = st.executeQuery();

        
            //While para percorrer o ResultSet, ArrayList para armazenar os vendedores
            List<Seller> list = new ArrayList<>();
            while (rs.next()) {
                department = instantiateDepartment(rs);
                Seller obj = instantiateDeller(rs, department);
                list.add(obj);
            }
            return list;
            
        }
        catch (RuntimeException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

    }


}
