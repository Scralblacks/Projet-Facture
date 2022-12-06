package object;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
public class Client {
    @Id
    private String id;

    private String name;

    private String address;

    private String zip_code;

    private String town;

    private String phone_number;

    private String email;

    @OneToMany
    private Collection<Bill> billList;

    public Client(){

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
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

    public Collection<Bill> getBillList() {
        return billList;
    }

    public void setBillList(Collection<Bill> billList) {
        this.billList = billList;
    }
}
