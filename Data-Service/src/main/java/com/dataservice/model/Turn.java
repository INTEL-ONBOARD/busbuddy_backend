package com.dataservice.model;

import jakarta.persistence.*;

@Entity
public class Turn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer turnNo;
    private String origin;
    private String departure;
    private String info;
    private String type; // New attribute `type`

    // Many-to-one relationship with SchemaMap (Foreign Key)
    @ManyToOne
    @JoinColumn(name = "schema_map_id", referencedColumnName = "id")
    private SchemaMap schemaMap; // Foreign key referencing SchemaMap `id`

    // You can optionally include the `name` field from SchemaMap as a reference (read-only)
    @Transient  // This is optional, as you already reference the full SchemaMap entity
    private String schemaMapName;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTurnNo() {
        return turnNo;
    }

    public void setTurnNo(Integer turnNo) {
        this.turnNo = turnNo;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SchemaMap getSchemaMap() {
        return schemaMap;
    }

    public void setSchemaMap(SchemaMap schemaMap) {
        this.schemaMap = schemaMap;
    }

    public String getSchemaMapName() {
        return schemaMap != null ? schemaMap.getName() : null;
    }
}
