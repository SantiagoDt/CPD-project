package es.urjc.instance_service.DTO;

public class InstanceStatusDTO {

    private Long instanceId;
    private InstanceStatus status;
    private String ip;

    public enum InstanceStatus
    {
        BUILDING_DISK, STARTING, INITIALIZING, ASSIGNING_IP, RUNNING
    }

    public InstanceStatusDTO() {}
    public InstanceStatusDTO(Long instanceId,InstanceStatus status, String ip) {
        this.instanceId = instanceId;
        this.status = status;
        this.ip = ip;
    }

    public long getInstanceId() {
        return instanceId;
    }
    public void setInstanceId(long instanceId) {
        this.instanceId = instanceId;
    }
    public InstanceStatus  getStatus() {
        return status;
    }
    public void setStatus(InstanceStatus  status) {
        this.status = status;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "InstanceStatusDTO{" +
                "instanceId=" + instanceId +
                ", status='" + status + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}

