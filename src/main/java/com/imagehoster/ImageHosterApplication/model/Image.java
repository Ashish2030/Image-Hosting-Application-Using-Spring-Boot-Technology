package com.imagehoster.ImageHosterApplication.model;
import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "image")
public class Image {
    public Image()
    {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    //The image in Base64 format
    @Column(name = "imagefile",columnDefinition = "TEXT")
    private String imageFile;
    @Column(name = "description")
    private String description;
    @Column(name = "tags")
    private String tags;

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    //Date on which the image is posted
    @Column(name = "date")
    private Date date;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;
    public User getUser()
    {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    //Write the constructor for id, title, imageFile, and date
    public Image(Integer id, String title, String imageFile, Date date) {
        this.id = id;
        this.title = title;
        this.imageFile = imageFile;
        this.date = date;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getImageFile() {
        return imageFile;
    }
    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
