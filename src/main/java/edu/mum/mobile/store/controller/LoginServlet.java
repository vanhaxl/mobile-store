package edu.mum.mobile.store.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.mum.mobile.store.bean.User;
import edu.mum.mobile.store.dao.LoginDao;
import edu.mum.mobile.store.dto.ResultDto;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username="";
        String password = "";
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("username")) {
                username = cookie.getValue();
            } else if(cookie.getName().equals("password")){
                password = cookie.getValue();
            }
        }
        if(!username.isEmpty() && !password.isEmpty()){
            req.setAttribute("username", username);
            req.setAttribute("password", password);
            req.setAttribute("jspremember", "checked");
        }
        req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String json = "";
        if (br != null) {
            json = br.readLine();
        }
        User jsUser = mapper.readValue(json, User.class);
        String username = jsUser.getEmail();
        String password = jsUser.getPassword();
        int rememberme = Integer.parseInt(req.getParameter("rememberme"));
        boolean success = false;

        LoginDao db = new LoginDao();
        User user = db.getUser(username);
        if (user == null || !password.equals(user.getPassword())) {
        		resp.getWriter().print(mapper.writeValueAsString(new ResultDto(success)));
        } else { //username and password are correct
            if (rememberme == 1) {
                Cookie cookie = new Cookie("username", username);
                Cookie cookie2 = new Cookie("password", password);
                cookie.setMaxAge(30 * 24 * 3600); //in seconds
                cookie2.setMaxAge(30 * 24 * 3600); //in seconds
                resp.addCookie(cookie);
                resp.addCookie(cookie2);
            } else {
                Cookie cookie = new Cookie("username", null);
                Cookie cookie2 = new Cookie("password", null);
                cookie.setMaxAge(0); //in seconds
                cookie2.setMaxAge(0); //in seconds
                resp.addCookie(cookie);
                resp.addCookie(cookie2);
            }
            success = true;
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.getWriter().print(mapper.writeValueAsString(new ResultDto(success)));
        }
        
    }
}
