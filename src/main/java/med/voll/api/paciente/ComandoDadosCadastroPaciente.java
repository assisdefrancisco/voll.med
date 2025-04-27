package med.voll.api.paciente;

import med.voll.api.endereco.ComandoDadosEndereco;

public record ComandoDadosCadastroPaciente(String nome, String email, String telefone, String cpf, ComandoDadosEndereco endereco) {
}
