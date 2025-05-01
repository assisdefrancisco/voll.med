package med.voll.api.domain.consulta;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.enums.MotivoCancelamento;

public record ComandoDadosCancelamentoConsulta(
    @NotNull Long idConsulta,
    @NotNull
    MotivoCancelamento motivo) {
}
