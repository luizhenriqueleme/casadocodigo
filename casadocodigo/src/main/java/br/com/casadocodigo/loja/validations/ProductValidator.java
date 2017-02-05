package br.com.casadocodigo.loja.validations;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casadocodigo.loja.models.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.
			rejectIfEmptyOrWhitespace(errors, "title",
					"required.field");
		ValidationUtils.
			rejectIfEmptyOrWhitespace(errors, "description",
					"required.field");
		Product product = (Product) target;
		if(product.getNumberOfPages() == 0) {
			errors.rejectValue("numberOfPages", "required.field");
		}
	}

}
