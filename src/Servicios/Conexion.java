/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import java.awt.JobAttributes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhon_kq
 */
public class Conexion {
    
 /*   private String driver="com.mysql.jdbc.Driver";
    private String cadenaConexion="jdbc:mysql://127.0.0.1/eslameri";
    private String usuario="root";
    private String contraseña="";
    public  Connection con;
    
    public Conexion(){
        try{
            Class.forName(driver);
            con=DriverManager.getConnection(cadenaConexion, usuario, contraseña);
            JOptionPane.showMessageDialog(null, "se conecto");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos"+e.getMessage());
        }
    }*/
        private static Connection con = null;
    
    public static Connection getConnection(){
        try
        {
            if(con == null){
                //Determina cuando se termina el programa
                Runtime.getRuntime().addShutdownHook(new MiShDwnHook());
                //Recupera los parámetros de conexión del archivo 
                //jdbc.properties
                ResourceBundle rb = ResourceBundle.getBundle("servicios.jdbc");
                String driver = rb.getString("driver");
                String url = rb.getString("url");
                String pwd = rb.getString("pwd");
                String usr = rb.getString("usr");
                
                Class.forName(driver);
                con = DriverManager.getConnection(url, usr, pwd);
            }
                         
        }
        catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null,"Error : " + 
                    ex.getMessage());
        }
        return con;
    }
    
    static class MiShDwnHook extends Thread{
        //Justo antes de finaliza el programa la JVM invocará
        //este método donde podemos cerra la conexión
        @Override
        public void run(){
            try{
                Connection con = Conexion.getConnection();
                con.close();                     
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null,"Error 1: " + 
                        ex.getMessage());
            }
        }
    }
}
