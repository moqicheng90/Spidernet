package com.wits.mqc.entinfo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wits.mqc.entinfo.entity.EntInfo;
import com.wits.mqc.entinfo.service.EntInfoService;

@Controller
@RequestMapping("/EntInfoController/")
public class QueryEntInfoController {
	
	@Autowired
	private EntInfoService entInfoService;
	
	@RequestMapping("queryEntInfo.do")
	@ResponseBody
	public EntInfo queryEntInfo(HttpServletRequest request){
		
		String entName = request.getParameter("entName");
		
		return entInfoService.queryEntInfo(entName);
		
	}

}
