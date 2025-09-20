package controller.system;

import backend.exceptions.ObjectAlredyExistException;
import backend.user.User;
import backend.user.UserCreator;
import dababase.creation.UserCreateDB;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.security.InvalidParameterException;

/**
 * Servlet LogInServlet es el servlet encargado de
 *
 * @author YmCris
 * @since Sep 19, 2025
 */
@WebServlet(name = "LogInServlet", urlPatterns = {"/system/log-in-servlet"})
public class LogInServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserCreateDB userDB = new UserCreateDB();
            if (!userDB.userExist(request.getParameter("dpi"),request.getParameter("password"))) {
                throw new ObjectAlredyExistException("El usuario no existe");
            }else {
                throw new ObjectAlredyExistException("Enter");
            }
        } catch (InvalidParameterException | ObjectAlredyExistException e) {
            request.setAttribute("msg", e.getMessage());
            System.out.println("Ha ocurrido una exception del tipo " + e.getClass().getName() + " al realizar el log in del usuario en el servlet porque " + e.getMessage());
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/system/user-menu.jsp");
        dispatcher.forward(request, response);
    }

}
