package ninja.zhancheng.tacospring.Data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ninja.zhancheng.tacospring.Domain.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

//	Iterable<Ingredient> findAll();
//	Ingredient findOne(String id);
//	Ingredient save(Ingredient ingredient);

}
