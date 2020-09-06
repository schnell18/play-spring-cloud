package tk.tinkerit.cloudplay.jpa.model;

import javax.persistence.*;

@Entity
public class Address extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String street1;

    private String street2;

    private String state;

    private String city;

    private String country;

    private String zipCode;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    public Address() {
    }

    public Address(String street1, String street2, String state, String city, String country, String zipCode, AddressType addressType) {
        this.street1 = street1;
        this.street2 = street2;
        this.state = state;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
        this.addressType = addressType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    @Override
    public String toString() {
        return "Address{" +
            "id=" + id +
            ", street1='" + street1 + '\'' +
            ", street2='" + street2 + '\'' +
            ", state='" + state + '\'' +
            ", city='" + city + '\'' +
            ", country='" + country + '\'' +
            ", zipCode='" + zipCode + '\'' +
            ", addressType=" + addressType +
            '}';
    }
}
