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

public class EmpleadoDao {
    
    public  ArrayList<Empleado> readEmpleado(String idEmpleado){
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Empleado> list = new ArrayList<>();
        
        try{
            con = Conexion.getConnection();
            String sql = "";
            
            if(idEmpleado.equals("")){
                sql = "SELECT * FROM empleado ORDER BY idEmpleado";
            } else {
                sql = "SELECT * FROM empleado where idEmpleado = ? "
                        + "ORDER BY idEmpleado";
            }
            pstm = con.prepareStatement(sql);
            
            rs = pstm.executeQuery();
            
            Empleado empleado = null;
            
            while (rs.next()){
                empleado = new Empleado();
                empleado.setIdEmpleado(rs.getString("idEmpleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setArea(rs.getString("area"));
                empleado.setSerialEquipo(rs.getString("serialEquipo"));
                empleado.setTipoEmpleado(rs.getString("tipoEmpleado"));
                empleado.setNitEmpresa(rs.getString("nitEmpresa"));
                list.add(empleado);
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
    
    public int createEmpleado(Empleado empleado) {
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            con = Conexion.getConnection();
            String sql = "INSERT INTO empleado "
                    + "(idEmpleado, nombre, apellido, area, serialEquipo, tipoEmpelado, nitEmpresa)"
                    + " values (?,?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, empleado.getIdEmpleado());
            pstm.setString(2, empleado.getNombre());
            pstm.setString(3, empleado.getApellido());
            pstm.setString(4, empleado.getArea());
            pstm.setString(5, empleado.getSerialEquipo());
            pstm.setString(6, empleado.getTipoEmpleado());
            pstm.setString(7, empleado.getNitEmpresa());
            
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
    

    public int updateEmpleado(Empleado empleado) {
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            con = Conexion.getConnection();
            
            String sql = "UPDATE empleado "
                    + "SET idEmpleado = ?, nombre = ?, apellido = ?, area = ?, serialEquipo = ?, tipoEmpleado = ?, nitEmpresa = ?"
                    + " WHERE idEmpleado = ?";
            pstm = con.prepareStatement(sql);
           
            pstm.setString(1, empleado.getIdEmpleado());
            pstm.setString(2, empleado.getNombre());
            pstm.setString(3, empleado.getApellido());
            pstm.setString(4, empleado.getArea());
            pstm.setString(5, empleado.getSerialEquipo());
            pstm.setString(6, empleado.getTipoEmpleado());
            pstm.setString(7, empleado.getNitEmpresa());
            pstm.setString(8, empleado.getIdEmpleado());
            
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
   
    
    public int deleteEmpleado(String idEmpleado) {
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            con = Conexion.getConnection();
            String sql = "DELETE FROM empleado WHERE idEmpleado = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, idEmpleado);
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
