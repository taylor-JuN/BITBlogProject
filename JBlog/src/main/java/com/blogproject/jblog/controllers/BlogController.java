package com.blogproject.jblog.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.blogproject.jblog.services.UserService;
import com.blogproject.jblog.vo.BlogVO;
import com.blogproject.jblog.vo.CategoryVO;
import com.blogproject.jblog.vo.CommentVO;
import com.blogproject.jblog.vo.PostVO;
import com.blogproject.jblog.vo.UserVO;

@RequestMapping("/")
@Controller
public class BlogController {
	
	private static Logger logger = LoggerFactory.getLogger(BlogController.class);
	@Autowired
	UserService userServiceImple;
	
	@Autowired
	FileUploadService fileUploadService;
	
	@Autowired
	BlogService blogServiceImple;
	
	@RequestMapping("{sitename}")
	public String view(@PathVariable("sitename") String id, Model model, HttpSession session) {
		BlogVO vo = blogServiceImple.getPage(id);
		System.out.println(vo);
		UserVO siteID= userServiceImple.getUser(id);  
		model.addAttribute("siteID", siteID);
		model.addAttribute("vo", vo);

		List<CommentVO> l = new ArrayList<>();
		
		List<PostVO> postThingsList= blogServiceImple.getPost(vo.getUserNo());
		
		if(!postThingsList.isEmpty()) {
			for(int i =0 ; i <1; i++) {
				l = blogServiceImple.getComment(postThingsList.get(i).getPostNo());
			}
			for(CommentVO e : l) {
				String x = userServiceImple.selectUserName(e.getUserNo());
				e.setUserName(x);
			}
			model.addAttribute("commentList", l);
			model.addAttribute("postThingsList", postThingsList);
		}
		
		
		List<CategoryVO> list = blogServiceImple.getCate(vo.getUserNo());
		model.addAttribute("cateThingsList", list);
		
		

		return "blog/home";
	}
	
	@RequestMapping(value = "{sitename}", method=RequestMethod.POST)
	public String viewAction(@PathVariable("sitename") String id, @RequestParam(value = "cateNo", required=false, defaultValue="") Long cateNo, HttpSession session,Model model) {
		System.out.println("----------------------" + cateNo);
		BlogVO vo = blogServiceImple.getPage(id);
		System.out.println(vo);
		model.addAttribute("vo", vo);
		
		UserVO siteID= userServiceImple.getUser(id);  
		model.addAttribute("siteID", siteID);
		
		List<PostVO> postThingsList= blogServiceImple.getPost(vo.getUserNo());
		List<PostVO> newList = new ArrayList<>();
		
		for(PostVO e : postThingsList) {
			System.out.println(e);
			if(e.getCateNo() == cateNo) {
				newList.add(e);
			}
		}
		
		List<CommentVO> l = new ArrayList<>();
		System.out.println(newList.toString());
		if(!newList.isEmpty()) {
			l = blogServiceImple.getComment(newList.get(0).getPostNo());
			for(CommentVO e : l) {
				String x = userServiceImple.selectUserName(e.getUserNo());
				e.setUserName(x);
			}
			model.addAttribute("commentList", l);
		}

		model.addAttribute("postThingsList", newList);
		List<CategoryVO> list = blogServiceImple.getCate(vo.getUserNo());
		model.addAttribute("cateThingsList", list);
		return "blog/home";
	}
	
