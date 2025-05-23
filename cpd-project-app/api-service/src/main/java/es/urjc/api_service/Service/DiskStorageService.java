package es.urjc.api_service.Service;

import es.urjc.api_service.Dto.DataDTO;
import es.urjc.api_service.Model.Disk;
import es.urjc.api_service.Repository.DiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DiskStorageService {
    @Autowired
    private DiskRepository diskRepository;

    public Page<Disk> findAll(Pageable pageable) {
        return diskRepository.findAll(pageable);
    }

    public Optional<Disk> findById(Long id) {
        return diskRepository.findById(id);
    }

    public Disk save(Disk disk) {
        return diskRepository.save(disk);
    }

    public void deleteById(Long id) {
        diskRepository.deleteById(id);
    }

    public Optional<Disk> findFirstByStatus(Disk.DiskStatus status) {
        return diskRepository.findFirstByStatus(status);
    }

    public Disk buildDiskfromDTO(DataDTO dto) {
        Disk disk = new Disk();
        disk.setSize(dto.getDisk_size());
        disk.setType(dto.getDisk_type());
        disk.setStatus(Disk.DiskStatus.UNKNOWN);
        return disk;
    }
}
