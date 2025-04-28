package med.voll.api.domain.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import med.voll.api.domain.endereco.Endereco;

@Setter
@EqualsAndHashCode(of = "id")
//@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Medico")
@Table(name = "medicos")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private boolean ativo;

    public Medico() {}

    public Medico(ComandoDadosCadastroMedico dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }


    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getCrm() {
        return this.crm;
    }

    public Especialidade getEspecialidade() {
        return this.especialidade;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void atualizarInformacoes(ComandoDadosAtualizacaoMedico dados) {
        if (dados.nome() != null && dados.nome() != "") {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null && dados.telefone() != "") {
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void desativar() {
        this.ativo = false;
    }
}
