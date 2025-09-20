package controller.system;

import backend.exceptions.ObjectAlredyExistException;
import backend.user.User;
import backend.user.UserCreator;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.security.InvalidParameterException;

/**
 * Servlet SignUpServlet es el servlet encargado de
 *
 * @author YmCris
 * @since Sep 18, 2025
 */
@WebServlet(name = "SignUpServlet", urlPatterns = {"/mvc/system/sign-up-servlet"})
public class SignUpServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserCreator creator = new UserCreator();
        try {
            User user = creator.createUser(request);
            request.setAttribute("newUser", user);
        } catch (InvalidParameterException | ObjectAlredyExistException e) {
            request.setAttribute("error", e.getMessage());
            System.out.println("Ha ocurrido una exception del tipo " + e.getClass().getName() + " al realizar la creacion del usuario en el request porque " + e.getMessage());
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/users/created-user.jsp");
        dispatcher.forward(request, response);
    }

}
