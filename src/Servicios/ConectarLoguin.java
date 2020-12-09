package Servicios;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author jorgeluis
 */

public class ConectarLoguin {
    
    public DataSource dataSource;
    
    public String db = "eslameri";
    public String url = "jdbc:mysql://localhost/"+db;
    public String user = "root";
    public String pass = "";
    
//  Coneccion para loguin


    public ConectarLoguin(){

        inicializaDataSource();

    }



    private void inicializaDataSource(){


        BasicDataSource basicDataSource = new BasicDataSource();

        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUsername(user);
        basicDataSource.setPassword(pass);
        basicDataSource.setUrl(url);
        basicDataSource.setMaxActive(50);

        dataSource = basicDataSource;

    }

    

    
}