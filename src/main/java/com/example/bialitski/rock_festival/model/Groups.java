package com.example.bialitski.rock_festival.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Groups")
@NoArgsConstructor
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false)
    private Long id;

    @Column(nullable=false)
    private String groupName;

    @Column(nullable=false)
    private String groupDescription;

    @Column(nullable=false)
    private String GroupStyle;

    public Groups(Long id, String groupName, String groupDescription, String groupStyle) {
        this.id = id;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        GroupStyle = groupStyle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public String getGroupStyle() {
        return GroupStyle;
    }

    public void setGroupStyle(String groupStyle) {
        GroupStyle = groupStyle;
    }
}
