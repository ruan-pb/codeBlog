package blog.services;

import java.util.List;

import blog.model.Post;

public interface CodeBlogInterface {
	
	List<Post>findAll();
	Post findById(Long id);
	Post save(Post post);

}
