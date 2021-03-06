package com.example.spring04.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring04.model.dto.AnswerDTO;
import com.example.spring04.model.dto.SurveyDTO;

@Repository
public class SurveyDAOImpl implements SurveyDAO {
		
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public SurveyDTO showSurvey(int survey_idx) {//문제 내용
		return sqlSession.selectOne("show_survey",survey_idx);
	}

	@Override
	public void save(AnswerDTO dto) { //응답 저장
		sqlSession.insert("save_answer", dto);

	}

	@Override
	public List<AnswerDTO> showResult(int survey_idx) { //응답 통계
	return sqlSession.selectList("show_result",survey_idx);
	}

}
