package cc.fj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by asus on 2016/2/10.
 */
@Controller
@RequestMapping(value="folder")
public class TestRequestToViewNameController {

    @RequestMapping(value = "registration",method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("name","Harry");

        return modelAndView;
    }

    @RequestMapping(value="index",method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modelAndView=new ModelAndView();

        modelAndView.setViewName("/folder/registration");
        return modelAndView;
    }

}
