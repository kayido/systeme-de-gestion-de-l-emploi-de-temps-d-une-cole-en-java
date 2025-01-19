package sysgesemploidetemps;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class connectBD {
    public Connection createConnection() throws SQLException{
       
        Connection connection = null;
        MysqlDataSource mds = new MysqlDataSource();
              
       mds.setServerName("localhost");
       mds.setUser("root");
       mds.setPort(3306);
       mds.setPassword("");
       mds.setDatabaseName("emploi_de_temps");
       
       connection = mds.getConnection();
       return connection;
    }
}
