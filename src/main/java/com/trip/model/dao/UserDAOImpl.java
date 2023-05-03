package com.trip.model.dao;

import com.trip.dto.User;
import com.trip.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {
    private DBUtil util;

    public UserDAOImpl() {
        util = DBUtil.getInstance();
    }

    @Override
    public boolean signIn(User user) {
        Connection con;
        PreparedStatement stat;
        String query = "select user_id from user where user_id=? and user_pw=?";
        boolean flag = false;
        try {

            con = util.getConnection();
            stat = con.prepareStatement(query);
            stat.setString(1, user.getId());
            stat.setString(2, user.getPw());
            ResultSet rs = stat.executeQuery();

            if (!rs.next()) {
                flag = false;
            } else {
                flag = true;
            }


            con.close();
            stat.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;

    }

    @Override
    public boolean signUp(User user) {

        if (checkDuplicate(user)) {
            return false;
        }

        Connection con;
        PreparedStatement stat;
        String query = "insert into user(user_id,user_pw,name,email_1,email_2) value (?,?,?,?,?)";

        try {
            con = util.getConnection();
            stat = con.prepareStatement(query);

            System.out.println("asdasd");

            stat.setString(1, user.getId());
            stat.setString(2, user.getPw());
            stat.setString(3, user.getName());
            stat.setString(4, user.getEmail_1());
            stat.setString(5, user.getEmail_2());

            int count = stat.executeUpdate();



            con.close();
            stat.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public ArrayList<User> selectAll() {
        return null;
    }

    @Override
    public boolean modify(String name, String id) {
        Connection con;
        PreparedStatement stat;
        String query = "update user SET name = ? where user_id = ?";

        try {
            con = util.getConnection();
            stat = con.prepareStatement(query);
            stat.setString(1,name);
            stat.setString(2,id);
            int c = stat.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public User userDetail(String id) {
        Connection con;
        PreparedStatement stat;
        String query = "select name,user_id,email_1,email_2 from user where user_id=?";
        User user = new User();

        try {
            con = util.getConnection();
            stat = con.prepareStatement(query);
            stat.setString(1, id);

            ResultSet rs = stat.executeQuery();
            if (rs.next()) {
                String name = rs.getString(1);
                String uid = rs.getString(2);
                String email_1 = rs.getString(3);
                String email_2 = rs.getString(4);
                user = new User(uid, null, name, email_1, email_2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public void delete(String id) {
        Connection con;
        PreparedStatement stat;
        String query = "delete from user where user_id=?";

        try {
            con = util.getConnection();
            stat = con.prepareStatement(query);
            stat.setString(1,id);

            int c = stat.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    private boolean checkDuplicate(User user) {

        Connection con;
        PreparedStatement stat;
        String query = "select user_id from user where user_id=?";
        boolean check = false;

        try {
            con = util.getConnection();
            stat = con.prepareStatement(query);

            stat.setString(1, user.getId());
            ResultSet rs = stat.executeQuery();


            if (rs.next()) {
                check = true;
            } else {
                check = false;
            }

            con.close();
            stat.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return check;
    }
}
