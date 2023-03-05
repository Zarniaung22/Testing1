package app.dao;

import app.helper.MyHelper;
import app.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public int createUser(User user) {
        int status=0;
        Connection connection=MyHelper.gatInstance().getConnection();
        String query="INSERT INTO user (name,email,phone,city) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setString(1,user.getName());
            ps.setString(2,user.getEmail());
            ps.setString(3,user.getPhone());
            ps.setString(4,user.getCity());
            status=ps.executeUpdate();


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return status;
    }

    public List<User> getAllUser() {


        Connection con= MyHelper.gatInstance().getConnection();
        String query="SELECT * FROM User";
        List<User> users=new ArrayList<>();
        ResultSet rs;
        try {
            PreparedStatement ps=con.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next()) {
                User user=new User(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("phone"),rs.getString("city"));
                users.add(user);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }return users;
    }
    public int deleteUser(int id) {

        Connection con=MyHelper.gatInstance().getConnection();
        String query="DELETE FROM User WHERE id=?";
        int status=0;
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1, id);
            status=ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return status;
    }
    public User getUserById(int id) {

        Connection con=MyHelper.gatInstance().getConnection();

        User user=null;
        String query="SELECT * FROM User WHERE id=?";
        ResultSet rs;
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            if(rs.next()) {
                user=new User(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("phone"),rs.getString("city"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
    }
    public int EditUser(User user) {
        int status=0;
        Connection con=MyHelper.gatInstance().getConnection();

        String query="UPDATE User SET name=? , email=? , phone=? , city=? WHERE id=?";

        try {
            PreparedStatement ps=con.prepareStatement(query);

            ps.setString(1,user.getName());
            ps.setString(2,user.getEmail());
            ps.setString(3,user.getPhone());
            ps.setString(4,user.getCity());
            ps.setInt(5,user.getId());
            status=ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return status;
    }
}