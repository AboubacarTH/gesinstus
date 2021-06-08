    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
import javax.swing.JOptionPane;
import view.dialog.DataBaseConnection;

/**
 *
 * @author wankoye
 */
public class ConnecterDB {
    private Connection connection;
    private static FileManager fileManager;
    private String url;
    private String user;
    private String password;
    
    public ConnecterDB() {
        fileManager = new FileManager();
        url = "jdbc:mysql://"+ fileManager.getServerAdress() +"/gesinstus";
        user = "gesinstus";
        password = "gesinstus";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, password);
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "connexion non etablie" +e.getMessage());
            DataBaseConnection data = new DataBaseConnection(null, true);
            data.setVisible(true);
            System.exit(0);
        }
    }

    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }
    
    /**
     *
     * @return
     */
    public FileManager getFileManager(){
        return fileManager;
    }
}
