package es.urjc.api_service.Service;

import es.urjc.api_service.Model.Disk;
import es.urjc.api_service.Model.Instance;
import es.urjc.api_service.Repository.DiskRepository;
import es.urjc.api_service.Repository.InstanceRepositoy;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("init")
public class InitDataLoader {

    @Autowired
    private InstanceRepositoy instanceRepositoy;

    @Autowired
    private DiskRepository diskRepository;

    @PostConstruct
    public void init() {
        Disk disk1 = new Disk(100, Disk.DiskType.SSD, Disk.DiskStatus.ASSIGNED);
        Disk disk2 = new Disk(250, Disk.DiskType.HDD, Disk.DiskStatus.ASSIGNED);
        Disk disk3 = new Disk(500, Disk.DiskType.SSD, Disk.DiskStatus.ASSIGNED);

        disk1 = diskRepository.save(disk1);
        disk2 = diskRepository.save(disk2);
        disk3 = diskRepository.save(disk3);

        Instance instance1 = new Instance("IronFortress", 4, 2, "192.168.1.2", Instance.InstanceStatus.RUNNING, disk1);
        Instance instance2 = new Instance("NimbusNode", 8, 4, "192.168.1.3", Instance.InstanceStatus.RUNNING, disk2);
        Instance instance3 = new Instance("DataKraken", 16, 8, "192.168.1.4", Instance.InstanceStatus.RUNNING, disk3);

        disk1.setInstance(instance1);
        disk2.setInstance(instance2);
        disk3.setInstance(instance3);

        instanceRepositoy.save(instance1);
        instanceRepositoy.save(instance2);
        instanceRepositoy.save(instance3);

        diskRepository.save(disk1);
        diskRepository.save(disk2);
        diskRepository.save(disk3);
    }
}