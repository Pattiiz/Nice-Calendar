/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

/**
 * Web application lifecycle listener.
 *
 * @author Plaster
 */
public class Init implements ServletContextListener {
    private Connection caldb;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        try {
            caldb = getCaldb().getConnection();
            sce.getServletContext().setAttribute("connection", caldb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("complete destroyed");
        try{
            caldb.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private DataSource getCaldb() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("java:comp/env/caldb");
    }
}
