package web.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.biz.driver.service.DriverService;
import spring.biz.parents.service.ParentsService;
import spring.biz.parents.vo.ParentsVO;
import spring.biz.route.service.RouteService;
import spring.biz.user.service.UserService;
import spring.biz.user.vo.UserVO;

@Controller
public class MapController {

	@Autowired
	UserService service;
	@Autowired
	ParentsService parentsservice;
	@Autowired
	DriverService driverservice;
	@Autowired
	RouteService routeservice;
	
	@RequestMapping(value = "/routeInfo.do", method = RequestMethod.GET)
	public String login() {
		return null;
	}

	@RequestMapping(value = "/routeInfo.do", method = RequestMethod.POST)
	public String loginProc( HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("text/plain; charset=UTF8");
		PrintWriter out;
			
		String state = request.getParameter("state");
		String station = request.getParameter("station"); // 안드로이드에서 station을 받는다 . 
		String returns = "";
		   	
		return null;
	}
}
