
package Servicios;

import Modelo.UsuarioLoguin;
import Servicios.ConectarLoguin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConeccionUsuario {
    
    private final ConectarLoguin conexion;
    
    public ConeccionUsuario(){
        conexion=new ConectarLoguin();
    }
    
    
    
    
    public ArrayList<UsuarioLoguin> login(String user, String clave){
    
        
        Connection conectar=null;
        PreparedStatement pst;
        ResultSet rs ;
        UsuarioLoguin cuenta ;
        ArrayList list = new ArrayList();
        
        try{

            // Obtenemos la conexion con la base de datos
            conectar = conexion.dataSource.getConnection();
            
            if(conectar != null){
                
                //desencriptación tipo AES_DECRYPT, 
                //('contraseña del usuario', 'Clave de cifrado')              
                
                String sql ="SELECT User, Pass FROM usuarios WHERE User =?   "
                        + "AND Pass=AES_ENCRYPT(?, 'grupo2')";
                
                pst = conectar.prepareStatement(sql);
                pst.setString(1, user);
                pst.setString(2, clave);
                
                rs = pst.executeQuery();
                                
                if(rs.next()){
                    
                    cuenta = new UsuarioLoguin();
                    cuenta.setUser(rs.getString("User"));
                    cuenta.setPass(rs.getString("Pass"));                    
                    list.add(cuenta);

                }
                 
            }else{
                JOptionPane.showMessageDialog(null, "Hubo un error al realizar la operacion, intente mas tarde","ERROR",JOptionPane.ERROR_MESSAGE);
            }
                
        
        }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e , " .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
        }finally{
        
            try{
                conectar.close();
            }catch(SQLException ex){
                System.out.println("error "+ex);
            }
        
        }
        
       return list;
         
    }    
   
    
    
    
    
}
