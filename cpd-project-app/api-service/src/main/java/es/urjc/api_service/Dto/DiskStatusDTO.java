package es.urjc.api_service.Dto;

public class DiskStatusDTO {

    private Long diskId;
    private String status;
    private int diskSize;
    private String diskType;

    public DiskStatusDTO() {}

    public DiskStatusDTO(Long diskId, String status, int diskSize, String diskType) {
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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getDiskSize() {
        return diskSize;
    }
    public void setDiskSize(int diskSize) {
        this.diskSize = diskSize;
    }
    public String getDiskType() {
        return diskType;
    }
    public void setDiskType(String diskType) {
        this.diskType = diskType;
    }

}
