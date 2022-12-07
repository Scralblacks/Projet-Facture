package servlet;

import dao.BillDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/bills/delete")
public class BillDeleteServlet extends HttpServlet {

    public static final String URL = "/bills/delete";

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        getServletContext()
//                .getRequestDispatcher("/WEB-INF/del-game.jsp")
//                .forward(req, resp);
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        BillDAO billDao = new BillDAO();

        System.out.println(Long.parseLong(req.getParameter("idBill")));

        billDao.delete(Long.parseLong(req.getParameter("idBill")));

        resp.sendRedirect(ListBillServlet.URL);
    }
}
