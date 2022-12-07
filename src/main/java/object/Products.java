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

    private String name;

    private double price_wto_taxes;

    @ManyToOne
    private Vat vat;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.DETACH}, mappedBy = "productByBillList")
    private List<Bill> billByProductList;

    public Products(){

    }

    public Products(String name, double price_wto_taxes, Vat vat, List<Bill> billByProductList){
        this.ref_nbr = "P" + this.getId();
        this.name = name;
        this.price_wto_taxes = price_wto_taxes;
        this.vat = vat;
        this.billByProductList = billByProductList;
    }

    public Products(String name, double price_wto_taxes, Vat vat){
        this.ref_nbr = "P" + this.getId();
        this.name = name;
        this.price_wto_taxes = price_wto_taxes;
        this.vat = vat;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
