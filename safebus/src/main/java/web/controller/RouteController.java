package web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import spring.biz.route.service.RouteService;

@RestController
public class RouteController {

	//Logger log = new logger
	String result = "";
   @Autowired
   RouteService routeservice;
   
//@RequestMapping(value="/parentsList.do", method = RequestMethod.GET)
//   
//   public @ResponseBody List<ParentsVO> logout1(ParentsVO vo) {
//         System.out.println(vo);
//      return parentsservice.getParentsList();
//
//   }
   
 @RequestMapping(value="/absent.do", method = RequestMethod.GET)
   
   public int absent2() {
         
	 System.out.println("hello");
         return 0;
      

   }
   
   @RequestMapping(value="/absent.do", method = RequestMethod.POST)
   
   public void absent(@RequestParam("station") String vo, HttpServletRequest request, HttpServletResponse response) throws IOException {
	   	response.setContentType("text/plain; charset=UTF8");
	   	PrintWriter out;
         String station = request.getParameter("station");
         
         System.out.println(station);
         System.out.println("station value : " + vo);
         
         int row = routeservice.absent(vo);
         System.out.println("결과 : "+row);
         System.out.println("결석 처리 완료!!");
         
         //Map<String, Integer> map = new HashMap<String, Integer>();
         
         //map.put("code", 100);
        
         out = response.getWriter();
         
         result = "success";
         out.print(result);
         out.flush();
         out.close();
         
         
         
   }
   
   @RequestMapping(value="/present.do", method = RequestMethod.POST)
   
   public void present(@RequestParam("station") String vo, HttpServletRequest request, HttpServletResponse response) throws IOException {
	   	response.setContentType("text/plain; charset=UTF8");
	   	PrintWriter out;
        String station = request.getParameter("station");
        
        System.out.println(station);
        System.out.println("station value : " + vo);
        
        int row = routeservice.present(vo);
        System.out.println("결과 : "+row);
        System.out.println("결석취소 완료!!");
        
        //Map<String, Integer> map = new HashMap<String, Integer>();
        
        //map.put("code", 100);
       
        out = response.getWriter();
        
        result = "success";
        out.print(result);
        out.flush();
        out.close();
        
        
        
  }
}
