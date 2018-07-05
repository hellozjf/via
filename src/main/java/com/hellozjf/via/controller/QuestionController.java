package com.hellozjf.via.controller;

import com.hellozjf.via.dao.QuestionDao;
import com.hellozjf.via.entity.QuestionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author hellozjf
 * @date 2018/7/5 13:35
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionDao questionDao;

    @GetMapping("/getQuestion.action")
    public String greeting(
            @RequestParam(name="id", required=false, defaultValue="1") Integer id,
            Model model) {
        QuestionEntity questionEntity = questionDao.getOne(id);
        model.addAttribute("questionEntity", questionEntity);
        return "question";
    }
}
