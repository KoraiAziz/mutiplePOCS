package com.anb.pocs.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "accounts")
public class AccountEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "account_number")
    private Long accountNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Account{" +
                "AccountNumber=" + accountNumber +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}


