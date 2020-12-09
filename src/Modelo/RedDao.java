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

public class RedDao {
    
    public RedDao(){
        
    }
    
    public  ArrayList<Red> readRed(String ipEquipo){
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Red> list = new ArrayList<>();
        
        try{
            con = Conexion.getConnection();
            String sql = "";
            
            if(ipEquipo.equals("")){
                sql = "SELECT * FROM redes ORDER BY ipEquipo";
            } else {
                sql = "SELECT * FROM redes where ipEquipo = ? "
                        + "ORDER BY ipEquipo";
            }
            pstm = con.prepareStatement(sql);
            
            rs = pstm.executeQuery();
            
            Red red = null;
            
            while (rs.next()){
                red = new Red();
                red.setIpEquipo(rs.getString("ipEquipo"));
                red.setSerialEquipo(rs.getString("serialEquipo"));
                red.setPermisosIp(rs.getString("permisosIp"));
                list.add(red);
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
    
    public int createRed(Red red) {
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            con = Conexion.getConnection();
            String sql = "INSERT INTO redes "
                    + "(ipEquipo, serialEquipo, permisosIp)"
                    + " values (?,?,?)";
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, red.getIpEquipo());
            pstm.setString(2, red.getSerialEquipo());
            pstm.setString(3, red.getPermisosIp());
            
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
    

    public int updateRed(Red red) {
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            con = Conexion.getConnection();
            
            String sql = "UPDATE redes "
                    + "SET ipEquipo = ?, serialEquipo = ?, permisosIp = ?"
                    + " WHERE ipEquipo = ?";
            pstm = con.prepareStatement(sql);
           
            pstm.setString(1, red.getIpEquipo());
            pstm.setString(2, red.getSerialEquipo());
            pstm.setString(3, red.getPermisosIp());
            pstm.setString(4, red.getIpEquipo());
            
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
   
    
    public int deleteRed(String ipEquipo) {
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            con = Conexion.getConnection();
            String sql = "DELETE FROM redes WHERE ipEquipo = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, ipEquipo);
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
