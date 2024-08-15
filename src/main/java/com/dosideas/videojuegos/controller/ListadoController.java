package com.dosideas.videojuegos.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dosideas.videojuegos.domain.VideoJuego;
import com.dosideas.videojuegos.service.VideoJuegoService;

@Controller
public class ListadoController {

	private final VideoJuegoService videojuegoservice;

	public ListadoController(VideoJuegoService videojuegoservice) {
		super();
		this.videojuegoservice = videojuegoservice;
	}

	@RequestMapping("/")
	public String listarVideoJuegos(Model model) {
		List<VideoJuego> destacados = videojuegoservice.buscarDestacados();
		model.addAttribute("videojuegos", destacados);
		return "listado";
	}

	@RequestMapping("/videojuegosPorDistribuidor")
	public String listarVideojuegosPorDistribuidor(
			@RequestParam(value = "distribuidorId", required = true) int distribuidorId, Model model) {
		List<VideoJuego> juegos = videojuegoservice.buscarPorDistribuidor(distribuidorId);
		model.addAttribute("videojuegos", juegos);
		return "listado";
	}

	@RequestMapping("/buscar")
	public String buscar(@RequestParam("q") String consulta, Model model) {
		List<VideoJuego> juegos = videojuegoservice.buscar(consulta);
		model.addAttribute("videojuegos", juegos);
		return "listado";
	}

}
