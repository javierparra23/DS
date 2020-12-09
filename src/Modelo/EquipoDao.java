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

public class EquipoDao {
    
    public EquipoDao(){
        
    }
    
    public  ArrayList<Equipo> readEquipo(String serial){
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Equipo> list = new ArrayList<>();
        
        try{
            con = Conexion.getConnection();
            String sql = "";
            
            if(serial.equals("")){
                sql = "SELECT * FROM equipo ORDER BY serial";
            } else {
                sql = "SELECT * FROM equipo where serial = ? "
                        + "ORDER BY serial";
            }
            pstm = con.prepareStatement(sql);
            
            rs = pstm.executeQuery();
            
            Equipo equipo = null;
            
            while (rs.next()){
                equipo = new Equipo();
                equipo.setSerial(rs.getString("serial"));
                equipo.setMarca(rs.getString("marca"));
                equipo.setIp(rs.getString("ip"));
                equipo.setEstado(rs.getString("estado"));
                equipo.setCaracteristicas(rs.getString("caracteristicas"));
                equipo.setIdUsuario(rs.getInt("idUsuario"));
                equipo.setArea(rs.getString("area"));
                equipo.setTipo(rs.getString("tipo"));
                equipo.setFechaIngreso(rs.getString("fechaIngreso"));
                list.add(equipo);
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
    
    public int createEquipo(Equipo equipo) {
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            con = Conexion.getConnection();
            String sql = "INSERT INTO equipo "
                    + "(serial, marca, ip, estado, caracteristicas, idUsuario, area, tipo, fechaIngreso)"
                    + " values (?,?,?,?,?,?,?,?,CURRENT_DATE)";
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, equipo.getSerial());
            pstm.setString(2, equipo.getMarca());
            pstm.setString(3, equipo.getIp());
            pstm.setString(4, equipo.getEstado());
            pstm.setString(5, equipo.getCaracteristicas());
            pstm.setInt(6, equipo.getIdUsuario());
            pstm.setString(7, equipo.getArea());
            pstm.setString(8, equipo.getTipo());
            
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
    

    public int updateEquipo(Equipo equipo) {
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            con = Conexion.getConnection();
            
            String sql = "UPDATE equipo "
                    + "SET serial = ?, marca = ?, ip = ?, estado = ?, caracteristicas = ?, idUsuario = ?, area = ?, tipo = ?, fechaIngreso = ?"
                    + " WHERE serial = ?";
            pstm = con.prepareStatement(sql);
           
            pstm.setString(1, equipo.getSerial());
            pstm.setString(2, equipo.getMarca());
            pstm.setString(3, equipo.getIp());
            pstm.setString(4, equipo.getEstado());
            pstm.setString(5, equipo.getCaracteristicas());
            pstm.setInt(6, equipo.getIdUsuario());
            pstm.setString(7, equipo.getArea());
            pstm.setString(8, equipo.getTipo());
            pstm.setString(9, equipo.getFechaIngreso());
            pstm.setString(10, equipo.getSerial());
            
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
   
    
    public int deleteEquipo(String Serial) {
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            con = Conexion.getConnection();
            String sql = "DELETE FROM equipo WHERE serial = ? ";
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
