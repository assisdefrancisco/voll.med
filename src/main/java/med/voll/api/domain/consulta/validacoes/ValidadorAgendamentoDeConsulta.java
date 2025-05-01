package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.ComandoDadosAgendamentoConsulta;

public interface ValidadorAgendamentoDeConsulta {
    void validar(ComandoDadosAgendamentoConsulta dados);
}
