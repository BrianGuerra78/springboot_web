package com.dosideas.videojuegos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dosideas.videojuegos.domain.VideoJuego;

public interface VideoJuegoRepository extends JpaRepository<VideoJuego, Integer> {

	// @Query(value = "select * from videojuegos order by nombre", nativeQuery =
	// true)
	// @Query("select v from VideoJuego v order by v.nombre")
	@Query("from VideoJuego v order by v.nombre")
	List<VideoJuego> busacarTodos();

	@Query("from VideoJuego v where v.distribuidor.id = ?1 order by v.nombre")
	List<VideoJuego> buscarPorDistribuidor(int distribuidor);

	//@Query("from VideoJuego v where v.nombre like %?1%")
	//List<VideoJuego> buscar(String consulta);

	List<VideoJuego> findByNombreContaining(String consulta);
}
