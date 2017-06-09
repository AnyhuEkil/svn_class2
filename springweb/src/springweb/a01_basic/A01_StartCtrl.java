package springweb.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.z01_dto.Exam;
import springweb.z01_dto.Member;

// 메모리에 로딩하기
// 1. 각 클래스 선언위에 annotation으로  Controller 선언
// 2. dispather.xml에 xml등록 방식으로 bean 등록
// springweb.a01_basic.A01_StartCtrl
@Controller
public class A01_StartCtrl {
	// http://localhost:6080/springweb/start.do
	// 호출될 메서드.. annotation으로 RequestMapping("마지막 호출명")
	
	@RequestMapping("/start.do")
	public String start(){
//		1. 요청값..
//		2. business login 처리 (service를 통해서 model)
//		3. view단 호출..
		return "a01_basic/a01_start"; //화면단 호출..
	}
	// http://localhost:6080/springweb/sendForw.do?id=himan&pass=7777
	@RequestMapping("/sendForw.do")
	public String sendForw(Member mem, Model d){
//		1. 요청값 처리..
		System.out.println(mem.getId()+":"+mem.getPass());
//		2. 모델데이터 처리
//		   msg  "id @@@ 이고, password @@@ 입니다!!"
		d.addAttribute("msg", "id "+mem.getId()+" 이고, password "+
				mem.getPass()+" 입니다!!");
		// view단 : ${msg}
		return "a01_basic/a02_send";
	}
	// 로그인 초기 화면..http://localhost:6080/springweb/login.do
	@RequestMapping("/login.do")
	public String login(){
		return "a01_basic/a03_login";
	}
	// 로그인 체크 처리  http://localhost:6080/springweb/loginck.do
	@RequestMapping("/loginck.do")
	public String loginck(Member mem, Model d){
		String page="a03_login";
		d.addAttribute("msg", mem.getId()+"는 인증된 아이디가 아닙니다!");
		if(mem.getId().equals("himan")&&mem.getPass().equals("7777")){
			page="a04_login_succ";
			d.addAttribute("msg", mem.getId()+"님 어서오세요!!");
		}
		return "a01_basic/"+page;
	}
	@RequestMapping("/exam.do")
	public String exam(Model d){
		Exam mem = new Exam();
		mem.setNum01((int)(Math.random()*10));
		mem.setNum02((int)(Math.random()*10));
		d.addAttribute("exam", mem);
		
		return "a01_basic/a05_exam";
	}
	// 로그인 체크 처리  http://localhost:6080/springweb/examck.do
	@RequestMapping("/examck.do")
	public String examck(Exam mem, Model d){
		String page="a05_exam";
		d.addAttribute("msg", "오답입니다.");
		if((mem.getNum01()+mem.getNum02())==mem.getInputdata()){
			page="a06_pass";
			d.addAttribute("msg","pass");
		}
		return "a01_basic/"+page;
	}	

}










