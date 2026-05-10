# Projeto-programação-orientada-a-objetos
Repositório relacionado ao desenvolvimento do projeto de Programação orientada a objetos

CREATE TABLE usuarios (

    id SERIAL PRIMARY KEY,
    usuario VARCHAR(50) UNIQUE NOT NULL,
    senha VARCHAR(100) NOT NULL
);


CCREATE TABLE filmes (

    id SERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    genero VARCHAR(50) NOT NULL,
    duracao VARCHAR(20) NOT NULL,
    ano INT NOT NULL,
    curtidas INT DEFAULT 0
);

CREATE TABLE favoritos (

    usuario_id INT,
    filme_id INT,

    PRIMARY KEY (usuario_id, filme_id),

    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (filme_id) REFERENCES filmes(id)
);

CREATE TABLE lista_reproducao (

    usuario_id INT,
    filme_id INT,

    PRIMARY KEY (usuario_id, filme_id),

    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (filme_id) REFERENCES filmes(id)
);

INSERT INTO filmes (titulo, genero, duracao, ano)
VALUES
('Vingadores: Ultimato', 'Ação', '181min', 2019, 0),

('Batman', 'Ação', '176min', 2022, 0),

('Interestelar', 'Ficção', '169min', 2014, 0),

('Matrix', 'Ficção', '136min', 1999, 0),

('Coringa', 'Drama', '122min', 2019, 0),

('Titanic', 'Romance', '195min', 1997, 0),

('Avatar', 'Ficção', '162min', 2009, 0),

('John Wick', 'Ação', '101min', 2014, 0),

('Toy Story', 'Animação', '81min', 1995, 0),

('Vingadores: Ultimato', 'Ação', '3h 1min', 2019, 0),

('Jogos Vorazes', 'Ação', '2h 22min', 2012, 0),

('Transformers', 'Ação', '2h 24min', 2007, 0),

('Invocação do Mal', 'Terror', '1h 52min', 2013, 0),

('Corra!', 'Terror', '1h 44min', 2017, 0),

('Barbie', 'Comédia', '1h 54min', 2023, 0),

('Top Gun: Maverick', 'Ação', '2h 11min', 2022, 0),

('Deadpool', 'Ação', '1h 48min', 2016, 0);


CREATE TABLE curtidas (

    usuario_id INT,
    filme_id INT,
    PRIMARY KEY (usuario_id, filme_id)
);
