package com.fa.training.mockproject.controllers;

import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
@SessionAttributes("user")
public class FileSizeExceptionHandlerController {
    @ExceptionHandler(FileSizeLimitExceededException.class)
    public String handleFileSizeLimitExceeded(FileSizeLimitExceededException exc, RedirectAttributes model) {
        model.addFlashAttribute("message", "File size too large!");
        return "redirect:/my-account/photo";
    }
}
