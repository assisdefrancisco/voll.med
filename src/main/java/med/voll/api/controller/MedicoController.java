package med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import med.voll.api.domain.medico.DadosDetalhamentoMedico;
import med.voll.api.domain.medico.DadosListagemMedico;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@SecurityRequirement(name = "bearer-key")
@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid ComandoDadosCadastroMedico dados, UriComponentsBuilder uriBuilder) {
        var medico = new Medico(dados);
        medico = medicoRepository.save(medico);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 2, sort = {"nome"}) Pageable paginacao) {
        int page = paginacao.getPageNumber();
        int size = paginacao.getPageSize();

        if (size > 100) {
            size = 100; // Limita o tamanho
        }

        Pageable paginacaoLimitada = PageRequest.of(page, size, paginacao.getSort());
        var pageable = medicoRepository.findAllByAtivoTrue(paginacaoLimitada).map(DadosListagemMedico::new);

        return ResponseEntity.ok(pageable);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<DadosDetalhamentoMedico> detalhcar(@PathVariable Long id) {
//        var medico = medicoRepository.getReferenceById(id);
//        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
//    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid ComandoDadosAtualizacaoMedico dados) {
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

//    @DeleteMapping("/{id}")
//    @Transactional
//    public void excluir(@PathVariable Long id) {
//        medicoRepository.deleteById(id);
//    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.desativar();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

}
