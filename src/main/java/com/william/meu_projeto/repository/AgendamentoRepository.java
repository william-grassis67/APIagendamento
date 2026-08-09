package com.william.meu_projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.william.meu_projeto.enums.StatusAgendamento;
import com.william.meu_projeto.model.SolicitacaoAgendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<SolicitacaoAgendamento, Long> {

    boolean existsByDataAndHorarioAndProfissional(String data, String horario, String profissional);

}
