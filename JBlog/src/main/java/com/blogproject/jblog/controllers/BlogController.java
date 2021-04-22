package com.blogproject.jblog.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.blogproject.jblog.services.BlogService;
import com.blogproject.jblog.services.FileUploadService;
import com.blogproject.jblog.vo.BlogVO;
import com.blogproject.jblog.vo.CategoryVO;
import com.blogproject.jblog.vo.PostVO;
import com.blogproject.jblog.vo.UserVO;

@RequestMapping("/")
@Controller
public class BlogController {
	
	@Autowired
	FileUploadService fileUploadService;
	
	@Autowired
	BlogService blogServiceImple;
	
	@RequestMapping("{sitename}")
	public String view(@PathVariable("sitename") String id, Model model, HttpSession session) {
		BlogVO vo = blogServiceImple.getPage(id);
		System.out.println(vo);
		model.addAttribute("vo", vo);
		
		List<PostVO> postThingsList= blogServiceImple.getPost(vo.getUserNo());
		
		model.addAttribute("postThingsList", postThingsList);
		List<CategoryVO> list = blogServiceImple.getCate(vo.getUserNo());
		model.addAttribute("cateThingsList", list);
		//	로그인 한 사용자 -> 작성 폼으로 포워드
		return "blog/home";
	}
	
	@RequestMapping(value = "{sitename}", method=RequestMethod.POST)
	public String loginAction(@PathVariable("sitename") String id, @RequestParam(value = "cateNo", required=false, defaultValue="") Long cateNo, HttpSession session,Model model) {
		System.out.println("----------------------" + cateNo);
		BlogVO vo = blogServiceImple.getPage(id);
		System.out.println(vo);
		model.addAttribute("vo", vo);
		
		List<PostVO> postThingsList= blogServiceImple.getPost(vo.getUserNo());
		List<PostVO> newList = new ArrayList<>();
		
		for(PostVO e : postThingsList) {
			System.out.println(e);
			if(e.getCateNo() == cateNo) {
				newList.add(e);
			}
		}
		
		model.addAttribute("postThingsList", newList);
		List<CategoryVO> list = blogServiceImple.getCate(vo.getUserNo());
		model.addAttribute("cateThingsList", list);
		return "blog/home";
	}
	
	
		
	
	@RequestMapping("{sitename}/admin/basic")
	public String adminBasic(@PathVariable("sitename") String id, HttpSession session, Model model) {
		BlogVO vo = blogServiceImple.getBlogAdmin(id);
		model.addAttribute("vo", vo);
		UserVO authUser = (UserVO)session.getAttribute("authUser");
		if (authUser == null) {
			return "redirect:/";
		} else if (authUser.getUserNo() != vo.getUserNo()) {	//	게시물 작성자가 아니면
			return "redirect:/";
		}
		
		return "blog/basic";
	}
	
	@RequestMapping(value = "{sitename}/admin/basic", method = RequestMethod.POST)
	public String basicAction(@ModelAttribute BlogVO updatedVO) {
		System.out.println("------------"+updatedVO.getUserNo());
		BlogVO vo = blogServiceImple.getBlogAdmin(updatedVO.getUserNo());
		vo.setBlogTitle(updatedVO.getBlogTitle());
		
		
		boolean success = blogServiceImple.update(vo);

		return "redirect:/{sitename}";
		
	}
	
	@RequestMapping("{sitename}/admin/category")
	public String adminCategory(@PathVariable("sitename") String id, HttpSession session, Model model) {
		UserVO authUser = (UserVO)session.getAttribute("authUser");
		BlogVO vo = blogServiceImple.getBlogAdmin(id);
		model.addAttribute("vo",vo);
		List<CategoryVO> list = blogServiceImple.getCate(authUser.getUserNo());
		model.addAttribute("list", list);
		
//		if (authUser == null) {
//			return "redirect:/";
//		} 
		
		return "blog/category";
	}
	
	@RequestMapping(value = "{sitename}/admin/category", method = RequestMethod.POST)
	public String categoryAction(@ModelAttribute CategoryVO insertVO, HttpSession session, Model model) {
		UserVO vo = (UserVO)session.getAttribute("authUser");
		model.addAttribute("authUser", vo);
		boolean success = blogServiceImple.insertCate(insertVO);

		return "redirect:/{sitename}";
		
	}
	
	@RequestMapping(value="{sitename}/admin/write", method=RequestMethod.GET)
	public String writeForm(@PathVariable("sitename") String id, HttpSession session, Model model) {
		//	사용자를 체크해서 로그인 안한 사용자는 쓰기 기능을 제한
		UserVO authUser = (UserVO)session.getAttribute("authUser");
		BlogVO vo = blogServiceImple.getBlogAdmin(id);
		model.addAttribute("vo",vo);
		//	로그인 여부 체크
		if (authUser == null) {
			//	로그인 안한 사용자
			return "redirect:/";
		}
		
		List<CategoryVO> list = blogServiceImple.getCate(authUser.getUserNo());
		model.addAttribute("list", list);
		//	로그인 한 사용자 -> 작성 폼으로 포워드
		return "blog/write";
	}
	
	@RequestMapping(value = "{sitename}/admin/write", method =RequestMethod.POST)
	public String writeAction(@ModelAttribute PostVO vo, HttpSession session, Model model) {
		UserVO authUser = (UserVO)session.getAttribute("authUser");
		if (authUser == null) {
			return "redirect:/{sitename}";
		}
					
		boolean success = blogServiceImple.write(vo);
	
		if(success) {
			return "redirect:/{sitename}";
		} else {
			return "redirect:/";
		}
	}
	
	
	@ResponseBody
	@RequestMapping("/show")
	public Object existEmail(
			@RequestParam(value = "no", required=false, defaultValue="") Long no){
		
		List<PostVO> list = blogServiceImple.getPost(no);

		Map<String, Object> map = new HashMap<>();
		
		map.put("data", list);
		
		return map;
	}
}
