package tech.jamersondev.springdesk.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SuppressWarnings("deprecation")
public class CustomErrorController implements ErrorController{

    @RequestMapping("/error")
    public ModelAndView customError(HttpServletRequest request){

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Integer statusCode = Integer.parseInt(status.toString());

        if(statusCode == HttpStatus.NOT_FOUND.value()){
           return new ModelAndView("pagesTema/erros/error-404");
        }else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()){
            return new ModelAndView("pagesTema/erros/error-500");
        }

        return new ModelAndView("error");

    }
    
}
