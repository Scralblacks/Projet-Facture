package servlet;

import dao.BillDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import object.Bill;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(urlPatterns = "/bills/update")
public class BillUpdateServlet extends HttpServlet {

    public static final String URL = "/bills/update";
    public static BillDAO billDao = new BillDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("bill", billDao.findById(Long.parseLong(req.getParameter("idBill"))).get());
        req.setAttribute("idBill", req.getParameter("idBill"));

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/bill-edit.jsp");
        rd.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Bill updatedBill = billDao.findById(Long.parseLong(req.getParameter("idBill"))).get();

        System.out.println(Double.parseDouble(req.getParameter("cost_wto_taxes")));
        System.out.println(LocalDate.parse(req.getParameter("date_of_creation")));

        updatedBill.setCost_wto_taxes(Double.parseDouble(req.getParameter("cost_wto_taxes")));
        updatedBill.setCost_wt_taxes(Double.parseDouble(req.getParameter("cost_wto_taxes")) * 1.055);
        updatedBill.setDate_of_creation(LocalDate.parse(req.getParameter("date_of_creation")));

        billDao.update(updatedBill);

        resp.sendRedirect(ListBillServlet.URL);
    }
}
