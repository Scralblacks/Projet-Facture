package object;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class BillProduct implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_bill-product")
    private int idBillProduct;

    @Basic
    @Column(name = "Id_Bill")
    private Long idBill;

    @Basic
    @Column(name = "Id_Product")
    private Long idProduct;

    @Column(columnDefinition = "bigint default '0'")
    private int quantityProduct;

    public BillProduct(){

    }

    public BillProduct(Long idBill, Long idProduct, int quantityProduct) {
        this.idBill = idBill;
        this.idProduct = idProduct;
        this.quantityProduct = quantityProduct;
    }

    public int getIdBillProduct() {
        return idBillProduct;
    }

    public void setIdBillProduct(int idBillProduct) {
        this.idBillProduct = idBillProduct;
    }

    public Long getIdBill() {
        return idBill;
    }

    public void setIdBill(Long idBill) {
        this.idBill = idBill;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(int quantityProduct) {
        this.quantityProduct = quantityProduct;
    }
}
