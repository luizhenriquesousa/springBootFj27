package br.com.alura.forum.controller.dto.input;

import java.util.ArrayList;

import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.*;
import br.com.alura.forum.model.topic.domain.Topic;
import br.com.alura.forum.model.topic.domain.TopicStatus;

public class TopicSearchInputDto {

	private TopicStatus status;
	private String categoryName;

	public TopicStatus getStatus() {
		return status;
	}

	public void setStatus(TopicStatus status) {
		this.status = status;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * Construindo uma especificação. Boirlaplates são referêncais a Jpa que são
	 * root, criteria builder e criteria query, dentro da collection é um select dos
	 * status e um select da categoria, que onde pego várias colunas.Predicates: Os
	 * Predicates eles verificam o que tem nas tabelas.
	 */
	public Specification<Topic> build() {

		/**
		 * @return(boirlaplate): isso é collections que surgiram a partir da versão 8 do
		 * java.
		 */
		return (root, criteriaQuery, criteriaBuilder) -> {
			ArrayList<Predicate> predicates = new ArrayList<>();

			if (status != null) {
				predicates.add(criteriaBuilder.equal(root.get("status"), status));
			}

			if (categoryName != null) {
				Path<String> categoryNamePath = root.get("corse").get("subcategory").get("category").get("name");
				predicates.add(criteriaBuilder.equal(categoryNamePath, categoryName));
			}

			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

		};

	}
}
