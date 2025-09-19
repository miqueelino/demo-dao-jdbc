package model.dao;

import model.dao.impl.DB;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

    //metodo estatico que retorna uma instancia de SellerDaoJDBC
    public static SellerDao creatSellerDao(){
        return new SellerDaoJDBC(DB.getConnection());
    }

}
