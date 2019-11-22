package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import br.com.alura.forum.model.topic.domain.Topic;

/**
 * 
 * @author lhsousa Interface com cruds para o meu dao, Repository é onde ficam
 *         só interfaces. O spring suporta a anotação @Query e injetar uma query
 *         dentro em JPQL.
 */
public interface TopicRepository extends Repository<Topic, Long>, JpaSpecificationExecutor<Topic> {
	void save(Topic topic);

	@Query("select t from Topic t")
	List<Topic> list();

	List<Topic> findAll();
}
