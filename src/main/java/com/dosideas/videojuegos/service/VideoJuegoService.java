package com.dosideas.videojuegos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dosideas.videojuegos.domain.VideoJuego;
import com.dosideas.videojuegos.repository.VideoJuegoRepository;

@Service
public class VideoJuegoService {

	private final VideoJuegoRepository videojuegorepository;

	public VideoJuegoService(VideoJuegoRepository videojuegorepository) {
		this.videojuegorepository = videojuegorepository;
	}

	public List<VideoJuego> buscarDestacados() {
		/*
		 * List<VideoJuego> destacados = new ArrayList<>();
		 * 
		 * VideoJuego juego = new VideoJuego(); juego.setNombre("Need for Speed");
		 * juego.
		 * setDescripcion("Vieojuego sobre carrerras callejeras con autos modificados, persecuciones y misiones"
		 * ); juego.setImagenUrl(
		 * "https://image.api.playstation.com/cdn/UP0006/CUSA01925_00/RxeNb9Ph1y2VhBGv5Ct0tuY6f5xC4t9f.png?w=440"
		 * );
		 * 
		 * destacados.add(juego);
		 * 
		 * juego = new VideoJuego(); juego.setNombre("Mario Kart"); juego.
		 * setDescripcion("Vieojuego sobre el mundo de mario y carreras en gokarts");
		 * juego.setImagenUrl(
		 * "https://assets.nintendo.com/image/upload/ar_16:9,c_lpad,w_1240/b_white/f_auto/q_auto/ncom/software/switch/70010000000153/de697f487a36d802dd9a5ff0341f717c8486221f2f1219b675af37aca63bc453"
		 * );
		 * 
		 * destacados.add(juego);
		 * 
		 * juego = new VideoJuego(); juego.setNombre("Lego Batman"); juego.
		 * setDescripcion("Vieojuego sobre el mundo de lego con la tematica de Batman");
		 * juego.setImagenUrl(
		 * "https://cdn2.unrealengine.com/Diesel%2Fproductv2%2Flego-batman%2FEGS_WB_LEGO_Batman_G1_1920x1080_19_0911-1920x1080-e166b698acbbbcdae1ff306198684d143828467c.jpg"
		 * );
		 * 
		 * destacados.add(juego);
		 * 
		 * juego = new VideoJuego(); juego.setNombre("Grand Turismo"); juego.
		 * setDescripcion("Vieojuego sobre carrerras de circuito y simulador de carreras reales"
		 * ); juego.setImagenUrl(
		 * "https://image.api.playstation.com/vulcan/ap/rnd/202109/1321/3GEdKTGktTBsZ8Sj9yIWnr2f.jpg"
		 * );
		 * 
		 * destacados.add(juego);
		 * 
		 * return destacados ;
		 */

		// return videojuegorepository.findAll();

		return videojuegorepository.busacarTodos();
	}

	public List<VideoJuego> buscarPorDistribuidor(int distribuidorId) {
		return videojuegorepository.buscarPorDistribuidor(distribuidorId);
	}

	public List<VideoJuego> buscar(String consulta) {
		//return videojuegorepository.buscar(consulta);
		return videojuegorepository.findByNombreContaining(consulta); 
	}

	public VideoJuego guardar(VideoJuego videojuego) {
		return videojuegorepository.save(videojuego);
	}
}