	@RequestMapping(value = "{sitename}/insertcomment", method = RequestMethod.POST)
	public String commentAction(@ModelAttribute CommentVO updatedVO,@PathVariable("sitename") String id, Model model, HttpSession ssion) {
		boolean success = blogServiceImple.insertComment(updatedVO);
		UserVO siteID= userServiceImple.getUser(id);  
		model.addAttribute("siteID", siteID);
		
		if(success) {
			return "redirect:/{sitename}";
		}else {
			return "redirect:{sitename}";
		}
	}
	@RequestMapping(value = "{sitename}/deletecomment", method = RequestMethod.POST)
	public String deleteAction(@RequestParam("no") Long no,@PathVariable("sitename") String id, Model model, HttpSession session) {
		UserVO vo = (UserVO)session.getAttribute("authUser");
		model.addAttribute("authUser", vo);
		System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
		System.out.println(no);
		System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
		boolean success = blogServiceImple.deleteComment(no);
		
		if (success) {
			return "redirect:/{sitename}";
		}else {
			return "redirect:/";
		}
	}
	
	
		
	
	@RequestMapping("{sitename}/admin/basic")
	public String adminBasic(@PathVariable("sitename") String id, HttpSession session, Model model) {
		BlogVO vo = blogServiceImple.getBlogAdmin(id);
		model.addAttribute("vo", vo);
		UserVO siteID= userServiceImple.getUser(id);  
		model.addAttribute("siteID", siteID);
		
		UserVO authUser = (UserVO)session.getAttribute("authUser");
		if (authUser == null) {
			return "users/loginform";
		} else if (authUser.getUserNo() != vo.getUserNo()) {
			return "redirect:/";
		} else {
			return "blog/basic";
		}
	}
	
	@RequestMapping(value = "{sitename}/admin/update", method = RequestMethod.POST)
	public String basicAction(@ModelAttribute BlogVO updatedVO, @RequestParam("file") MultipartFile uploadfile, Model model) {
		BlogVO vo = blogServiceImple.getBlogAdmin(updatedVO.getUserNo());
		vo.setBlogTitle(updatedVO.getBlogTitle());
		
		System.out.println("-----------------------"+uploadfile.toString());
		
		if(!uploadfile.getOriginalFilename().equals("")) {
			String saveFileName = fileUploadService.store(uploadfile);
			String urlImage = "upload-images/" + saveFileName;
			
			vo.setLogoFile(urlImage);
		}
		
		
		boolean success = blogServiceImple.update(vo);
		
		if(success) {
			return "redirect:/{sitename}";
		}else {
			return "redirect:{sitename}/admin/basic";
		}

	}
	
	@RequestMapping("{sitename}/admin/category")
	public String adminCategory(@PathVariable("sitename") String id, HttpSession session, Model model) {
		UserVO authUser = (UserVO)session.getAttribute("authUser");
		BlogVO vo = blogServiceImple.getBlogAdmin(id);
		model.addAttribute("vo",vo);
		
		List<CategoryVO> list = blogServiceImple.getCate(authUser.getUserNo());
		
		
		for(CategoryVO e : list) {
			Long count = blogServiceImple.getPostCount(e.getCateNo());
			e.setPostCount(count);
		}
		model.addAttribute("list", list);
		
		
		return "blog/category";
	}
	
	@RequestMapping(value = "{sitename}/admin/category", method = RequestMethod.POST)
	public String categoryAction(@ModelAttribute CategoryVO insertVO, HttpSession session, Model model) {
		UserVO vo = (UserVO)session.getAttribute("authUser");
		model.addAttribute("authUser", vo);
		boolean success = blogServiceImple.insertCate(insertVO);

		return "redirect:/{sitename}/admin/category";
		
	}
	
	@RequestMapping(value = "{sitename}/admin/delete", method = RequestMethod.POST)
	public String deleteCategoryAction(@RequestParam("no") Long no, HttpSession session, Model model) {
		UserVO vo = (UserVO)session.getAttribute("authUser");
		model.addAttribute("authUser", vo);
		System.out.println("-------------------"+no);
		boolean success = blogServiceImple.deleteCate(no);
		
		if (success) {
			return "redirect:/{sitename}/admin/category";
		}else {
			return "redirect:/";
		}
		
		
		
	}
	
	@RequestMapping(value="{sitename}/admin/write", method=RequestMethod.GET)
	public String writeForm(@PathVariable("sitename") String id, HttpSession session, Model model) {
		
		UserVO authUser = (UserVO)session.getAttribute("authUser");
		BlogVO vo = blogServiceImple.getBlogAdmin(id);
		model.addAttribute("vo",vo);
		
		if (authUser == null) {
		
			return "redirect:/";
		}
		
		List<CategoryVO> list = blogServiceImple.getCate(authUser.getUserNo());
		model.addAttribute("list", list);
		
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
