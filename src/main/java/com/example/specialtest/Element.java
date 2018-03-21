package com.example.specialtest;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Element {

    @Id
    private UUID id;

    private String elementName;

    @ManyToOne(fetch = FetchType.EAGER, cascade= { CascadeType.MERGE })
    @JoinColumn(name="diagram_id", nullable = true)
    private Diagram diagram;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public Diagram getDiagram() {
        return diagram;
    }

    public void setDiagram(Diagram diagram) {
        this.diagram = diagram;
    }
}
