package com.bc.jde.dis.request.service;

import com.bc.jde.dis.request.entity.DataField;
import com.bc.jde.dis.request.entity.DataObject;
import com.bc.jde.dis.request.entity.DataRow;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno Condemi
 */
public class SqlProcessor {

    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "password";

    public List<DataRow>  processSqlString(String sql) {

      return  executeQuery(sql);
    }

    private List<DataRow>   executeQuery(String sql) {

        Statement statement = null;

        Connection dbConnection = getDBConnection();
        try {
            statement = dbConnection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(SqlProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SqlProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }

       List<DataRow>  dataObject = null;
        try {
            dataObject = SqlProcessorHelper.buildDataObjcet(rs);
        } catch (SQLException ex) {
            Logger.getLogger(SqlProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dataObject;
    }

    private Connection getDBConnection() {
        Connection dbConnection = null;

        try {

            Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {

            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
                    DB_PASSWORD);
            return dbConnection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;
        
    }

}
