package es.urjc.api_service.Repository;

import es.urjc.api_service.Model.Disk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiskRepository extends JpaRepository<Disk, Long> {
    Optional<Disk> findFirstByStatus(Disk.DiskStatus status);
}