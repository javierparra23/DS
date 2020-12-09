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

public class TipoEscritorioDao {

    public TipoEscritorioDao(){
        
    }
    
    public  ArrayList<TipoEscritorio> readTipoEscritorio(String serial){
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<TipoEscritorio> list = new ArrayList<>();
        
        try{
            con = Conexion.getConnection();
            String sql = "";
            
            if(serial.equals("")){
                sql = "SELECT * FROM tipoescritorio ORDER BY serial";
            } else {
                sql = "SELECT * FROM tipoescritorio where serial = ? "
                        + "ORDER BY serial";
            }
            pstm = con.prepareStatement(sql);
            
            rs = pstm.executeQuery();
            
            TipoEscritorio tipoEscritorio = null;
            
            while (rs.next()){
                tipoEscritorio = new TipoEscritorio();
                tipoEscritorio.setSerial(rs.getString("serial"));
                tipoEscritorio.setSerialPantalla(rs.getString("serialPantalla"));
                tipoEscritorio.setSerialMouse(rs.getString("serialMouse"));
                tipoEscritorio.setSerialTeclado(rs.getString("serialTeclado"));
                tipoEscritorio.setSerialParlantes(rs.getString("serialParlantes"));
                list.add(tipoEscritorio);
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
    
    public int createTipoEscritorio(TipoEscritorio tipoEscritorio) {
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            con = Conexion.getConnection();
            String sql = "INSERT INTO tipoescritorio "
                    + "(serial, serialPantalla, serialMouse, serialTeclado, serialParlantes)"
                    + " values (?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, tipoEscritorio.getSerial());
            pstm.setString(2, tipoEscritorio.getSerialPantalla());
            pstm.setString(3, tipoEscritorio.getSerialMouse());
            pstm.setString(4, tipoEscritorio.getSerialTeclado());
            pstm.setString(5, tipoEscritorio.getSerialParlantes());
            
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
    

    public int updateTipoEscritorio(TipoEscritorio tipoEscritorio) {
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            con = Conexion.getConnection();
            
            String sql = "UPDATE tipoescritorio "
                    + "SET serial = ?, serialPantalla = ?, serialMouse = ?, serialTeclado = ?, serialParlantes = ?"
                    + " WHERE serial = ?";
            pstm = con.prepareStatement(sql);
           
            pstm.setString(1, tipoEscritorio.getSerial());
            pstm.setString(2, tipoEscritorio.getSerialPantalla());
            pstm.setString(3, tipoEscritorio.getSerialMouse());
            pstm.setString(4, tipoEscritorio.getSerialTeclado());
            pstm.setString(5, tipoEscritorio.getSerialParlantes());
            pstm.setString(6, tipoEscritorio.getSerial());
            
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
   
    
    public int deleteTipoEscritorio(String Serial) {
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            con = Conexion.getConnection();
            String sql = "DELETE FROM tipoescritorio WHERE serial = ? ";
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
