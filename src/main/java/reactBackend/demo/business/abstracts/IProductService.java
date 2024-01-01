package reactBackend.demo.business.abstracts;


import reactBackend.demo.entities.Product;

import java.util.List;

public interface IProductService {
    Product save(Product product);

    Product updateById(Long id, Product product);

    List<Product> findAll();

    Product findById(Long id);

    void deleteById(Long id);
}

