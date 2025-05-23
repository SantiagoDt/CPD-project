package es.urjc.api_service.Dto;

public class InstanceRequestDTO {

    private Long instanceId;
    private String instanceName;
    private int cores;
    private int memory;


    public InstanceRequestDTO() {}
    public InstanceRequestDTO(Long instanceId, String instanceName, int cores, int memory){
        this.instanceId = instanceId;
        this.instanceName = instanceName;
        this.cores = cores;
        this.memory = memory;

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
}

