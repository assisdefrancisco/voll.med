package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.ComandoDadosEndereco;

public record ComandoDadosAtualizacaoMedico(
        @NotNull Long id,
        String nome,
        String telefone,
        ComandoDadosEndereco endereco) {
}
