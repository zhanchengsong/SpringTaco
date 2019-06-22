package ninja.zhancheng.tacospring.Data;

import ninja.zhancheng.tacospring.Domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Long> {
    public User findUserById(Long id);
    public User findByUsername (String username);
}
