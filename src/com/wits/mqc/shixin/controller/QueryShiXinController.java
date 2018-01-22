package com.wits.mqc.shixin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wits.mqc.shixin.service.ShixinService;

@Controller
@RequestMapping("/ShiXinController/")
public class QueryShiXinController {
	
	@Autowired
	private ShixinService shixinService;
	
	@RequestMapping("image.do")
	@ResponseBody
	public Map<String,String> getImageInfo(HttpServletRequest request){
		
		return shixinService.getImage(request.getRealPath(""));
	}
	
	@RequestMapping("newImage.do")
	@ResponseBody
	public void getNewImage(HttpServletRequest request){
		
		shixinService.refreshImage(request.getRealPath(""), request.getParameter("captchaId"));
	}
	
	
	@RequestMapping("shixinInfos.do")
	@ResponseBody
	public String queryShixinInfos(HttpServletRequest request){
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("pName", request.getParameter("pname"));
		map.put("pCode", request.getParameter("pcode"));
		map.put("captchaId", request.getParameter("captchaId"));
		return shixinService.ShixinDataList(map);
	}
	
	@RequestMapping("shixinInfosByPage.do")
	@ResponseBody
	public String queryShixinInfosByPage(HttpServletRequest request){
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("pName", request.getParameter("pname"));
		map.put("pCode", request.getParameter("pcode"));
		map.put("captchaId", request.getParameter("captchaId"));
		map.put("currentPage", request.getParameter("currentPage"));
		return shixinService.ShixinDataList(map);
	}
	
	/**
	 * 查询本地数据库的失信人列表
	 * @param request
	 * @return
	 */
	@RequestMapping("shixinInfosLocal.do")
	@ResponseBody
	public String queryShixinInfosLocal(HttpServletRequest request){
		
		return shixinService.ShixinDataListLocal(request.getParameter("pname"),request.getParameter("currentPage"));
	}
	
	@RequestMapping("shixinDetail.do")
	@ResponseBody
	public String queryShixinDetail(HttpServletRequest request){
		
		String id = request.getParameter("id");
		String pCode = request.getParameter("pcode");
		String captchaId = request.getParameter("captchaId");
		
		return shixinService.ShixinDetail(id, pCode, captchaId);
		
	}

}
