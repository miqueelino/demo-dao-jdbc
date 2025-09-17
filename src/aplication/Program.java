package aplication;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

    public static void main(String[] args){

        Department dep = new Department(1, "Books");

        Seller seller = new Seller(1, "Jon", "jon@gmail.com", new Date(),3000.0);
        System.out.println(seller);
        System.out.println(dep);



    }

}
