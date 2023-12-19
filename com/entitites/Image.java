package ilanaraba.com.entitites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;

    public Ilan getIlan() {
        return ilan;
    }

    public void setIlan(Ilan ilan) {
        this.ilan = ilan;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="ilan_id")
    @JsonIgnore
    private Ilan ilan;

    public Image(String url,Ilan ilan) {
        this.url=url;
        this.ilan=ilan;
    }
    public Image() {

    }
    public Image(String url) {
        this.url = url;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

