package com.example.spring04.model.dao;

import java.util.List;

import com.example.spring04.model.dto.AnswerDTO;
import com.example.spring04.model.dto.SurveyDTO;

public interface SurveyDAO {
	
	SurveyDTO showSurvey(int survey_idx);
	void save(AnswerDTO dto);
	List<AnswerDTO> showResult(int survey_idx);

}
