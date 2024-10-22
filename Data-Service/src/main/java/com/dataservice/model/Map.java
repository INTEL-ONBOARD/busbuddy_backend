package com.dataservice.model;

import jakarta.persistence.*;

@Entity
public class Map {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SchemaMap getSchemaMap() {
        return schemaMap;
    }

    public void setSchemaMap(SchemaMap schemaMap) {
        this.schemaMap = schemaMap;
    }

    public String getMilestone() {
        return milestone;
    }

    public void setMilestone(String milestone) {
        this.milestone = milestone;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @ManyToOne
    @JoinColumn(name = "schema_id", referencedColumnName = "id")
    private SchemaMap schemaMap;

    private String milestone;
    private String info;

    // Getters and Setters
}
