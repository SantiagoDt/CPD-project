package es.urjc.disk_service.DTO;

public class DiskRequestDTO  {
    private Long diskId;
    private int diskSize;

    private DiskType diskType;

    public enum DiskType {HDD, SSD};

    public DiskRequestDTO() {}

    public DiskRequestDTO(long diskId, int diskSize, DiskType diskType) {
        this.diskId = diskId;
        this.diskSize = diskSize;
        this.diskType = diskType;
    }

    public DiskType getDiskType() {
        return diskType;
    }

    public void setDiskType(DiskType diskType) {
        this.diskType = diskType;
    }

    public Long getDiskId() {
        return diskId;
    }

    public void setDiskId(long diskId) {
        this.diskId = diskId;
    }

    public int getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(int diskSize) {
        this.diskSize = diskSize;
    }

    @Override
    public String toString() {
        return "DiskRequestDTO{" +
                "diskId=" + diskId +
                ", size=" + diskSize +
                ", type='" + diskType + '\'' +
                '}';
    }
}
