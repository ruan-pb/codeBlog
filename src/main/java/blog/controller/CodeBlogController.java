package blog.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import blog.model.Post;
import blog.services.PostService;

@Controller
public class CodeBlogController {
	
	@Autowired
	PostService codeBlogService;
	
	
	@RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping(value="/posts", method=RequestMethod.GET)
    public ModelAndView getPosts(){
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = codeBlogService.findAll();
        mv.addObject("posts", posts);
        return mv;
    }
	@RequestMapping(value = "/posts/{id}",method = RequestMethod.GET)
	public ModelAndView getPostDetails(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("postDetails");
		Post post = codeBlogService.findById(id);
		mv.addObject("post", post);
		return mv;
	}
	@RequestMapping(value = "/newpost",method = RequestMethod.GET)
	public String getPostForm() {
		return "postForm";
	}
	
	@RequestMapping(value = "/newpost",method = RequestMethod.POST)
	public String savePost(@Valid Post post,BindingResult result,RedirectAttributes attributes ) {
		if(result.hasErrors()) {
			 attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
			return "redirect:/newpost";
		}
		post.setData(LocalDate.now());
		codeBlogService.save(post);
		return "redirect:/posts";
		
		
	}
	
	
	
	

}
