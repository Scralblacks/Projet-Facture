import dao.VatDAO;

import object.Vat;


public class Main {

    public static void main(String[] args) {

        VatDAO vatDAO = new VatDAO();

        vatDAO.create(new Vat(0));
        vatDAO.create(new Vat(0.022));
        vatDAO.create(new Vat(0.055));
        vatDAO.create(new Vat(0.1));
        vatDAO.create(new Vat(0.2));



    }

}
