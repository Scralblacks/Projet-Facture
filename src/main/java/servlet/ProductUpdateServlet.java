package servlet;

import dao.ProductDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import object.Product;

import java.io.IOException;

@WebServlet(urlPatterns = "/products/update")
public class ProductUpdateServlet extends HttpServlet {

    public static final String URL = "/products/update";
    public static ProductDAO productDao = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("product", productDao.findById(Long.parseLong(req.getParameter("idProduct"))).get());
        req.setAttribute("idProduct", req.getParameter("idProduct"));

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/product-edit.jsp");
        rd.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Product updatedProduct = productDao.findById(Long.parseLong(req.getParameter("idProduct"))).get();

        updatedProduct.setName(req.getParameter("name"));

        System.out.println(req.getParameter("price_wto_taxes"));
        System.out.println(Double.parseDouble(req.getParameter("price_wto_taxes")));

        updatedProduct.setPrice_wto_taxes(Double.parseDouble(req.getParameter("price_wto_taxes")));

        productDao.update(updatedProduct);

        resp.sendRedirect(ListProductServlet.URL);
    }
}
