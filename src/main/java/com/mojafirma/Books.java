package com.mojafirma;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;


@Entity
@Table(name = "books", schema = "ksiegarnia")
public class Books {

    @Column(name="title", nullable = true)
    private String title;
    @Column(name = "author", nullable = true)
    private String author;
    @Column(name = "published", nullable = true)
    private Date published;
    @Column(name = "isbn", nullable = true)
    private String isbn;
    @Column(name = "category", nullable = true)
    private String categoty;
    @Column(name = "pageCount", nullable = true)
    private Integer pageCount;
    @Column(name = "publisher", nullable = true)
    private String publisher;
    @Column(name = "price", nullable = true)
    private BigDecimal price;
    @Column(name = "onStock", nullable = true)
    private Integer onStock;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategoty() {
        return categoty;
    }

    public void setCategoty(String categoty) {
        this.categoty = categoty;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getOnStock() {
        return onStock;
    }

    public void setOnStock(Integer onStock) {
        this.onStock = onStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Books{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", published=" + published +
                ", isbn='" + isbn + '\'' +
                ", categoty='" + categoty + '\'' +
                ", pageCount=" + pageCount +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                ", onStock=" + onStock +
                ", id=" + id +
                '}';
    }
}
