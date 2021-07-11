package com.urlshortner.springbootapp.model;


import javax.persistence.*;

@Entity
@Table(name = "short_urls")
public class ShortnerEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String shortid;


    @Column
    private String longid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortid() {
        return shortid;
    }

    public void setShortid(String shortid) {
        this.shortid = shortid;
    }

    public String getLongid() {
        return longid;
    }

    public void setLongid(String longid) {
        this.longid = longid;
    }

    public ShortnerEntity(String longid) {
        this.longid = longid;
    }

    public ShortnerEntity() {

    }
}
