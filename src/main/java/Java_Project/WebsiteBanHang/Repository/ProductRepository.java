package Java_Project.WebsiteBanHang.Repository;

import Java_Project.WebsiteBanHang.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
