package com.gcit.borrowermicroservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "tbl_book_copies")
public class BookCopies {
	
	@EmbeddedId
	private BookCopiesId cId;
	
	@Column(name = "noOfCopies")
	private Integer noOfCopies;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branchId", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private LibraryBranch branch;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookId", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
	private Book book;

	public BookCopiesId getBkcpyId() {
		return this.cId;
	}

	public void setBkcpyId(BookCopiesId bkcpyId) {
		this.cId = bkcpyId;
	}

	public Integer getNoOfCopies() {
		return this.noOfCopies;
	}

	public void setNoOfCopies(Integer noOfCopies) {
		this.noOfCopies = noOfCopies;
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
}
