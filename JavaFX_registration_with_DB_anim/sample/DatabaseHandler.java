package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseHandler extends configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName + "?verifyServerCertificate=false"
                                            +"&useSSL=false"
                                            +"&requireSSL=false"
                                            +"&useLegacyDatetimeCode=false"
                                            +"&amp"+"&serverTimezone=UTC";

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);

        return dbConnection;
    }

    public void registerUser(User user){
        String insert = "INSERT INTO "+Const.USER_TABLE+"("+Const.USERS_NAME+","
                +Const.USERS_LASTNAME+","+Const.USERS_USERNAME+","+Const.USERS_PASSWORD+","
                   +Const.USERS_LOCATION+","+Const.USERS_GENDER+")"+"VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement (insert);
            prSt.setString(1, user.getName());
            prSt.setString(2, user.getLastname());
            prSt.setString(3, user.getUsername());
            prSt.setString(4, user.getPassword());
            prSt.setString(5, user.getLocation());
            prSt.setString(6, user.getGender());

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUser(User user){
        ResultSet reSet = null;

         String select = "SELECT * FROM "+Const.USER_TABLE+" WHERE "
                 +Const.USERS_USERNAME+"=? AND "+Const.USERS_PASSWORD+"=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getUsername());
            prSt.setString(2, user.getPassword());

            reSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return reSet;
    }
}


