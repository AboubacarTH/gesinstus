/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import database.ConnecterDB;
import java.sql.Connection;

/**
 *
 * @author ATH
 */
public class Main {
    private static Connection connection;

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        connection = new ConnecterDB().getConnection();
    }

    public static Connection getConnection() {
        return connection;
    }
    
}
