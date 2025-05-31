package com.gustavo.spring_boot_project.controller;

import com.gustavo.spring_boot_project.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestLogController {

    private Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());

    @RequestMapping("/test")
    public String testLog(){
        logger.info("This is an INFO log");
        logger.debug("this is an DEBUG log");
        logger.warn("This is an WARN log");
        logger.error("This is an ERROR log");
        return "Logs generated restfull";
    }
}
