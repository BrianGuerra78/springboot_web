DROP TABLE IF EXISTS videojuegos.videojuegos;

USE videojuegos;

create table videojuegos(
	id int primary key auto_increment,
	nombre varchar(200) not null,
	descripcion varchar(5000),
	imagen_url varchar(500)
);

insert into videojuegos
(id, nombre, descripcion,   imagen_url) values 
(1, 'The Legend of Zelda: Ocarina of Time','The Legend of Zelda: Ocarina of Time es un videojuego de acción, desarrollado por Nintendo EAD y publicado por Nintendo para la consola Nintendo 64. El protagonista es Link, que se adentra en el reino de Hyrule para detener a Ganondorf, rey de la tribu Gerudo.','https://www.infobae.com/new-resizer/yorvI0CIwp7brQ2z-nBN1JGAHuc=/768x432/filters:format(webp):quality(85)/s3.amazonaws.com/arc-wordpress-client-uploads/infobae-wp/wp-content/uploads/2019/07/11124929/The-Legend-of-Zelda-Ocarnia-of-Time.jpg'),
(2, 'Grand Theft Auto IV','Grand Theft Auto IV es un videojuego de acción de mundo abierto creado por Rockstar North. El protagonista es Niko Bellic, un veterano de guerra de Europa del Este, que llegó a Estados Unidos en busca del sueño americano, pero que termina metido en un mundo criminal. El escenario de la historia es la ficticia ciudad de Liberty City.','https://www.infobae.com/new-resizer/zqu-fqtEtsSTGQiN0WtCJGAMJpY=/768x432/filters:format(webp):quality(85)/s3.amazonaws.com/arc-wordpress-client-uploads/infobae-wp/wp-content/uploads/2019/07/11130411/Grand-theft-auto-4.jpg'),
(3, 'Super Mario Galaxy','Super Mario Galaxy es un videojuego en 3D creado por Nintendo EAD Tokio y publicado por Nintendo para su consola Wii. Esta edición, que se presentó en 2007, sigue la misma trama que la de la serie: los hermanos tratan de salvar a la princesa de las garras del malvado Bowser.','https://www.infobae.com/new-resizer/qKjkwgv7B2J_E8z_Lcti5cj7JEQ=/768x432/filters:format(webp):quality(85)/s3.amazonaws.com/arc-wordpress-client-uploads/infobae-wp/wp-content/uploads/2019/07/11132017/Super-Mario-Galaxy.jpg'),
(4, 'Halo: Combat Evolved','Es un videojuego de disparos en primera persona publicado por Microsoft Game Studios el 15 de noviembre de 2001.','https://www.infobae.com/new-resizer/j4ivbB1U5fLYqQUwwd21sQ-nP7s=/768x576/filters:format(webp):quality(85)/s3.amazonaws.com/arc-wordpress-client-uploads/infobae-wp/wp-content/uploads/2019/07/11145628/Halo-Combat-Evolved.jpg'),
(5, 'Red Dead Redemption 2','Red Dead Redemption 2 es la secuela del videojuego de éxito de Rockstar Red Dead Redemption (2010), considerado como uno de los mejores títulos de la compañía. Se trata de la tercera entrega de la saga Red Dead, iniciada en 2004 con Red Dead Revolver y nos trasladará de nuevo al Salvaje Oeste para ponernos en el escenario de mundo abierto más grande jamás creado por los padres de Grand Theft Auto','https://i.blogs.es/169695/red0/1366_2000.jpg'),
(6, 'Resident Evil 4 Remake','Resident Evil 4 Remake es la reimaginación del clásico juego de acción y terror en tercera persona desarrollado por Capcom para PlayStation 4 y 5, Xbox One, Xbox Series S y X y PC. Se trata de la puesta al día del survival horror de la saga Resident Evil lanzado en 2005, una ambiciosa puesta al día a nivel jugable y gráfico que nos devuelve a Leon S.','https://image.api.playstation.com/vulcan/ap/rnd/202210/0712/BiS5QP6h4506JHyJlZlVzK9D.jpg'),
(7, 'God of War: Ragnarok','God of War: Ragnarok es la nueva aventura de acción y rol para PlayStation 5 y PlayStation 4, continuación de God of War de 2018, uno de los títulos más exitosos de la plataforma de sobremesa de Sony. Desarrollado por el prestigioso estudio Sony Santa Monica, nos presenta una nueva historia en la que Kratos deberá enfrentarse a diversos enemigos de inspiración nórdica, explorando los mitos del Ragnarok','https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/media/image/2021/09/god-war-ragnarok-2466115.jpg'),
(8, 'Dragon Ball: Sparking! Zero','Dragon Ball: Sparking! Zero es un juego de lucha desarrollado por Spike Chunsoft y publicado por Bandai Namco para PlayStation 5, Xbox Series y PC. La querida saga Budokai Tenkaichi regresa con un nuevo y espectacular juego de lucha en 3D que incluye más de 160 personajes como Goku, Vegeta, Jiren o Broly en múltiples formas para librar épicas batallas en amplios escenarios que se destruyen en tiempo real, imitando mejor que nunca el aspecto del anime gracias al uso del Unreal Engine 5.','https://static.wikia.nocookie.net/dragonball/images/b/bd/Dragon_Ball_Sparking_Zero_portada.png/revision/latest?cb=20240607231759&path-prefix=es');

DROP TABLE IF EXISTS videojuegos.distribuidor;

USE videojuegos;

create table distribuidor (
	id int primary key auto_increment,
	nombre varchar(200) not null,
	sitio_web varchar(500)
);


insert into distribuidor
(id, nombre, sitio_web) values
(1, '2K', 'https://2k.com'),
(2, 'Focus Home Interactive', 'https//www.focus-home.com'),
(3, 'Thecla', null),
(4, 'Number One', null),
(5, '505 Games', 'https://505games.com'),
(6, 'Unknown Worlds Entertaiment', 'https://unknownworlds.com'),
(7, 'Campo Santo', 'https://camposanto.com');

USE videojuegos;

alter table videojuegos
add column distribuidor_id int,
add foreign key (distribuidor_id) references distribuidor(id);

update videojuegos set distribuidor_id = 1 where id in (1, 5);
update videojuegos set distribuidor_id = 2 where id in (2);
update videojuegos set distribuidor_id = 3 where id in (3);
update videojuegos set distribuidor_id = 4 where id in (4);
update videojuegos set distribuidor_id = 5 where id in (6);
update videojuegos set distribuidor_id = 6 where id in (7);
update videojuegos set distribuidor_id = 7 where id in (8);

USE videojuegos;

alter table videojuegos
modify distribuidor_id int not null;
