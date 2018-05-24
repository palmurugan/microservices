package com.genesis.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.genesis.common.service.FieldValueExist;
import com.genesis.common.validator.UniqueValidator;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueValidator.class)
@Documented
public @interface Unique {

	String message() default "{unique.value.violation}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	Class<? extends FieldValueExist> service();

	String serviceQualifier() default "";

	String fieldName();
}
