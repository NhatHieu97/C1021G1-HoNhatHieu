package vn.codegym.model;

import vn.codegym.model.BorrowedBook;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameCustomer;
    @OneToMany(mappedBy = "customer")
    private List<BorrowedBook> borrowedBook;

    public Customer() {
    }

    public Customer(Long id, String nameCustomer, List<BorrowedBook> borrowedBook) {
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.borrowedBook = borrowedBook;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public List<BorrowedBook> getBorrowedBook() {
        return borrowedBook;
    }

    public void setBorrowedBook(List<BorrowedBook> borrowedBook) {
        this.borrowedBook = borrowedBook;
    }
}
