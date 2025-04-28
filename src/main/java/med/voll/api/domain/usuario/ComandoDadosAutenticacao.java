package med.voll.api.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record ComandoDadosAutenticacao(@NotBlank String login, @NotBlank String senha) {
}
