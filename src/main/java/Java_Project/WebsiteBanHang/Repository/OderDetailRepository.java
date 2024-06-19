package Java_Project.WebsiteBanHang.Repository;

import Java_Project.WebsiteBanHang.Model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OderDetailRepository extends JpaRepository<OrderDetail, Long> {
}