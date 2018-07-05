package com.hellozjf.via.controller;

import com.hellozjf.via.session.SessionValues;
import com.hellozjf.via.util.ResultVOUtils;
import com.hellozjf.via.vo.ResultVO;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hellozjf
 * @date 2018/7/5 14:25
 */
@RestController
@Component
@Getter
@Slf4j
public class AnswerController {

    @Autowired
    private SessionValues sessionValues;

    @PostMapping("/answer.action")
    public ResultVO answer(
            Session session,
            @RequestParam(name="id", required=false) Integer id,
            @RequestParam(name="value", required=false) Integer value) {
        log.debug("id={} value={}", id, value);
        Map<Integer, Integer> map = sessionValues.getSessionValues().get(session);
        value
        if (map == null) {
            sessionValues.getSessionValues().put(session, map);
        }
        values.put(id, value);
        log.debug("values={}", values);

        return ResultVOUtils.success();
    }
}
