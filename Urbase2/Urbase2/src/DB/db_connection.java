/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class db_connection {
 public static String IPHOST = "127.0.0.1";  //des variables static pour permet a tt les objets de l'utilisé
public static String url = "jdbc:mysql://" + IPHOST + ":3306/urbase6";   
    public static String username = "root";
    public static String password = "";
   public static int PORT = 11111;
    public Connection connection; // variable de type class pour utiliser les méthodes de la class prédifini Connection
    Statement statement;
    String SQL;

public db_connection(){  //Constrecteur de la class db_connexion
        try {
            this.connection= DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(db_connection.class.getName()).log(Level.SEVERE, null, ex);
        }


} //
   
   

  
   public Connection closeconnexion() {

        try {
            connection.close();
        } catch (Exception e) {System.err.println(e);//
        }
        return connection;
    }

    public ResultSet exécutionQuery(String sql) {
       // connexionDatabase();
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            System.out.println(sql);
        } catch (SQLException ex) {System.err.println(ex);//
        }
        return resultSet;
    }  // utiliser pour afficher un tableau sans modification (ajout, modifcation , supprission)

   public ResultSet exécutionUpdate(String sql) {
       // connexionDatabase();
        String result = "";
         ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            result = sql;

        } catch (SQLException ex) {
            result = ex.toString();
        }
        return resultSet;

    }  //pour faire MAJ 
    
    public ResultSet querySelect(String[] nomColonne, String nomTable) {

        //connexionDatabase();
        int i;
        SQL = "SELECT ";

        for (i = 0; i <= nomColonne.length - 1; i++) {
            SQL += nomColonne[i];
            if (i < nomColonne.length - 1) {
                SQL += ",";
            }
        }

        SQL += " FROM " + nomTable;
        return this.exécutionQuery(SQL);

    }


}
