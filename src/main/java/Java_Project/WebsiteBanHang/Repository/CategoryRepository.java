package Java_Project.WebsiteBanHang.Repository;

import Java_Project.WebsiteBanHang.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
