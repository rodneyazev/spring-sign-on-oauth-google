package com.spring.app.controller;

import java.util.LinkedHashMap;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSecurityController {
	
	@GetMapping("/test1")
	public String test1() {
		return "Test 1";
	}
	
	@GetMapping("/test2")
	public String test2(Model model) {
		Object details = ((UsernamePasswordAuthenticationToken) ((OAuth2Authentication) ((SecurityContextImpl) SecurityContextHolder.getContext()).getAuthentication()).getUserAuthentication()).getDetails();
        String name = ((LinkedHashMap) details).values().toArray()[1].toString();
        String picture = ((LinkedHashMap) details).values().toArray()[4].toString();
        String email = ((LinkedHashMap) details).values().toArray()[5].toString();

		model.addAttribute("name", name);
        model.addAttribute("picture", picture);
        model.addAttribute("email", email);
        
        System.out.println(model.getAttribute("name"));
        System.out.println(model.getAttribute("picture"));
        System.out.println(model.getAttribute("email"));
        return "rod";
	}

}
