package es.urjc.api_service.Dto;

import es.urjc.api_service.Model.Disk.DiskStatus;

public class InstanceStatusDTO {

    private long instanceId;
    private DiskStatus status;
    private String ip;

    public InstanceStatusDTO() {}
    public InstanceStatusDTO(long instanceId,DiskStatus  status, String ip) {
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
    public DiskStatus  getStatus() {
        return status;
    }
    public void setStatus(DiskStatus  status) {
        this.status = status;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
}

