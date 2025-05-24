package es.urjc.api_service.Service;

import es.urjc.api_service.Dto.DataDTO;
import es.urjc.api_service.Model.Disk;
import es.urjc.api_service.Model.Instance;
import es.urjc.api_service.Repository.DiskRepository;
import es.urjc.api_service.Repository.InstanceRepositoy;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstanceStorageService {
    @Autowired
    private InstanceRepositoy instanceRepositoy;

    @Autowired
    private DiskRepository diskRepository;

    public Page<Instance> findAll(Pageable pageable) {
        return instanceRepositoy.findAll(pageable);
    }

    public Optional<Instance> findById(Long id) {
        return instanceRepositoy.findById(id);
    }

    public Instance save(Instance instance) {
        return instanceRepositoy.save(instance);
    }

    public void deleteById(Long id) {
        instanceRepositoy.deleteById(id);
    }

    public Instance buildInstancefromDTO(DataDTO dto) {
        Instance instance = new Instance();
        instance.setCores(dto.getCores());
        instance.setName(dto.getName());
        instance.setStatus(Instance.InstanceStatus.BUILDING_DISK);
        instance.setMemory(dto.getMem_size());
        return instance;
    }

    @PostConstruct
    public void init() {
        Disk disk1 = new Disk(100, Disk.DiskType.SSD, Disk.DiskStatus.ASSIGNED);
        Disk disk2 = new Disk(250, Disk.DiskType.HDD, Disk.DiskStatus.ASSIGNED);
        Disk disk3 = new Disk(500, Disk.DiskType.SSD, Disk.DiskStatus.ASSIGNED);

        disk1 = diskRepository.save(disk1);
        disk2 = diskRepository.save(disk2);
        disk3 = diskRepository.save(disk3);

        Instance instance1 = new Instance("IronFortress", 4, 2, "192.168.1.2", Instance.InstanceStatus.ASSIGNING_IP,
                disk1);
        Instance instance2 = new Instance("NimbusNode", 8, 4, "192.168.1.3", Instance.InstanceStatus.ASSIGNING_IP,
                disk2);
        Instance instance3 = new Instance("DataKraken", 16, 8, "192.168.1.4", Instance.InstanceStatus.ASSIGNING_IP,
                disk3);

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
