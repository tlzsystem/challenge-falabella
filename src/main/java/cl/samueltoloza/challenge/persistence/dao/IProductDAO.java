package cl.samueltoloza.challenge.persistence.dao;

import cl.samueltoloza.challenge.persistence.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductDAO extends PagingAndSortingRepository<Product, String> {


}
