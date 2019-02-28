CREATE OR REPLACE FUNCTION cadastro_aluno() RETURNS TRIGGER AS
$BODY$
    BEGIN
        IF(TG_OP = 'INSERT') THEN

            IF NEW.nome IS NULL THEN
                RAISE EXCEPTION 'O nome do aluno é obrigatório.';
            END IF;
            NEW.data_cadastro = NOW();

        ELSEIF(TG_OP = 'UPDATE') THEN

            IF NEW.nome IS NULL THEN
                RAISE EXCEPTION 'O nome do aluno é obrigatório.';
            END IF;
            NEW.data_alteracao = NOW();

        END IF;

		RETURN NEW;
    END;
$BODY$ LANGUAGE plpgsql;

CREATE TRIGGER cadastro_aluno_trigger BEFORE INSERT OR UPDATE ON aluno
    FOR EACH ROW EXECUTE PROCEDURE cadastro_aluno();
