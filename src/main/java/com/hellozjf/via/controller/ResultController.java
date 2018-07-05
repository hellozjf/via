package com.hellozjf.via.controller;

import com.hellozjf.via.dao.ResultDao;
import com.hellozjf.via.entity.ResultEntity;
import com.hellozjf.via.vo.Character;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

/**
 * @author hellozjf
 * @date 2018/7/5 17:44
 */
@Controller
@Slf4j
public class ResultController {

    @Autowired
    private AnswerController answerController;

    @Autowired
    private ResultDao resultDao;

    @GetMapping("/result.action")
    public String result(Model model) {
        Map<Integer, Integer> map = answerController.getValues();
        List<Element> elementList = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            Element element = new Element();
            element.id = i + 1;
            element.value = 0;
            elementList.add(element);
        }
        Integer[] array = new Integer[24];
        for (Integer key : map.keySet()) {
            elementList.get(key % 24).value += map.get(key);
        }

        // 将elementList按value从大到小进行排序
        Collections.sort(elementList, new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o2.value - o1.value;
            }
        });

        List<Character> characterList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Integer id = elementList.get(i).id;
            ResultEntity result = resultDao.getOne(id);

            Character character = new Character();
            character.setId(id);
            character.setName(result.getName());
            character.setDesc(result.getDesc());
            characterList.add(character);
        }

        model.addAttribute("results", characterList);
        return "result";
    }

    class Element {
        Integer id;
        Integer value;
    }
}
