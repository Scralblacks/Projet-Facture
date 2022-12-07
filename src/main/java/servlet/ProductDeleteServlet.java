package servlet;

import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/products/delete")
public class ProductDeleteServlet extends HttpServlet {

    public static final String URL = "/products/delete";

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        getServletContext()
//                .getRequestDispatcher("/WEB-INF/del-game.jsp")
//                .forward(req, resp);
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        ProductDAO productDao = new ProductDAO();

        System.out.println(Long.parseLong(req.getParameter("idProduct")));

        productDao.delete(Long.parseLong(req.getParameter("idProduct")));

        resp.sendRedirect(ListProductServlet.URL);
    }
}
