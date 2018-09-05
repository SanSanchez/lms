package com.gcit.borrowermicroservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "tbl_book_loans")
public class BookLoans {

    @EmbeddedId
    private BookLoansId lId;

    @Column
    private String dateOut;

    @Column
    private String dueDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branchId", nullable = false, insertable = false, updatable = false)
    private LibraryBranch branch;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookId", nullable = false, insertable = false, updatable = false)
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cardNo", nullable = false, insertable = false, updatable = false)
    private Borrower borrower;

    public BookLoans() {}

    public BookLoansId getLoanId() {
        return this.lId;
    }

    public void setLoanId(BookLoansId LoanId) {
        this.lId = LoanId;
    }

    public LibraryBranch getBranch() {
        return this.branch;
    }

    public void setBranch(LibraryBranch branch) {
        this.branch = branch;
    }

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getDateOut() {
        return this.dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @JsonIgnore
    public Borrower getBorrower() {
        return this.borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }
}