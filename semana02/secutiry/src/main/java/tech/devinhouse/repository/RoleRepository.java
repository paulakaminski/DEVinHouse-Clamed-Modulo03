package tech.devinhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.model.RoleModel;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long> {
}
