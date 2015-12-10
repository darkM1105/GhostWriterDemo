package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(
        name = "game",
        urlPatterns = {"/game"}
)

public class GameServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "game.jsp";
        String message = "This message came from the servlet";

        request.setAttribute("message", message);

        System.out.println("Got Here!!!");

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

}

