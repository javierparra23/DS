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

public class TipoPortatilDao {
    
     public TipoPortatilDao(){
        
    }
    
    public  ArrayList<TipoPortatil> readTipoPortatil(String serial){
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<TipoPortatil> list = new ArrayList<>();
        
        try{
            con = Conexion.getConnection();
            String sql = "";
            
            if(serial.equals("")){
                sql = "SELECT * FROM tipoportatil ORDER BY serial";
            } else {
                sql = "SELECT * FROM tipoportatil where serial = ? "
                        + "ORDER BY serial";
            }
            pstm = con.prepareStatement(sql);
            
            rs = pstm.executeQuery();
            
            TipoPortatil tipoPortatil = null;
            
            while (rs.next()){
                tipoPortatil = new TipoPortatil();
                tipoPortatil.setSerial(rs.getString("serial"));
                tipoPortatil.setSerialMouse(rs.getString("serialMouse"));
                tipoPortatil.setSerialBandejaRefri(rs.getString("serialBandejaRefri"));
                list.add(tipoPortatil);
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
    
    public int createTipoPortatil(TipoPortatil tipoPortatil) {
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            con = Conexion.getConnection();
            String sql = "INSERT INTO tipoportatil "
                    + "(serial, serialMouse, serialBandejaRefri)"
                    + " values (?,?,?)";
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, tipoPortatil.getSerial());
            pstm.setString(2, tipoPortatil.getSerialMouse());
            pstm.setString(3, tipoPortatil.getSerialBandejaRefri());
            
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
    

    public int updateTipoPortatil(TipoPortatil tipoPortatil) {
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            con = Conexion.getConnection();
            
            String sql = "UPDATE tipoportatil "
                    + "SET serial = ?, serialMouse = ?, serialBandejaRefri = ?"
                    + " WHERE serial = ?";
            pstm = con.prepareStatement(sql);
           
            pstm.setString(1, tipoPortatil.getSerial());
            pstm.setString(2, tipoPortatil.getSerialMouse());
            pstm.setString(3, tipoPortatil.getSerialBandejaRefri());
            pstm.setString(4, tipoPortatil.getSerial());
            
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
   
    
    public int deleteTipoPortatil(String Serial) {
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            con = Conexion.getConnection();
            String sql = "DELETE FROM tipoportatil WHERE serial = ? ";
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
