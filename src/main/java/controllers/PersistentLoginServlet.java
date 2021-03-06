package controllers;

import datastorage.DataStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/persistentlogin")
public class PersistentLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String persistentCookieValue = "";
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("persistentlogintoken")) {
                persistentCookieValue = cookie.getValue();
                break;
            }
        }

            PrintWriter out = resp.getWriter();
            String userName = DataStorage.INSTANCE.cookieMap.get(persistentCookieValue);
            if (userName != null && userName != ""){
                req.getSession().setAttribute("userName", userName);
                out.write(userName);
            }
            else{
                out.write("false");
            }
    }
}
