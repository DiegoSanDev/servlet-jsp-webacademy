CREATE TABLE aluno(
    id SERIAL NOT NULL,
    nome VARCHAR(200) NOT NULL,
    email VARCHAR(200) NOT NULL,
    cpf VARCHAR(14),
    rg VARCHAR(7),
    data_nascimento DATE,
    data_cadastro DATE NOT NULL,
    data_alteracao DATE,
    CONSTRAINT pk_aluno PRIMARY KEY(id)
);
