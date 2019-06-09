package ninja.zhancheng.tacospring.Data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ninja.zhancheng.tacospring.Domain.Ingredient;

public interface IngredientRepository extends PagingAndSortingRepository<Ingredient, String> {

//	Iterable<Ingredient> findAll();
//	Ingredient findOne(String id);
//	Ingredient save(Ingredient ingredient);

}
