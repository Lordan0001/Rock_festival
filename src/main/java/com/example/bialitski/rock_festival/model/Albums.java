package com.example.bialitski.rock_festival.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Albums")
@NoArgsConstructor
public class Albums {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(name = "albumName", nullable = false)
    private String albumName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Albums(Long id, String name, String albumName) {
        this.id = id;
        this.name = name;
        this.albumName = albumName;
    }
}
