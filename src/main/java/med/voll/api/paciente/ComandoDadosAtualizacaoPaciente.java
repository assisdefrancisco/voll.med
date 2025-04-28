package med.voll.api.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.ComandoDadosEndereco;

public record ComandoDadosAtualizacaoPaciente(
        @NotNull Long id,
        String nome,
        String telefone,
        @Valid ComandoDadosEndereco endereco) {
}
