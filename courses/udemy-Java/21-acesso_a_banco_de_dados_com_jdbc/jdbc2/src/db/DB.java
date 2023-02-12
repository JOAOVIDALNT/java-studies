package db;

import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

    private static Connection conn = null;

    // conectar com o banco de dados
    public static Connection getConnection() {
        if (conn == null) {
            try {
                Properties props = loadProperties(); // pega as propriedades do db
                String url = props.getProperty("dburl"); // valor "dburl" em db.properties
                conn = DriverManager.getConnection(url, props);
                // conectar com o db no jdbc é instanciar um tipo Connection que é o que fizemos acima
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            } // SQLException extende a classe Exception, ou seja, você é obrigado a tratar, DbException que criamos extende RuntimeException, por isso optamos por trabalhar com ele
        }
    }

    private static Properties loadProperties() { // lê os dados de db.properties e guarda dentro de um arquivo Properties

        try(FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }

    }
}
