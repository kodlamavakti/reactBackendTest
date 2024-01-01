package reactBackend.demo.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactBackend.demo.business.abstracts.IProductService;
import reactBackend.demo.entities.Product;
import reactBackend.demo.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateById(Long id, Product product) {

        Product managedProduct = this.findById(id);
        managedProduct.setTitle(product.getTitle());
        managedProduct.setQuantity(product.getQuantity());
        managedProduct.setPrice(product.getPrice());

        return this.save(managedProduct);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
