package sample.monitoring.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sample.monitoring.model.Category;

@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long> {

  Optional<Category> findById(Long id);

}
