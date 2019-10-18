package web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.biz.parents.service.ParentsService;
import spring.biz.parents.vo.ParentsVO;

@Controller
public class ParentsController {

   @Autowired
   ParentsService parentsservice;
   
//@RequestMapping(value="/parentsList.do", method = RequestMethod.GET)
//   
//   public @ResponseBody List<ParentsVO> logout1(ParentsVO vo) {
//         System.out.println(vo);
//      return parentsservice.getParentsList();
//
//   }
   
   @RequestMapping(value="/parentsList.do", method = RequestMethod.POST)
   
   public @ResponseBody List<ParentsVO> logout(ParentsVO vo) {
         System.out.println(vo);
      return parentsservice.getParentsList();

   }
}
