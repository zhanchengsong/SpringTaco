package ninja.zhancheng.tacospring.Data;

import ninja.zhancheng.tacospring.Domain.Taco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TacoRepository extends PagingAndSortingRepository<Taco, Long> {

}
