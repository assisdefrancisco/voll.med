package med.voll.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.ComandoDadosEndereco;

public record ComandoDadosAtualizacaoMedico(
        @NotNull Long id,
        String nome,
        String telefone,
        ComandoDadosEndereco endereco) {
}
