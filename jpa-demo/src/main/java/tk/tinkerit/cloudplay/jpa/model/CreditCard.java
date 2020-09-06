package tk.tinkerit.cloudplay.jpa.model;

import javax.persistence.*;

@Entity
public class CreditCard extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String number;

    @Enumerated(EnumType.STRING)
    private CreditCardType creditCardType;

    public CreditCard() {
    }

    public CreditCard(String number, CreditCardType creditCardType) {
        this.number = number;
        this.creditCardType = creditCardType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public CreditCardType getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(CreditCardType creditCardType) {
        this.creditCardType = creditCardType;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
            "id=" + id +
            ", number='" + number + '\'' +
            ", creditCardType=" + creditCardType +
            '}';
    }
}
