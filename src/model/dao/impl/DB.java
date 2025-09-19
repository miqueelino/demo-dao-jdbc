package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {

    @Override
    public String toString() {
        return "DB []";
    }

    public static void closeStatement(PreparedStatement st) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'closeStatement'");
    }

    public static void closeResultSet(ResultSet rs) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'closeResultSet'");
    }

    public static Connection getConnection() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getConnection'");
    }

}
