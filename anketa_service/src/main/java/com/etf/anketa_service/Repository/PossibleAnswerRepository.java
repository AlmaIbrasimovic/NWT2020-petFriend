package com.etf.anketa_service.Repository;

import com.etf.anketa_service.Model.PossibleAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PossibleAnswerRepository extends JpaRepository<PossibleAnswer, Long> {

}
