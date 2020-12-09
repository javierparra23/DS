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

public class InformeDao {
    
    public  ArrayList<Informe> readInforme(String idInforme){
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Informe> list = new ArrayList<>();
        
        try{
            con = Conexion.getConnection();
            String sql = "";
            
            if(idInforme.equals("")){
                sql = "SELECT * FROM informe ORDER BY idInforme";
            } else {
                sql = "SELECT * FROM informe where idInforme = ? "
                        + "ORDER BY idInforme";
            }
            pstm = con.prepareStatement(sql);
            
            rs = pstm.executeQuery();
            
            Informe informe = null;
            
            while (rs.next()){
                informe = new Informe();
                informe.setIdInforme(rs.getString("idInforme"));
                informe.setFechaReporte(rs.getString("fechaReporte"));
                informe.setIdEmpleado(rs.getString("idEmpleado"));
                informe.setTipoInforme(rs.getString("tipoInforme"));
                informe.setNitEmpresa(rs.getString("nitEmpresa"));
                list.add(informe);
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
    
    public int createInforme(Informe informe) {
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            con = Conexion.getConnection();
            String sql = "INSERT INTO informe "
                    + "(idInforme, fechaReporte, idEmpleado, tipoInforme, tipoInforme)"
                    + " values (?,CURRENT_DATE,?,?,?)";
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, informe.getIdInforme());
            pstm.setString(2, informe.getIdEmpleado());
            pstm.setString(3, informe.getTipoInforme());
            pstm.setString(4, informe.getNitEmpresa());
            
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
    

    public int updateInforme(Informe informe) {
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            con = Conexion.getConnection();
            
            String sql = "UPDATE informe "
                    + "SET idInforme = ?, fechaReporte = ?, idEmpleado = ?, tipoInforme = ?, nitEmpresa = ?"
                    + " WHERE idInforme = ?";
            pstm = con.prepareStatement(sql);
           
            pstm.setString(1, informe.getIdInforme());
            pstm.setString(2, informe.getFechaReporte());
            pstm.setString(3, informe.getIdEmpleado());
            pstm.setString(4, informe.getTipoInforme());
            pstm.setString(5, informe.getNitEmpresa());
            pstm.setString(6, informe.getIdInforme());
            
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
   
    
    public int deleteInforme(String idInforme) {
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;

        try {
            con = Conexion.getConnection();
            String sql = "DELETE FROM informe WHERE idInforme = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, idInforme);
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
