/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Servicios.Conexion;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.DriverManager;

public class AplicacionesDao {
    
    public AplicacionesDao(){
        
    }
    
    public  ArrayList<Aplicaciones> readAplicacion(String serial){
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Aplicaciones> list = new ArrayList<>();
        
        try{
            con = Conexion.getConnection();
            String sql = "";
            
            if(serial.equals("")){
                sql = "SELECT * FROM aplicaciones ORDER BY serialEquipo";
            } else {
                sql = "SELECT * FROM aplicaciones where serialEquipo = ? "
                        + "ORDER BY serialEquipo";
            }
            pstm = con.prepareStatement(sql);
            
            rs = pstm.executeQuery();
            
            Aplicaciones aplicaciones = null;
            
            while (rs.next()){
                aplicaciones = new Aplicaciones();
                aplicaciones.setSerialEquipo(rs.getString("serialEquipo"));
                aplicaciones.setAplicacionesInstaladas(rs.getString("aplicacionesInstaladas"));
                list.add(aplicaciones);
            }

        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Code : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Code : "
                        + ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        
    }
        return list;
    
}
    
    public int createAplicacion(Aplicaciones aplicaciones) {
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            con = Conexion.getConnection();
            String sql = "INSERT INTO aplicaciones "
                    + "(serialEquipo, aplicacionesInstaladas)"
                    + " values (?,?)";
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, aplicaciones.getSerialEquipo());
            pstm.setString(2, aplicaciones.getAplicacionesInstaladas());
            
            rtdo = pstm.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Code : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        } finally {
            try {
                if (pstm != null)     {
                    pstm.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Code : "
                        + ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    }
    

    public int updateAplicacion(Aplicaciones aplicaciones) {
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            con = Conexion.getConnection();
            
            String sql = "UPDATE aplicaciones "
                    + "SET serialEquipo = ?, aplicacionesInstaladas = ?"
                    + " WHERE serialEquipo = ?";
            pstm = con.prepareStatement(sql);
           
            pstm.setString(1, aplicaciones.getSerialEquipo());
            pstm.setString(2, aplicaciones.getAplicacionesInstaladas());
            pstm.setString(3, aplicaciones.getSerialEquipo());
            
            rtdo = pstm.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Code : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Code : "
                        + ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    }
   
    
    public int deleteAplicacion(String Serial) {
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            con = Conexion.getConnection();
            String sql = "DELETE FROM aplicaciones WHERE serialEquipo = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, Serial);
            rtdo = pstm.executeUpdate();
            return rtdo;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Code : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Code : "
                        + ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    }
    
}
