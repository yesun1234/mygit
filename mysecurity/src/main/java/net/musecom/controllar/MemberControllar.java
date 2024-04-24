package net.musecom.controllar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberControllar {
	
	//濡쒓렇�씤 �럹�씠吏�
	@GetMapping("/home")
	public String home() {
		System.out.println("member/home �떎�뻾");
		return "home";
	}
	@GetMapping("/gallery")
	public String gallery() {
		System.out.println("member/gallery �떎�뻾");
		return "gallery";
	}
	@GetMapping("/bye")
	public String bye() {
		System.out.println("member/bye �떎�뻾");
		return "bye";
	}
}
