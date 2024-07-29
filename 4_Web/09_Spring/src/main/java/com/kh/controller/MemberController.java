package com.kh.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.dao.MemberDAO;
import com.kh.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO dao;
	
	@GetMapping("register")
	public void register() {}

    @PostMapping("register")
    public String register(Member vo) {
    	try {
			dao.register(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return "redirect:/";
    }
  
}
