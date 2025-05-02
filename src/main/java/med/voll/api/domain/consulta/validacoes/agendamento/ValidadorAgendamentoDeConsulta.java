package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.consulta.ComandoDadosAgendamentoConsulta;

public interface ValidadorAgendamentoDeConsulta {
    void validar(ComandoDadosAgendamentoConsulta dados);
}
