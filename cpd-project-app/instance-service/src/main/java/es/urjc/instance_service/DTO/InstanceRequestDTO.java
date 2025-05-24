package es.urjc.instance_service.DTO;

public class InstanceRequestDTO {

    private Long instanceId;
    private String instanceName;
    private int cores;
    private int memory;
    private Long diskId;

    public InstanceRequestDTO() {}
    public InstanceRequestDTO(Long instanceId, String instanceName, int cores, int memory, Long diskId){
        this.instanceId = instanceId;
        this.instanceName = instanceName;
        this.cores = cores;
        this.memory = memory;
        this.diskId = diskId;
    }

    public Long getInstanceId() {
        return instanceId;
    }
    public void setInstanceId(Long instanceId) {
        this.instanceId = instanceId;
    }
    public String getInstanceName() {
        return instanceName;
    }
    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }
    public int getCores() {
        return cores;
    }
    public void setCores(int cores) {
        this.cores = cores;
    }
    public int getMemory() {
        return memory;
    }
    public void setMemory(int memory) {
        this.memory = memory;
    }
    public Long getDiskId() { return diskId; }
    public void setDiskId(Long diskId) { this.diskId = diskId; }

    @Override
    public String toString() {
        return "InstanceRequestDTO{" +
                "instanceId=" + instanceId +
                ", name='" + instanceName + '\'' +
                ", memory=" + memory +
                ", cores=" + cores +
                ", diskId=" + diskId +
                '}';
    }
}

