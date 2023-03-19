package tech.devinhouse.pets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.pets.model.PetModel;

@Repository
public interface PetRepository extends JpaRepository<PetModel, Long> {
}
