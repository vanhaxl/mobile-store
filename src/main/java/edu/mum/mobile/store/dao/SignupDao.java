package edu.mum.mobile.store.dao;

import edu.mum.mobile.store.bean.User;
import edu.mum.mobile.store.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignupDao {
    public boolean createUser(User newUser) {
        if (checkUserExist(newUser.getEmail())) {
            return false;
        }
        String query = "INSERT INTO USER (full_name, email, telephone, address, password)"
                + " VALUES (?, ?, ?, ?, ?)";
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, newUser.getFullname());
            ps.setString(2, newUser.getEmail());
            ps.setString(3, newUser.getTelephone());
            ps.setString(4, newUser.getAddress());
            ps.setString(5, newUser.getPassword());
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean checkUserExist(String email) {
        String sql = String.format("SELECT ID FROM USER WHERE EMAIL = '%s'", email);
        System.out.println(sql);
        try {
            PreparedStatement preparedStatement = ConnectionManager.getConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
