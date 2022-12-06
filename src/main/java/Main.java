import dao.BillDAO;
import dao.ClientDAO;
import dao.ProductsDAO;
import dao.VatDAO;

import object.Bill;
import object.Client;
import object.Products;
import object.Vat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        // Bloc initialisation
        VatDAO vatDAO = new VatDAO();
        ProductsDAO productsDAO = new ProductsDAO();
        BillDAO billDAO = new BillDAO();
        ClientDAO clientDAO = new ClientDAO();
        List<Products> listProductsBill1 = new ArrayList<>();
        List<Bill> listBillJeanMartin = new ArrayList<>();
        List<Bill> listBillLait = new ArrayList<>();

        // Bloc add Vat
        vatDAO.create(new Vat(0));
        vatDAO.create(new Vat(0.022));
        vatDAO.create(new Vat(0.055));
        vatDAO.create(new Vat(0.1));
        vatDAO.create(new Vat(0.2));

        //Bloc creating objects
        Products lait = new Products("Lait", 1.24, vatDAO.findById(Long.valueOf(3L)).get());
        Bill bill1 = new Bill(LocalDate.now(), 1240L, (1240 * 1.055));
        Client jeanMartin = new Client("Jean Martin", "1 rue du Moublin", "48925", "Sinistrose-les-Mines", "03 59 48 16 32" , "jean.martin@email.fr");

        //Bloc completing variable
        listBillJeanMartin.add(bill1);
        listProductsBill1.add(lait);
        listBillLait.add(bill1);

        //Bloc completing objects
        jeanMartin.setBillList(listBillJeanMartin);
        bill1.setClient(jeanMartin);
        bill1.setProductByBillList(listProductsBill1);

        //Bloc send objects
        productsDAO.create(lait);
        billDAO.create(bill1);

    }

}
