package edu.mum.mobile.store.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mum.mobile.store.bean.User;
import edu.mum.mobile.store.dao.SignupDao;
import edu.mum.mobile.store.dto.ResultDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ObjectMapper mapper = new ObjectMapper();
    private SignupDao db = new SignupDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/signup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get received JSON data from request
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String json = "";
        if (br != null) {
            json = br.readLine();
        }
        User user = mapper.readValue(json, User.class);
        boolean success = db.createUser(user);
        resp.getWriter().print(mapper.writeValueAsString(new ResultDto(success)));

    }
}
