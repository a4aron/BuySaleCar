package controllers;

import Template.ConcreteRentProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

@WebServlet("/rent")
public class RentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        if( req.getSession().getAttribute("userName") != null) {
            String productID = req.getParameter("id");
            String startDate = req.getParameter("startDate");
            String endDate = req.getParameter("endDate");
            DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
            Date sdate = new Date(),edate = new Date();
            try {
                sdate = format.parse(startDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            try {
                edate = format.parse(endDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            ConcreteRentProcessor concreteRentProcessor = new ConcreteRentProcessor();


            if(concreteRentProcessor.doRent(Integer.parseInt(req.getSession().getAttribute("uid").toString()),
                    Integer.parseInt(productID) ,
                    sdate,edate)) {
                out.print("true");
            }
else {
                out.print("false");
            }
        }
        else {
            out.write("false");
        }
    }
}
