package CoR;

import Builder.ConcreteUserBuilder;
import datastorage.DataStorage;
import exceptions.UserAlreadyExistsException;
import exceptions.UserInputValidationException;
import model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class NotEmptyFilter implements Chain{
    private Chain nextChain;
    @Override
    public void setNextChain(Chain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void validate(HttpServletRequest req, HttpServletResponse resp ) throws IOException, UserInputValidationException {
        int id = Integer.parseInt(req.getParameter("id"));
        String firstname = req.getParameter("firstName");
        String lastname = req.getParameter("lastName");
        String email = req.getParameter("email");
        String phonenumber = req.getParameter("phoneNumber");
        String address = req.getParameter("address");
        String user = req.getParameter("usr");
        String password = req.getParameter("pswd");


        //  req.getRequestDispatcher("home.jsp").forward(req,resp);
        if(!firstname.isEmpty() && !lastname.isEmpty() && !email.isEmpty() && !phonenumber.isEmpty() && !address.isEmpty()
                && !user.isEmpty() && !password.isEmpty()){
            this.nextChain.validate(req, resp);
        }
        else throw new UserInputValidationException("User Field blank");

    }
}
