package com.dosideas.videojuegos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dosideas.videojuegos.domain.VideoJuego;
import com.dosideas.videojuegos.service.DistribuidorService;
import com.dosideas.videojuegos.service.VideoJuegoService;

@Controller
public class VideoJuegoAbmController {

	private final DistribuidorService distribuidorService;

	private final VideoJuegoService videoJuegoService;

	public VideoJuegoAbmController(DistribuidorService distribuidorService, VideoJuegoService videoJuegoService) {
		this.distribuidorService = distribuidorService;
		this.videoJuegoService = videoJuegoService;
	}

	@RequestMapping("/videojuego/crear")
	public String mostrarFormAlta(Model model) {
		model.addAttribute("distribuidores", distribuidorService.buscarTodos());
		model.addAttribute("videojuego", new VideoJuego());
		return "formVideoJuego";
	}

	@PostMapping("/videojuegos/guardar")
	public String guardar(VideoJuego videojuego) {
		videoJuegoService.guardar(videojuego);
		return "redirect:/";
	}
}
