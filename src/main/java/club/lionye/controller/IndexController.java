package club.lionye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import club.lionye.dao.UserDao;
import club.lionye.entity.User;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	private UserDao userDaoImpl;

	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("indexMain");
		return mav;
	}
	
	
	@RequestMapping("/test")
	@ResponseBody
	public String queryByname(){
		return userDaoImpl.queryByuserName("张三").getNumber();	
	}
	

}
