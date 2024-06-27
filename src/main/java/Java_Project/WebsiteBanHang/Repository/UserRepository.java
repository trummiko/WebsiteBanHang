package Java_Project.WebsiteBanHang.Repository;


import Java_Project.WebsiteBanHang.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
