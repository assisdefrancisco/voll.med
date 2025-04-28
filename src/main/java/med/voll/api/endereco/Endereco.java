package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.*;

@Setter
@Getter
//@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco() {}
    public Endereco(ComandoDadosEndereco endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
    }

    public void atualizarInformacoes(ComandoDadosEndereco dados) {
        if (dados.logradouro() != null && dados.logradouro() != "") {
            this.logradouro = dados.logradouro();
        }
        if (dados.bairro() != null && dados.bairro() != "") {
            this.bairro = dados.bairro();
        }
        if (dados.cep() != null && dados.cep() != "") {
            this.cep = dados.cep();
        }
        if (dados.uf() != null && dados.uf() != "") {
            this.uf = dados.uf();
        }
        if (dados.cidade() != null && dados.cidade() != "") {
            this.cidade = dados.cidade();
        }
        if (dados.numero() != null && dados.numero() != "") {
            this.numero = dados.numero();
        }
        if (dados.complemento() != null && dados.complemento() != "") {
            this.complemento = dados.complemento();
        }

    }
}
