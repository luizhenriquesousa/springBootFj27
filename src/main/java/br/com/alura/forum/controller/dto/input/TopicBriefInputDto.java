package br.com.alura.forum.controller.dto.input;

import br.com.alura.forum.model.topic.domain.TopicStatus;

/**
 * 
 * @author lhsousa Classe de pesquisa/busca do fórum.
 */
public class TopicBriefInputDto {

	private TopicStatus topicStatus;
	private String categoryName;

	public TopicStatus getTopicStatus() {
		return topicStatus;
	}

	public void setTopicStatus(TopicStatus topicStatus) {
		this.topicStatus = topicStatus;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
