package app.helper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyHelper{
    private final String DRIVER="com.mysql.cj.jdbc.Driver";
    private final String URL="jdbc:mysql://localhost:3306/jwd36";
    private final String USERNAME="root";
    private final String PASSWORD="Zarniaung 12";
    private static Connection connection=null;
    private static MyHelper instance=null;

    private MyHelper() {
        try {
            Class.forName(DRIVER);
            connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static MyHelper gatInstance() {
        if(instance==null) {
            instance=new MyHelper();
        }
        return instance;
    }
    public static Connection getConnection() {
        return connection;
    }
}
