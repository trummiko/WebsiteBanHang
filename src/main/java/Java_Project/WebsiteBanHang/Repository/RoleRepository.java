package Java_Project.WebsiteBanHang.Repository;




import Java_Project.WebsiteBanHang.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findRoleById(Long id);
}