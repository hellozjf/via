package com.hellozjf.via.dao;

import com.hellozjf.via.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author hellozjf
 * @date 2018/7/5 12:36
 */
public interface QuestionDao extends JpaRepository<QuestionEntity, Integer> {
}
