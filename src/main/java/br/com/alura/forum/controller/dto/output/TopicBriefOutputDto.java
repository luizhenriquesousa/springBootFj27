package br.com.alura.forum.controller.dto.output;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.data.domain.Page;

import br.com.alura.forum.model.topic.domain.Topic;
import br.com.alura.forum.model.topic.domain.TopicStatus;

/**
 * 
 * @author lhsousa: DTO(Data transact object): transação de objetos
 *
 */
public class TopicBriefOutputDto {

	private Long id;
	private String shortDescription;
	private long secoundsSinceLastUpdate;
	private String ownerName;
	private String courseName;
	private String subcategoryName;
	private String categoryName;
	private int numberOfResponses;
	private boolean solved;

	// Construtor
	public TopicBriefOutputDto(Topic topic) {
		this.id = topic.getId();
		this.shortDescription = topic.getShortDescription();
		this.secoundsSinceLastUpdate = getSecoundsSince(topic.getLastUpdate());
		this.ownerName = topic.getOwner().getName();
		this.courseName = topic.getCourse().getName();
		this.subcategoryName = topic.getCourse().getSubcategory().getName();
		this.categoryName = topic.getCourse().getCategoryName();
		this.numberOfResponses = topic.getNumberOfAnswers();
		this.solved = TopicStatus.SOLVED.equals(topic.getStatus());
	}

	// Java time
	private long getSecoundsSince(Instant lastUpdate) {
		return Duration.between(lastUpdate, Instant.now()).get(ChronoUnit.SECONDS);
	}

	public Long getId() {
		return id;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public long getSecoundsSinceLastUpdate() {
		return secoundsSinceLastUpdate;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getSubcategoryName() {
		return subcategoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public int getNumberOfResponses() {
		return numberOfResponses;
	}

	public boolean isSolved() {
		return solved;
	}

	// Criando um método estático das listas dos tópicos
	public static Page<TopicBriefOutputDto> listFromTopics(Page<Topic> topicPage) {
		// stream novo método de APIStream, collections java a partir da versão 8
		return topicPage.map(TopicBriefOutputDto::new);
	}

}
