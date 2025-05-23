package es.urjc.api_service.Model;

import jakarta.persistence.*;

@Entity
public class Disk {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int size;

    @Enumerated(EnumType.STRING)
    private DiskType type;

    @Enumerated(EnumType.STRING)
    private DiskStatus status;

    @OneToOne
    private Instance instance;

    public enum DiskType { HDD, SSD }
    public enum DiskStatus { REQUESTED, INITIALIZED, ASSIGNED, UNASSIGNED, UNKNOWN }

    //Constructor
    public Disk() {}

    public Disk(int size, DiskType type, DiskStatus status) {
        this.size = size;
        this.type = type;
        this.status = status;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public DiskType getType() {
        return type;
    }

    public void setType(DiskType type) {
        this.type = type;
    }

    public DiskStatus getStatus() {
        return status;
    }

    public void setStatus(DiskStatus status) {
        this.status = status;
    }

    public Instance getInstance() {
        return instance;
    }

    public void setInstance(Instance instance) {
        this.instance = instance;
    }

    //toString
    @Override
    public String toString() {
        return "Disk{" +
                "id=" + id +
                ", size=" + size +
                ", type=" + type +
                ", status=" + status +
                ", instance=" + (instance != null ? instance.getId() : null) +
                "}";
    }

}
