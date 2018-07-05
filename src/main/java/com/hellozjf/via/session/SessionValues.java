package com.hellozjf.via.session;

import lombok.Data;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author hellozjf
 * @date 2018/7/5 21:53
 */
@Component
@Data
public class SessionValues {
    private Map<Session, Map<Integer, Integer>> sessionValues;
}
