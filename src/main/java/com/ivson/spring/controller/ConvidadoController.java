package com.ivson.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ivson.spring.model.Convidado;
import com.ivson.spring.repository.ConvidadoRepository;

@Controller
@RequestMapping("/convidados")
public class ConvidadoController {

	@Autowired
	private ConvidadoRepository convidadoRepository;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaConvidados");
		modelAndView.addObject("convidados", convidadoRepository.findAll());
		modelAndView.addObject(new Convidado());
		return modelAndView;
	}
	
	@PostMapping
	public String salvar(Convidado convidado) {
		this.convidadoRepository.save(convidado);
		return "redirect:/convidados";
	}
	
}
