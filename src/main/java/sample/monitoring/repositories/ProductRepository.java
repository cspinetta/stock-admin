package sample.monitoring.repositories;

import java.util.Collection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sample.monitoring.model.Product;

// https://spring.io/guides/gs/accessing-data-rest/
@RepositoryRestResource
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

  Collection<Product> findByCategoryTitle(@Param("title") String title);

}
