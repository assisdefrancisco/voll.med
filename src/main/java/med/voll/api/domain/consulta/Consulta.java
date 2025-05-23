package med.voll.api.domain.consulta;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import med.voll.api.domain.enums.MotivoCancelamento;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.paciente.Paciente;

import java.time.LocalDateTime;

//@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "consultas")
@Entity(name = "Consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private LocalDateTime data;

    @Column(name = "motivo_cancelamento")
    @Enumerated(EnumType.STRING)
    private MotivoCancelamento motivoCancelamento;

    public Consulta() {
    }

    public Consulta(Medico medico, Paciente paciente, LocalDateTime data, MotivoCancelamento motivoCancelamento) {
        this.medico = medico;
        this.paciente = paciente;
        this.data = data;
        this.motivoCancelamento = motivoCancelamento;
    }

    public void cancelar(MotivoCancelamento motivo) {
        this.motivoCancelamento = motivo;
    }

    public Long getId() {
        return this.id;
    }

    public Medico getMedico() {
        return this.medico;
    }

    public Paciente getPaciente() {
        return this.paciente;
    }

    public LocalDateTime getData() {
        return this.data;
    }

    public MotivoCancelamento getMotivoCancelamento() {
        return this.motivoCancelamento;
    }
}
