package controllers;

import Builder.ConcreteUserBuilder;
import Builder.UserBuilder;
import CoR.Chain;
import CoR.EmailValidator;
import CoR.NotEmptyFilter;
import datastorage.DataStorage;
import exceptions.UserAlreadyExistsException;
import exceptions.UserInputValidationException;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HomeServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Chain nonEmptyFilter = new NotEmptyFilter();
        Chain emailValidator = new EmailValidator();
        nonEmptyFilter.setNextChain(emailValidator);

        try {
            nonEmptyFilter.validate(req,resp);
        } catch (UserInputValidationException e) {
            resp.getWriter().print("false");
        }
/*
        PrintWriter out = resp.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));
        String firstname = req.getParameter("firstName");
        String lastname = req.getParameter("lastName");
        String email = req.getParameter("email");
        String phonenumber = req.getParameter("phoneNumber");
        String address = req.getParameter("address");
        String user = req.getParameter("usr");
        String password = req.getParameter("pswd");


        if(!firstname.isEmpty() && !lastname.isEmpty() && !email.isEmpty() && !phonenumber.isEmpty() && !address.isEmpty()
                && !user.isEmpty() && !password.isEmpty()){

            //builder pattern
            User newUser = new ConcreteUserBuilder(firstname, lastname).Email(email).PhoneNumber(phonenumber).Address(address).
                    UserName(user).Password(password).build();


            try {
                DataStorage.INSTANCE.addUser(newUser);
                out.print("true");
            } catch (UserAlreadyExistsException e) {
                e.printStackTrace();
                out.print("false");
            }

        }
        else {
           // req.setAttribute("msg","Account not created. Field missing.");
            //out.print("failed");
            out.print("false");
          //  req.getRequestDispatcher("home.jsp").forward(req,resp);

        }
*/


    }
}
