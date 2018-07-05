package com.hellozjf.via.dao;

import com.hellozjf.via.entity.QuestionEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class QuestionDaoTest {

	@Autowired
	private QuestionDao questionDao;

	@Test
	public void testFindAll() {
		List<QuestionEntity> questionEntities = questionDao.findAll();
		for (QuestionEntity questionEntity : questionEntities) {
			log.debug("{}", questionEntity);
		}
	}

}
