package cs.dit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cs.dit.domain.BoardVO;
import cs.dit.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/")
@Log4j
public class BoardController {
	
	private final BoardService service;

	@GetMapping("/list")
	public void list(Model model) {
		log.info("list.................");
		model.addAttribute("list", service.getList());
	}
	
	@GetMapping({"/get", "/modify"})
	public void getOne(@RequestParam("bno") Long bno, Model model) {
		log.info("get.................");
		model.addAttribute("board", service.get(bno));
	}
	
	@GetMapping("/register")
	public void registerGET() {
		
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register : " + board);
		
		int count = service.register(board);
		
		if(count==1)
			rttr.addFlashAttribute("result", "registered");//한번만 사용하는 값을 보냄
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("modify : " + board);
		
		int count = service.modify(board);
		
		if(count==1)
			rttr.addFlashAttribute("result", "modified");
		
		return "redirect:/board/list";
	}	
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("remove : " + bno);
		
		int count = service.remove(bno);
		
		if(count==1) 
			rttr.addFlashAttribute("result", "removed");
		
		return "redirect:/board/list";
	}		
	
}