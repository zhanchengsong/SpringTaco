package ninja.zhancheng.tacospring.Data;

import ninja.zhancheng.tacospring.Domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Long> {
}
