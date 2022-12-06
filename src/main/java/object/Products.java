package object;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ref_nbr;

    private String description;

    private double price_wto_taxes;

    @ManyToOne
    private Vat vat;

    @ManyToMany(mappedBy = "productByBillList")
//    @JoinTable(name = "bill-product", joinColumns = @JoinColumn(name = "id_Product", referencedColumnName="ID"),
//            inverseJoinColumns = @JoinColumn(name = "id_Bill", referencedColumnName="ID"))
    private List<Bill> billByProductList;

    public Products(){

    }

    public Products(String description, double price_wto_taxes, Vat vat, List<Bill> billByProductList){
        this.ref_nbr = "P" + this.id;
        this.description = description;
        this.price_wto_taxes = price_wto_taxes;
        this.vat = vat;
        this.billByProductList = billByProductList;
    }

    public Products(String description, double price_wto_taxes, Vat vat){
        this.ref_nbr = "P" + this.id;
        this.description = description;
        this.price_wto_taxes = price_wto_taxes;
        this.vat = vat;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice_wto_taxes() {
        return price_wto_taxes;
    }

    public void setPrice_wto_taxes(double price_wto_taxes) {
        this.price_wto_taxes = price_wto_taxes;
    }

    public Vat getVat() {
        return vat;
    }

    public void setVat(Vat vat) {
        this.vat = vat;
    }

    public List<Bill> getBillByProductList() {
        return billByProductList;
    }

    public void setBillByProductList(List<Bill> billByProductList) {
        this.billByProductList = billByProductList;
    }
}
