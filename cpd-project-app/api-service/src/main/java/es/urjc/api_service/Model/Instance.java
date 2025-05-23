package es.urjc.api_service.Model;

import jakarta.persistence.*;

@Entity
public class Instance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private int memory;
    private int cores;
    private String ipAddress;

    @Enumerated(EnumType.STRING)
    private InstanceStatus status;

    @OneToOne(mappedBy = "instance")
    private Disk disk;

    public enum InstanceStatus {
        BUILDING_DISK, STARTING, INITIALIZING, ASSIGNING_IP, RUNNING
    }

    // Constructors
    public Instance() {}

    public Instance(String name, int memory, int cores, String ipAddress, InstanceStatus status, Disk disk) {
        this.name = name;
        this.memory = memory;
        this.cores = cores;
        this.ipAddress = ipAddress;
        this.status = status;
        this.disk = disk;
    }

    // Getters and Setters

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

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public InstanceStatus getStatus() {
        return status;
    }

    public void setStatus(InstanceStatus status) {
        this.status = status;
    }

    public Disk getDisk() {
        return disk;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
    }

    // toString
    @Override
    public String toString() {
        return "Instance{" + "id=" + id + ", name='" + name + '\'' + ", memory=" + memory + ", cores=" + cores +
                ", ipAddress='" + ipAddress + '\'' +
                ", status=" + status +
                ", disk=" + (disk != null ? disk.getId() : null) +
                '}';
    }
}
