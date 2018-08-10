package controllers;

import Observer.ProductData;
import datastorage.DataStorage;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/suscribe")
public class SuscribtionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean response = false;
        if( req.getSession().getAttribute("userName") != null) {
            String type = req.getParameter("type");
            if(type != null){
                User user = DataStorage.INSTANCE.getUserByUsername(req.getSession().getAttribute("userName").toString());
                if(type.toLowerCase().equals("suscribe")){
                    if(user != null) {
                        ProductData.INSTANCE.addObserver(user);
                        response = true;
                    }

                }
                else if(type.toLowerCase().equals("unsuscribe")){
                    ProductData.INSTANCE.removeObserver(user);
                    response = true;
                }
        }
        }
        PrintWriter out = resp.getWriter();
        out.print(response);
    }
}
