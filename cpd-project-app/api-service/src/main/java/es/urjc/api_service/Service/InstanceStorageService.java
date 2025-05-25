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

}
