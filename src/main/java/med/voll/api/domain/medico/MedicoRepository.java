package med.voll.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Page<Medico> findAllByAtivoTrue(Pageable paginacaoLimitada);

    @Query(value = """
            select m from Medico m
            where m.ativo = true
                and m.especialidade = :especialidade
                and m.id not in(                    
                    select c.medico.id from Consulta c where c.data = :data and c.motivoCancelamento is null
                )
                order by rand()
                limit 1
            """)
    Medico escolherMedicoAleatorioaLivreNaData(Especialidade especialidade, LocalDateTime data);

    @Query(value = """
                select m.ativo
                from Medico m
                where m.id = :idMedico
            """)
    boolean findAtivoById(Long idMedico);
}
