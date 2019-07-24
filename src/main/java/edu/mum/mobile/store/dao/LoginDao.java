package edu.mum.mobile.store.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.mum.mobile.store.bean.User;
import edu.mum.mobile.store.util.ConnectionManager;

public class LoginDao {
    public User getUser(String email) {
        User user = null;
        String sql = String.format("SELECT ID, FULL_NAME, EMAIL, TELEPHONE, ADDRESS, PASSWORD, IS_ADMIN FROM USER WHERE email = '%s'", email);
        System.out.println(sql);
        try {
            PreparedStatement preparedStatement = ConnectionManager.getConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("ID"));
                user.setFullname(rs.getString("FULL_NAME"));
                user.setEmail(rs.getString("EMAIL"));
                user.setTelephone(rs.getString("TELEPHONE"));
                user.setAddress(rs.getString("ADDRESS"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setIsAdmin(rs.getInt("IS_ADMIN"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


}
