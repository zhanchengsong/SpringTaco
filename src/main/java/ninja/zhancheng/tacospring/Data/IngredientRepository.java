package ninja.zhancheng.tacospring.Data;

import org.springframework.stereotype.Repository;

import ninja.zhancheng.tacospring.Domain.Ingredient;

public interface IngredientRepository {

	Iterable<Ingredient> findAll();
	Ingredient findOne(String id);
	Ingredient save(Ingredient ingredient);

}
