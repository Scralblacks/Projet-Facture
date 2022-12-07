package object;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ref_num;

    private String name;

    private String address;

    private String zip_code;

    private String town;

    private String phone_number;

    private String email;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.DETACH}, mappedBy = "client")
    private List<Bill> billList;

    public Client(){

    }

    public Client(String name, String address, String zip_code, String town, String phone_number, String email, List<Bill> billList) {
        this.ref_num = "C" + this.getId();
        this.name = name;
        this.address = address;
        this.zip_code = zip_code;
        this.town = town;
        this.phone_number = phone_number;
        this.email = email;
        this.billList = billList;
    }
    public Client(String name, String address, String zip_code, String town, String phone_number, String email) {
        this.ref_num = "C" + this.getId();
        this.name = name;
        this.address = address;
        this.zip_code = zip_code;
        this.town = town;
        this.phone_number = phone_number;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }

    public String getRef_num() {return ref_num;}

    public void setRef_num(String ref_num) {this.ref_num = ref_num;}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
