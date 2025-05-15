package es.urjc.api_service.Repository;

import es.urjc.api_service.Model.Instance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstanceRepositoy extends JpaRepository<Instance, Long> {
}
