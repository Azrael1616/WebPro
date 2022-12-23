package cs.dit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cs.dit.domain.SampleDto;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*") //기본 URL 경로 설정
@Log4j
public class SampleController {
	
	//기본 URL 경로에서 실행, 기본은 get방식, 리턴은 기본url로 이동
	@RequestMapping("")
	public void basic() {
		log.info("basic.........................");
	}
	
	//get방식, return type이 String, /sample/ex01.jsp로 이동
	@GetMapping("/ex01")
	public String ex01() {
		log.info("ex01 ...........................");
		
		return "/sample/ex01";
	}
	//get방식, 매개변수가 있음
	@GetMapping("/ex02")
	public String ex02(String name) {
		log.info("ex02 ...........................");
		log.info("name :" + name);
		
		return "/sample/ex02";
	}
	//get방식 가져오는 매개변수이름과 다를 때 @RequestParam() 사용
	@GetMapping("/ex03")
	public void ex03(@RequestParam("id") String name) {
		log.info("ex03 ...........................");
		log.info("name :" + name);
		
	}	
	//화면까지 데이터가 전달되고 파라미터명을 변경하고자 할 때 @ModelAttribute() 사용
	@GetMapping("/ex04")
	public void ex04(@ModelAttribute("id") String name) {
		log.info("ex04 ...........................");
		log.info("name :" + name);
		
	}	
	@GetMapping("/ex05")
	public String ex05(String name) {
		log.info("ex05 ...........................");
		log.info("name :" + name);
		
		return "redirect:/";
	}	
	
	//객체를 매개변수로 가져올 때 
	@GetMapping("/ex06")
	public void ex06(SampleDto dto) {
		log.info("ex06 ...........................");
		log.info(dto.getName());
		log.info(dto.getAge());
		log.info(dto);
	}
	//Model 객체 사용
	@GetMapping("/ex07")
	public void ex07(Model model) {
		log.info("ex07 ...........................");
		
		model.addAttribute("serverTime", new java.util.Date());
	}	
	
	
}