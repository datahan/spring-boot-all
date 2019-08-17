package com.datahan.springbootall.exception.handler.controller;

import com.datahan.springbootall.exception.handler.constant.Status;
import com.datahan.springbootall.exception.handler.exception.JsonException;
import com.datahan.springbootall.exception.handler.exception.PageException;
import com.datahan.springbootall.exception.handler.model.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @GetMapping("/json")
    @ResponseBody
    public ApiResponse jsonException() {
        throw new JsonException(Status.UNKNOWN_ERROR);
    }

    @GetMapping("/page")
    public ModelAndView pageException() {
        throw new PageException(Status.UNKNOWN_ERROR);
    }
}
