package com.driver.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String Content;
    @CreationTimestamp
    private Date pubDate;
    @ManyToOne
    @JoinColumn
    User user;
    @OneToMany(mappedBy ="blog",cascade =CascadeType.ALL)

private List<Image>imageList;

    public Blog() {
    }

    public Blog(User user,String title, String content) {
        this.user = user;
        this.title = title;
        this.Content = content;

    }

    public Blog(int id, String title, String content, Date date, User user, List<Image> imageList) {
        this.id = id;
        this.title = title;
        this.Content = content;
        this.pubDate = date;
        this.user = user;
        this.imageList = imageList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        this.Content = content;
    }


    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }
}