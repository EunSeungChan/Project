package web.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sun.tracing.dtrace.ModuleAttributes;

import spring.biz.driver.service.DriverService;
import spring.biz.driver.vo.DriverVO;
import spring.biz.parents.service.ParentsService;
import spring.biz.parents.vo.ParentsVO;
import spring.biz.route.service.RouteService;
import spring.biz.teacher.service.TeacherService;
import spring.biz.teacher.vo.TeacherVO;
import spring.biz.user.service.UserService;
import spring.biz.user.vo.UserVO;

@Controller
public class SigninController {

	@Autowired
	UserService service;
	@Autowired
	ParentsService parentsservice;
	@Autowired
	DriverService driverservice;
	@Autowired
	TeacherService teacherservice;
	@Autowired
	RouteService routeservice;
	
	@Autowired
	private DataSourceTransactionManager transactionManager;

	String result = "";

	// parents 회원가입
	@RequestMapping(value = "/parents/add.do", method = RequestMethod.GET)
	public String addParents() {
		System.out.println("get 들어는왔음 ");
		return null;
	}

	@RequestMapping(value = "/parents/add.do", method = RequestMethod.POST)
	public String addParentsProc(UserVO uservo, ParentsVO parentsvo, HttpServletRequest request,
			HttpServletResponse response) {

		// DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		// def.setName("HOHOHO");
		// def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

		// TransactionStatus status = transactionManager.getTransaction(def);

		System.out.println("들어는왔음 ");

		response.setContentType("text/plain; charset=UTF8");
		PrintWriter out;

		String babyname = request.getParameter("babyname");
		String babygender = request.getParameter("babygender");
		String address = request.getParameter("address");
		String station = request.getParameter("station");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String date = request.getParameter("date");
		String info = request.getParameter("info");

		System.out.println(id);

		UserVO user = new UserVO();
		user.setUserid(id);
		user.setUserpwd(pw);
		user.setUserinfo(info);

		ParentsVO pv = new ParentsVO();
		pv.setUser_id(id);
		pv.setUser_info(info);
		pv.setBaby_name(babyname);
		pv.setBaby_gender(babygender);
		pv.setParent_name(name);
		pv.setParent_phone(tel);
		pv.setAddress(address);
		pv.setStation(station);

		System.out.println("add 시작");

		int row = 0;
		row = service.addUser(user);
		// System.out.println(row);

		// transactionManager.commit(status);
		// 위에놈과 아랫놈이 분리되어야 해요!

		parentsservice.addParents(pv);

		// 해당되는 starion에 count +1
		int resultCount = routeservice.addCount(station);
		System.out.println("addCount :" +resultCount);
		
		System.out.println(user);
		System.out.println(pv);

		// validator 작성
		/*
		 * new UserValidator().validate(vo, errors); if (errors.hasErrors()) { return
		 * "user/user_write"; } int row = 0; row = service.addUser(vo); return
		 * "redirect:/user/list.do";
		 */

		try {
			out = response.getWriter();

			result = "회원가입 성공";
			out.print(result);
			out.flush();
			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// teacher 회원가입
	@RequestMapping(value = "/teacher/add.do", method = RequestMethod.GET)
	public String addTeacher() {
		System.out.println("get 들어는왔음 ");
		return null;
	}

	@RequestMapping(value = "/teacher/add.do", method = RequestMethod.POST)
	public String addTeacherProc(UserVO uservo, TeacherVO teachervo, HttpServletRequest request,
			HttpServletResponse response) {

		// DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		// def.setName("HOHOHO");
		// def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

		// TransactionStatus status = transactionManager.getTransaction(def);

		System.out.println("들어는왔음 ");

		response.setContentType("text/plain; charset=UTF8");
		PrintWriter out;

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String date = request.getParameter("date");
		String info = request.getParameter("info");

		System.out.println(id);

		UserVO user = new UserVO();
		user.setUserid(id);
		user.setUserpwd(pw);
		user.setUserinfo(info);

		TeacherVO tv = new TeacherVO();
		tv.setUser_id(id);
		tv.setUser_info(info);
		tv.setTeacher_name(name);
		tv.setTeacher_phone(tel);

		System.out.println("add 시작");

		int row = 0;
		row = service.addUser(user);
		// System.out.println(row);

		// transactionManager.commit(status);
		// 위에놈과 아랫놈이 분리되어야 해요!

		teacherservice.addTeacher(tv);

		System.out.println(user);
		System.out.println(tv);

		// validator 작성
		/*
		 * new UserValidator().validate(vo, errors); if (errors.hasErrors()) { return
		 * "user/user_write"; } int row = 0; row = service.addUser(vo); return
		 * "redirect:/user/list.do";
		 */

		try {
			out = response.getWriter();

			result = "회원가입 성공";
			out.print(result);
			out.flush();
			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	// driver 회원가입
	@RequestMapping(value = "/driver/add.do", method = RequestMethod.GET)
	public String addDriver() {
		System.out.println("get 들어는왔음 ");
		return null;
	}

	@RequestMapping(value = "/driver/add.do", method = RequestMethod.POST)
	public String addDriverProc(UserVO uservo, DriverVO drivervo, HttpServletRequest request,
			HttpServletResponse response) {

		// DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		// def.setName("HOHOHO");
		// def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

		// TransactionStatus status = transactionManager.getTransaction(def);

		System.out.println("들어는왔음 ");

		response.setContentType("text/plain; charset=UTF8");
		PrintWriter out;
			
		String driverlicense = request.getParameter("driverLicense");
		String carnum = request.getParameter("carNum");
		//String driverpicture = request.getParameter("driverPicture");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String date = request.getParameter("date");
		String info = request.getParameter("info");

		System.out.println(id);

		UserVO user = new UserVO();
		user.setUserid(id);
		user.setUserpwd(pw);
		user.setUserinfo(info);

		DriverVO dv = new DriverVO();
		dv.setUser_id(id);
		dv.setUser_info(info);
		dv.setDirver_name(name);
		dv.setDriver_phone(tel);
		dv.setDriver_license(driverlicense);
		dv.setCar_number(carnum);
		//dv.setDriver_img(driverpicture);

		System.out.println("add 시작");

		int row = 0;
		row = service.addUser(user);
		// System.out.println(row);

		// transactionManager.commit(status);
		// 위에놈과 아랫놈이 분리되어야 해요!

		driverservice.addDriver(dv);

		System.out.println(user);
		System.out.println(dv);

		// validator 작성
		/*
		 * new UserValidator().validate(vo, errors); if (errors.hasErrors()) { return
		 * "user/user_write"; } int row = 0; row = service.addUser(vo); return
		 * "redirect:/user/list.do";
		 */

		try {
			out = response.getWriter();

			result = "회원가입 성공";
			out.print(result);
			out.flush();
			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*
	// driver 회원가입
	@RequestMapping(value = "/driver/add.do", method = RequestMethod.GET)
	public String Driver_add() {

		return null;
	}

	@RequestMapping(value = "/driver/add.do", method = RequestMethod.POST)
	public String Driver_add(@RequestParam("file") MultipartFile file, @ModelAttribute("driver") DriverVO driver,
			HttpServletRequest request, HttpServletResponse response) {

		System.out.println("들어는왔음 ");

		response.setContentType("text/plain; charset=UTF8");
		PrintWriter out;

		String driverLicense = request.getParameter("driverLicense");
		String carNumber = request.getParameter("carNum");
		String driverPicture = request.getParameter("driverPicture");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String date = request.getParameter("date");
		String info = request.getParameter("info");

		//
		String detailpath = "/upload/" + id;

		// 클라이언트가 선택한 파일이름 불러옴
		String fileName = file.getOriginalFilename();

		// 절대경로
		String path = request.getRealPath(driverPicture); // upload폴더 만든거 , 실제 서비스가 되면 저장되는 폴더

		// 상대경로
		// String path1 = request.getSession();

		// 디렉토리 가져오기
		File destdir = new File(path);

		System.out.println(path);

		// 정확한경로의 설정및 확인방법은 다음과같으며...
		String realFolder = ""; // 파일경로를 알아보기위한 임시변수를 하나 만들고,
		String saveFolder = "filestorage"; // 파일저장 폴더명을 설정한 뒤에...
		String encType = "UTF-8"; // 인코딩방식도 함께 설정한 뒤,
		int maxSize = 100 * 1024 * 1024; // 파일 최대용량까지 지정해주자.(현재 100메가)
		// ServletContext context = getServletContext();
		// realFolder = context.getRealPath(saveFolder);
		System.out.println("the realpath is : " + realFolder); // file path

		File dir = new File(realFolder); // 디렉토리 위치 지정

		if (!destdir.exists()) {
			destdir.mkdirs(); // 디렉토리 존재하지 않는다면 생성
		}

		File f = new File(path + fileName);

		if (!file.isEmpty()) {
			boolean fileexists = destdir.exists(); // 파일 존재 유무 검사

			if (fileexists) { // 중복된 파일이 있다면
				UUID uuid = UUID.randomUUID();
				fileName = uuid.toString() + fileName;
				f = new File(path + fileName);
			}
		}
		// 파일 복사
		try {
			file.transferTo(f);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("완");

		/////////////////////////////////////////////////////
		UserVO uv = new UserVO();
		uv.setUserid(id);
		uv.setUserpwd(pw);
		uv.setUserinfo(info);

		DriverVO dv = new DriverVO();

		dv.setUser_id(id);
		dv.setUser_info(info);
		dv.setDirver_name(name);
		dv.setDriver_phone(tel);
		dv.setDriver_license(driverLicense);
		dv.setCar_number(carNumber);
		dv.setDriver_img(driverPicture);

		System.out.println("add 시작");

		service.addUser(uv);
		driverservice.addDriver(dv);

		System.out.println(uv);
		System.out.println(dv);

		// validator 작성
		  new UserValidator().validate(vo, errors); if (errors.hasErrors()) { return
		  "user/user_write"; } int row = 0; row = service.addUser(vo); return
		  "redirect:/user/list.do";
		 

		try {
			out = response.getWriter();

			result = "addDriverSucces";
			out.print(result);
			out.flush();
			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	*/
	
}


/*
 * 
 * 
 * 
 * @RequestMapping(value = "/clothes/cloth_add.do", method = RequestMethod.POST)
 * public String cloth_add(@RequestParam("file") MultipartFile
 * file, @ModelAttribute("cloth") ClothVO cloth, HttpServletRequest request) {
 * String fileName = file.getOriginalFilename(); // 클라이언트가 선택한 파일이름 불러옴
 * 
 * String kind = request.getParameter("kind"); UserVO user = (UserVO)
 * request.getSession().getAttribute("login"); String userid = user.getUserid();
 * String detailpath = "/upload/" + userid + "/" + kind + "/"; // 절대경로 String
 * path = request.getRealPath(detailpath); // upload폴더 만든거 , 실제 서비스가 되면 저장되는 폴더
 * // 상대경로 // String path1 = request.getSession();
 * 
 * File destdir = new File(path); // 디렉토리 가져오기 System.out.println(path);
 * 
 * if (!destdir.exists()) { destdir.mkdirs(); // 디렉토리 존재하지 않는다면 생성 }
 * 
 * File f = new File(path + fileName); // java.io.File -import 경로에 이이름으로
 * 
 * if (!file.isEmpty()) { boolean fileexists = f.exists(); // 파일 존재 유무 검사
 * 
 * if (fileexists) { // 중복된 파일이 있다면 UUID uuid = UUID.randomUUID(); fileName =
 * uuid.toString() + fileName; f = new File(path + fileName); } } // 파일 복사 try {
 * file.transferTo(f); } catch (Exception e) { e.printStackTrace(); }
 * 
 * System.out.println("완"); request.setAttribute("imgname", fileName);
 * cloth.setUserid(userid); cloth.setImgpath(detailpath);
 * cloth.setImgname(fileName);
 * 
 * clothservice.addCloth(cloth);
 * 
 * return "/clothes/cloth_add";
 * 
 * }
 * 
 */
