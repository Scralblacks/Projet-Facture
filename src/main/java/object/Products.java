package object;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
public class Products {
    @Id
    private String id;

    private String description;

    private double price_wto_taxes;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Vat vat;

    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "productByBillList")
//    @JoinTable(name = "bill-product", joinColumns = @JoinColumn(name = "id_Product", referencedColumnName="ID"),
//            inverseJoinColumns = @JoinColumn(name = "id_Bill", referencedColumnName="ID"))
    private List<Bill> billByProductList;

    public Products(){

    }

    public Products(String description, Float price_wto_taxes, List<Bill> billByProductList){
        this.description = description;
        this.price_wto_taxes = price_wto_taxes;
        this.billByProductList = billByProductList;
    }

    public Products(String description, Float price_wto_taxes){
        this.description = description;
        this.price_wto_taxes = price_wto_taxes;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
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
