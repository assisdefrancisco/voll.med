package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.consulta.AgenciaDeConsultasService;
import med.voll.api.domain.consulta.ComandoDadosAgendamentoConsulta;
import med.voll.api.domain.consulta.ComandoDadosCancelamentoConsulta;
import med.voll.api.domain.consulta.DadosDetalhamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private AgenciaDeConsultasService agenciaDeConsultasService;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid ComandoDadosAgendamentoConsulta dados) {
        var dto = agenciaDeConsultasService.agendar(dados);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid ComandoDadosCancelamentoConsulta dados) {
        agenciaDeConsultasService.cancelar(dados);
        return ResponseEntity.notFound().build();
    }
}
