package object;

import jakarta.persistence.*;

@Entity
@Table(name = "bill-product", schema = "exercicejavase01", catalog = "")
public class BillProduct {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_bill-product")
    private int idBillProduct;
    @Basic
    @Column(name = "Id_Bill")
    private String idBill;
    @Basic
    @Column(name = "Id_Product")
    private String idProduct;

    private int quantityProduct;
    public int getIdBillProduct() {
        return idBillProduct;
    }

    public void setIdBillProduct(int idBillProduct) {
        this.idBillProduct = idBillProduct;
    }

    public String getIdBill() {
        return idBill;
    }

    public void setIdBill(String idBill) {
        this.idBill = idBill;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(int quantityProduct) {
        this.quantityProduct = quantityProduct;
    }
}
