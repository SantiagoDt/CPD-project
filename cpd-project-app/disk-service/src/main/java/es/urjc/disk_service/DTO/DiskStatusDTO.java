package es.urjc.disk_service.DTO;


public class DiskStatusDTO {
    private Long diskId;
    private int diskSize;
    private DiskRequestDTO.DiskType diskType;
    private DiskStatus status;

    public enum DiskStatus { REQUESTED, INITIALIZED, ASSIGNED, UNASSIGNED, UNKNOWN }

    public DiskStatusDTO() {}

    public DiskStatusDTO(Long diskID, DiskRequestDTO.DiskType diskType, DiskStatus status, int diskSize) {
        this.diskType = diskType;
        this.status = status;
        this.diskSize = diskSize;
        this.diskId = diskID;
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
    public DiskRequestDTO.DiskType getDiskType() {
        return diskType;
    }
    public void setDiskType(DiskRequestDTO.DiskType diskType) {
        this.diskType = diskType;
    }
    public DiskStatus getStatus() {
        return status;
    }
    public void setStatus(DiskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DiskStatusDTO{" +
                "diskId=" + diskId +
                ", size=" + diskSize +
                ", type='" + diskType + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
