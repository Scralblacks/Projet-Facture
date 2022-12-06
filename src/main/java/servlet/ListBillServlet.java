package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/bills")
public class ListBillServlet extends HttpServlet {
    public static final String URL = "/bills";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("COUCOU !");

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/bill-list.jsp");
        rd.forward(req, resp);

    }
}

