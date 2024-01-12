package net.ausiasmarch.weekeat.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import net.ausiasmarch.weekeat.entity.TypeEntity;

public interface TypeRepository extends JpaRepository<TypeEntity, Long> {
    Optional<TypeEntity> findByName(String name);
}
