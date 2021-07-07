package com.example.spring04.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring04.model.dao.SurveyDAO;
import com.example.spring04.model.dto.AnswerDTO;
import com.example.spring04.model.dto.SurveyDTO;

@Controller //컨트롤라
public class SurveyController {
	
	@Autowired
	SurveyDAO surveyDao;
	
	@RequestMapping("/")
	public ModelAndView show_survey() {
		SurveyDTO dto= surveyDao.showSurvey(1); //문제 1번 내용
		return new ModelAndView("main","dto",dto); //main.jsp
	}
	
	@RequestMapping("/save_survey.do")
	public String save_survey(AnswerDTO dto) {
		surveyDao.save(dto);//응답내용 저장
		return "success";//success.jsp
	}
	
	@RequestMapping("/show_result.do") //응답 통계
	public ModelAndView show_result(int survey_idx) {
		Map<String, Object> map=new HashMap<>();
		SurveyDTO dto=surveyDao.showSurvey(survey_idx); 
		List<AnswerDTO> items=surveyDao.showResult(survey_idx); 
		map.put("dto",dto);
		map.put("list", items);
		return new ModelAndView("result", "map", map);//result.jsp
	}

}
