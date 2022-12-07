package object;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Vat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    @OneToMany(mappedBy = "vat")
    private List<Product> productList;

    public void setProductsList(List<Product> productList) {
        this.productList = productList;
    }

    public Vat(){

    }

    public Vat(double amount, List<Product> productList) {
        this.amount = amount;
        this.productList = productList;
    }

    public Vat(double amount) {
        this.amount = amount;
    }

    public List<Product> getProductsList() {
        return productList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
