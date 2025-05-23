package es.urjc.api_service.Dto;

import es.urjc.api_service.Model.Disk;

public class DiskRequestDTO {
    private Long diskId;
    private int diskSize;
    private Disk.DiskType diskType;

    public DiskRequestDTO() {}
    public DiskRequestDTO(Long diskId, int diskSize, Disk.DiskType diskType) {
        this.diskId = diskId;
        this.diskSize = diskSize;
        this.diskType = diskType;
    }

    public Long getDiskId() {
        return diskId;
    }
    public void setDiskId(Long diskId) {
        this.diskId = diskId;
    }
    public int getDiskSize() {
        return diskSize;
    }
    public void setDiskSize(int diskSize) {
        this.diskSize = diskSize;
    }
    public void setDiskType(Disk.DiskType diskType) {
        this.diskType = diskType;
    }
    public Disk.DiskType getDiskType() {
        return diskType;
    }

}
