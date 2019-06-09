package ninja.zhancheng.tacospring.Data;

import ninja.zhancheng.tacospring.Domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Order,Long> {
}
