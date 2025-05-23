package es.urjc.api_service.Dto;

public class InstanceStatusDTO {

    private long instanceId;
    private String status;
    private String ip;

    public InstanceStatusDTO() {}
    public InstanceStatusDTO(long instanceId, String status, String ip) {
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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
}

