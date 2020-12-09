/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Servicios.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EmpresaDao {
    
     public EmpresaDao(){
        
    }
    
    public  ArrayList<Empresa> readEmpresa(String nit){
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Empresa> list = new ArrayList<>();
        
        try{
            con = Conexion.getConnection();
            String sql = "";
            
            if(nit.equals("0")){
                sql = "SELECT * FROM empresa ORDER BY nit";
            } else {
                sql = "SELECT * FROM empresa where nit = ? "
                        + "ORDER BY nit";
            }
            pstm = con.prepareStatement(sql);
            
            rs = pstm.executeQuery();
            
            Empresa empresa = null;
            
            while (rs.next()){
                empresa = new Empresa();
                empresa.setNit(rs.getString("nit"));
                empresa.setNombre(rs.getString("nombre"));
                empresa.setDireccion(rs.getString("direccion"));
                empresa.setDescripcion(rs.getString("descripcion"));
                list.add(empresa);
            }

        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Code : "
                    + ex.getErrorCode() + "\nError en listado:" + ex.getMessage());
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
                        + ex.getErrorCode() + "\nError en listado:" + ex.getMessage());
            }
        
    }
        return list;
    
}
    
    public int createEmpresa(Empresa empresa) {
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            con = Conexion.getConnection();
            String sql = "INSERT INTO empresa "
                    + "(nit, nombre, direccion, descripcion)"
                    + " values (?,?,?,?)";
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, empresa.getNit());
            pstm.setString(2, empresa.getNombre());
            pstm.setString(3, empresa.getDireccion());
            pstm.setString(4, empresa.getDescripcion());
            
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
    

    public int updateEmpresa(Empresa empresa) {
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            con = Conexion.getConnection();
            
            String sql = "UPDATE empresa "
                    + "SET nit = ?, nombre = ?, direccion = ?, descripcion = ?"
                    + " WHERE nit = ?";
            pstm = con.prepareStatement(sql);
           
            pstm.setString(1, empresa.getNit());
            pstm.setString(2, empresa.getNombre());
            pstm.setString(3, empresa.getDireccion());
            pstm.setString(4, empresa.getDescripcion());
            pstm.setString(5, empresa.getNit());
            
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
   
    
    public int deleteEmpresa(String nit) {
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            con = Conexion.getConnection();
            String sql = "DELETE FROM empresa WHERE nit = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, nit);
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
