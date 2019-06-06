package ninja.zhancheng.tacospring.Data;

import ninja.zhancheng.tacospring.Domain.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {


}
