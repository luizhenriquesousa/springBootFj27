package br.com.alura.forum.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.alura.forum.model.topic.domain.Topic;

public class TopicDao {

	@PersistenceContext
	private EntityManager em;

	public void adiciona(Topic topic) {
		em.persist(topic);
	}

	/**
	 * 
	 * @param id: find ele só funciona como um select se eu tiver um id que eu sei
	 *            que é aquele id e tenho ceteza que é um id.
	 * @return
	 */
	public Topic findById(Long id) {
		return em.find(Topic.class, id);
	}

	/**
	 * Select em JPQL, essa list é que eu vou pegar todas as informações da minha
	 * tabela Topic, que na JPQL estou fazendo um select * from Topic;
	 * 
	 * @return
	 */
	public List<Topic> findAll() {
		return em.createQuery("select t from Topic t", Topic.class).getResultList();
	}

	/**
	 * Removendo dados de uma tabela
	 * 
	 * @param topic
	 */
	public void delete(Topic topic) {
		em.remove(topic);
	}
}
