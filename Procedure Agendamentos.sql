CREATE PROCEDURE SP_Agendamento

@dataInicio datetime2,
@dataFim datetime2

AS
BEGIN

SELECT
Agendamento.dataHora,
Servico.nome,
Servico.valor,
Cliente.nome
FROM Agendamento 
	INNER JOIN Cliente ON clienteId = Cliente.Id
	INNER JOIN Servico ON servicoid = Servico.Id
WHERE dataHora BETWEEN @dataInicio AND @dataFim
END

