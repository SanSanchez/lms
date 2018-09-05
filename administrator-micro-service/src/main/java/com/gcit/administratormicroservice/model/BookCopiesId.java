package com.gcit.administratormicroservice.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BookCopiesId implements Serializable {
	@Column
    private Long bookId;
 
    @Column
    private Long branchId;
 
    public BookCopiesId() {}
 
    public BookCopiesId(Long bookId, Long branchId) {
        this.bookId = bookId;
        this.branchId = branchId;
    }
 
    public Long getBookId() {
        return bookId;
    }
 
    public Long getBranchId() {
        return branchId;
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookCopiesId)) return false;
        BookCopiesId that = (BookCopiesId) o;
        return Objects.equals(getBookId(), that.getBookId()) &&
                Objects.equals(getBranchId(), that.getBranchId());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getBranchId());
    }
}
