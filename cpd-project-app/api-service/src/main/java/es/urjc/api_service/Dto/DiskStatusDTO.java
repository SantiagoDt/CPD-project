package es.urjc.api_service.Dto;

import es.urjc.api_service.Model.Disk.*;

public class DiskStatusDTO {

    private Long diskId;
    private DiskStatus status;
    private int diskSize;
    private DiskType diskType;

    public DiskStatusDTO() {}

    public DiskStatusDTO(Long diskId, DiskStatus status, int diskSize, DiskType diskType) {
        this.diskId = diskId;
        this.status = status;
        this.diskSize = diskSize;
        this.diskType = diskType;
    }

    public Long getDiskId() {
        return diskId;
    }
    public void setDiskId(Long diskId) {
        this.diskId = diskId;
    }
    public DiskStatus getStatus() {
        return status;
    }
    public void setStatus(DiskStatus status) {
        this.status = status;
    }
    public int getDiskSize() {
        return diskSize;
    }
    public void setDiskSize(int diskSize) {
        this.diskSize = diskSize;
    }
    public DiskType getDiskType() {
        return diskType;
    }
    public void setDiskType(DiskType diskType) {
        this.diskType = diskType;
    }

}
