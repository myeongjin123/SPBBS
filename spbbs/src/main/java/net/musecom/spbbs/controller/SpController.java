package net.musecom.spbbs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.musecom.spbbs.command.SpCommand;
import net.musecom.spbbs.command.SpDetailCommand;
import net.musecom.spbbs.command.SpListCommand;
import net.musecom.spbbs.command.SpModifyCommand;
import net.musecom.spbbs.command.SpModifyokCommand;
import net.musecom.spbbs.command.SpReplyCommand;
import net.musecom.spbbs.command.SpReplyokCommand;
import net.musecom.spbbs.command.SpWriteCommand;

@Controller
public class SpController {
	
	//모든 command가 갖고 있는 인터페이스 타입을 선언
	SpCommand command;
  
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()실행");
		
		command = new SpListCommand();
		command.execute(model);
		
	    return "list";
	}
	
	@RequestMapping("/detail")
	public String detail(HttpServletRequest request, Model model) {
		System.out.println("detail()");
		
		model.addAttribute("request", request);
		command = new SpDetailCommand();
		command.execute(model);
		return "detail";
	}
	
	@RequestMapping("/write")
	public String write(Model model) {
		System.out.println("wirte()");
		return "write";
	}
	
	@RequestMapping(value = "/writeok", method = RequestMethod.POST)
	public String wirteok(HttpServletRequest request, Model model) {
		System.out.println("writeok");
		
		model.addAttribute("request", request);
		command = new SpWriteCommand();
		command.execute(model);
		
		return "redirect:list";
		
	}
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply()");
		
		model.addAttribute("request", request);
		command = new SpReplyCommand();
		command.execute(model);
		return "reply";
	}
	@RequestMapping(value="/replyok", method = RequestMethod.POST)
	public String replyok(HttpServletRequest request, Model model) {
		System.out.println("replyok()");
		
		model.addAttribute("request", request);
		command = new SpReplyokCommand();
		command.execute(model);
		return "redirect:list";
	}
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify()");
		
		model.addAttribute("request", request);
		command = new SpModifyCommand();
		command.execute(model);
		return "modify";
	}
	@RequestMapping(value="/modifyok", method = RequestMethod.POST)
	public String modifyok(HttpServletRequest request, Model model) {
		System.out.println("modifyok()");
		
		model.addAttribute("request", request);
		command = new SpModifyokCommand();
		command.execute(model);
		return "redirect:list";
	}
}













