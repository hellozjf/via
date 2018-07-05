package com.hellozjf.via.dao;

import com.hellozjf.via.entity.QuestionEntity;
import com.hellozjf.via.entity.ResultEntity;
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
public class ResultDaoTest {

	@Autowired
	private ResultDao resultDao;

	@Test
	public void testFindAll() {
		List<ResultEntity> resultEntities = resultDao.findAll();
		for (ResultEntity resultEntity : resultEntities) {
			log.debug("{}", resultEntity);
		}
	}

}
