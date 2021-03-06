package springweb.d01_board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.d01_board.service.A01_BoardService;
import springweb.d01_board.vo.Board;
import springweb.d01_board.vo.Board_Sch;

@Controller
@RequestMapping("/boardList.do")
public class A01_BoardCtrl {
<<<<<<< .mine
	// 게시판 list
||||||| .r473
	// �Խ��� list
=======
	
	@Autowired(required=false)
	private A01_BoardService service;
	
	// �Խ��� list
>>>>>>> .r476
	// http://localhost:6080/springweb/boardList.do?method=list
	@RequestMapping(params="method=list")
	public String start(@ModelAttribute("empsch") Board_Sch sch,
							Model d){
//		if(sch.getSubject()!=null){
//			sch.setSubject(sch.getSubject()+"@");
//		}
		d.addAttribute("list", service.listBoard());
		return "d01_board/a01_boardList";
	}
	// ��� ȭ�� ȣ��..boardList.do?method=insert
	@RequestMapping(params="method=insert")
	public String insert(){
		
		return "d01_board/a02_insertBoard";
	}
	// boardList.do?method=insProc
	@RequestMapping(params="method=insProc")
	public String insertProc(Board ins){
		service.insertBoard(ins);
		// �����, ���� ��ȸȭ������ ó��..
		return "redirect:/boardList.do?method=list";
	}	

}
