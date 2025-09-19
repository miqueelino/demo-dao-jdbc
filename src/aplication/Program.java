package aplication;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

    public static void main(String[] args){

        Department dep = new Department(1, "Books");

        Seller seller = new Seller(1, "Jon", "jon@gmail.com", new Date(),3000.0);

//chamando o metodo estatico da factory para criar o objeto SellerDao injetando a dependencia
        SellerDao sellerDao = DaoFactory.creatSellerDao();


        System.out.println(seller);
        System.out.println(dep);



    }

}
