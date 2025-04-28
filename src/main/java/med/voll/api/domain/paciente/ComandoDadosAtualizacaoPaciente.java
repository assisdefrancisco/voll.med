package med.voll.api.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.ComandoDadosEndereco;

public record ComandoDadosAtualizacaoPaciente(
        @NotNull Long id,
        String nome,
        String telefone,
        @Valid ComandoDadosEndereco endereco) {
}
