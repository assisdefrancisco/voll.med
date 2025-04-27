package med.voll.api.medico;

import med.voll.api.endereco.ComandoDadosEndereco;

public record ComandoDadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade, ComandoDadosEndereco endereco){
}