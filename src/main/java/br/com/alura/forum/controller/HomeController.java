package br.com.alura.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
//	Mapeando caminho específico do meu diretório
	@RequestMapping
	//Utilizando Thymeleaf template pronto
	@ResponseBody
	public String index() {
		System.out.println("Seja bem-vindo a página inicial");
		return "Seja Bem-vindo ao Spring!!";
	}
}
