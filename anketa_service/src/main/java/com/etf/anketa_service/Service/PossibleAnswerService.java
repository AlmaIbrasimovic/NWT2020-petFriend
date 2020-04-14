package com.etf.anketa_service.Service;

import com.etf.anketa_service.Exception.PossibleAnswerException;
import com.etf.anketa_service.Model.PossibleAnswer;
import com.etf.anketa_service.Repository.PossibleAnswerRepository;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PossibleAnswerService {
    private PossibleAnswerRepository possibleAnswerRepository;

    public PossibleAnswerService(final PossibleAnswerRepository possibleAnswerRepository) {
        this.possibleAnswerRepository = possibleAnswerRepository;
    }

    public List<PossibleAnswer> findAll() {
        return possibleAnswerRepository.findAll();
    }

    public List<PossibleAnswer> getAllForSurvey(Long surveyId) {
        return possibleAnswerRepository.findAllByQuestion_SurveyId(surveyId);
    }

    public PossibleAnswer getPossibleAnswerById(Long id) {
        return possibleAnswerRepository.findById(id).orElseThrow(() -> new PossibleAnswerException(id));
    }

    public ResponseEntity<JSONObject> deleteAllPossibleAnswers() {
        possibleAnswerRepository.deleteAll();
        JSONObject returnValue = new JSONObject();
        returnValue.put("message", "Uspjesno obrisani ponudjeni odgovori!");
        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }

    public ResponseEntity<JSONObject> deleteSpecifiedPossibleAnswer(Long possibleAnswerId) {
        JSONObject returnValue = new JSONObject();
        try {
            possibleAnswerRepository.deleteById(possibleAnswerId);
            returnValue.put("message", "Uspjesno obrisan ponudjeni odgovor!");
            return new ResponseEntity<>(returnValue, HttpStatus.OK);
        }
        catch(Exception err) {
            returnValue.put("message", err.getMessage());
            return new ResponseEntity<>(returnValue, HttpStatus.BAD_REQUEST);
        }
    }

    public PossibleAnswer addPossibleAnswer(PossibleAnswer possibleAnswer) {
        return possibleAnswerRepository.save(possibleAnswer);
    }

    public PossibleAnswer putPossibleAnswer(PossibleAnswer newPossibleAnswer, Long possibleAnswerId) {
        Optional<PossibleAnswer> toEdit = possibleAnswerRepository.findById(possibleAnswerId);
        if (!toEdit.isPresent()) {
            possibleAnswerRepository.save(newPossibleAnswer);
            return newPossibleAnswer;
        } else {
            toEdit.get().setQuestion(newPossibleAnswer.getQuestion());
            toEdit.get().setAnswer(newPossibleAnswer.getAnswer());
            toEdit.get().setGivenAnswers(newPossibleAnswer.getGivenAnswers());
            toEdit.get().setPoints(newPossibleAnswer.getPoints());
            return toEdit.get();
        }
    }

}
