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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class EmailValidator implements Chain{
    private Chain nextChain;

    public boolean isValid(String emailStr)
    {
        Matcher matcher = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).matcher(emailStr);
        if(matcher.find()){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void validate(HttpServletRequest req, HttpServletResponse resp) throws IOException, UserInputValidationException {
        PrintWriter out = resp.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));
        String firstname = req.getParameter("firstName");
        String lastname = req.getParameter("lastName");
        String email = req.getParameter("email");
        String phonenumber = req.getParameter("phoneNumber");
        String address = req.getParameter("address");
        String user = req.getParameter("usr");
        String password = req.getParameter("pswd");
        if(isValid(email)){
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
        else throw new UserInputValidationException("Invalid email");
    }
}
