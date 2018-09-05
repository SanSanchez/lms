package com.gcit.borrowermicroservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "tbl_borrower")
public class Borrower {

    public Borrower() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardNo;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "borrower",
            cascade = CascadeType.ALL)
    private List<BookLoans> loans;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String phone;

    public Long getCardNo() {
        return cardNo;
    }

    public void setCardNo(Long cardNo) {
        this.cardNo = cardNo;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<BookLoans> getLoans() {
        return loans;
    }

}
