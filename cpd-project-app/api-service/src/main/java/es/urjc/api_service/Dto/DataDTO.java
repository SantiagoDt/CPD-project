package es.urjc.api_service.Dto;

import es.urjc.api_service.Model.Disk;

public class DataDTO {

    int cores;
    int disk_size;
    Disk.DiskType disk_type;
    String name;
    int mem_size;

    public DataDTO(int cores, int disk_size, Disk.DiskType disk_type, String name, int mem_size) {
        this.cores = cores;
        this.disk_size = disk_size;
        this.disk_type = disk_type;
        this.name = name;
        this.mem_size = mem_size;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public int getDisk_size() {
        return disk_size;
    }

    public void setDisk_size(int disk_size) {
        this.disk_size = disk_size;
    }

    public Disk.DiskType getDisk_type() {
        return disk_type;
    }

    public void setDisk_type(Disk.DiskType disk_type) {
        this.disk_type = disk_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMem_size() {
        return mem_size;
    }

    public void setMem_size(int mem_size) {
        this.mem_size = mem_size;
    }


}
