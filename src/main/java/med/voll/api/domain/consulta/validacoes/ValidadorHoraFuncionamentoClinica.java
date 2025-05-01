package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ComandoDadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHoraFuncionamentoClinica implements ValidadorAgendamentoDeConsulta {

    @Override
    public void validar(ComandoDadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDeAberturaDaClinica = dataConsulta.getHour() < 7;
        var depoisEncerramentoDaClinica = dataConsulta.getHour() > 18;

        if (domingo || antesDeAberturaDaClinica || depoisEncerramentoDaClinica) {
            throw new ValidacaoException("Consulta fora do horário de funcionamento da clíínica");
        }
    }
}
