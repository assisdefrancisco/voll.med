package med.voll.api.domain.consulta.validacoes.cancelamento;

import med.voll.api.domain.consulta.ComandoDadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {

    void validar(ComandoDadosCancelamentoConsulta dados);

}
