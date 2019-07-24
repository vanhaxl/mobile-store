package edu.mum.mobile.store;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import edu.mum.mobile.store.util.ConnectionManager;

@WebListener
public class ApplicationInitialization implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		// initialize a database connection before the web application is started, 
		String dbUrl = sc.getInitParameter("db_url");
		String dbUser = sc.getInitParameter("db_user");
		String dbPassword = sc.getInitParameter("db_password");
		ConnectionManager.createConnection(dbUrl, dbUser, dbPassword);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ConnectionManager.closeConnection();
	}

}
