package com.fa.training.mockproject.controllers;

import com.fa.training.mockproject.entities.dto.UserAccountsLoginDTO;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.exceptions.TemplateProcessingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("user")
public class ExceptionHandlerController implements ErrorController{

    @GetMapping("/error")
    public ModelAndView handlerError(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if(status != null){
            Integer statusCode = Integer.valueOf(status.toString());
            if((statusCode == 400) || (statusCode == 500)){
                modelAndView.setViewName("errorpage/500");
                return modelAndView;
            }
            if(statusCode == 404){
                modelAndView.setViewName("errorpage/404");
                return modelAndView;
            }
        }
        return null;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}