package com.gcit.borrowermicroservice.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BookLoansId implements Serializable {

    @Column
    private Long bookId;

    @Column
    private Long branchId;

    @Column
    private Long cardNo;

    public BookLoansId() {}

    public BookLoansId(Long bookId, Long branchId, Long cardNo) {
        this.bookId = bookId;
        this.branchId = branchId;
        this.cardNo = cardNo;
    }

    public Long getBookId() {
        return bookId;
    }

    public Long getBranchId() {
        return branchId;
    }

    public Long getCardNo() {
        return cardNo;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public void setCardNo(Long cardNo) {
        this.cardNo = cardNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookLoansId)) return false;
        BookLoansId that = (BookLoansId) o;
        return Objects.equals(getBookId(), that.getBookId()) &&
                Objects.equals(getBranchId(), that.getBranchId()) &&
                Objects.equals(getCardNo(), that.getCardNo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getBranchId(), getCardNo());
    }
}
