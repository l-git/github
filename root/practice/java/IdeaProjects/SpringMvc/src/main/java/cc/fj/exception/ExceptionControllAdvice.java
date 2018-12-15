package cc.fj.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by asus on 2015/11/30.
 */
@ControllerAdvice
public class ExceptionControllAdvice {

    //@ExceptionHandler(Exception.class)
    public ModelAndView exception(Exception exception){
        ModelAndView modelAndView=new ModelAndView("error");
        modelAndView.addObject("name",exception.getClass().getName());
        modelAndView.addObject("message",exception.getMessage());
        return modelAndView;
    }
}
