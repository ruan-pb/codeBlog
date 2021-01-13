package blog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.exceptions.PostNotFoundException;
import blog.model.Post;
import blog.repositories.PostRepository;

@Service
public class PostService implements CodeBlogInterface {

	@Autowired
	private PostRepository postBD;

	@Override
	public List<Post> findAll() {
		return postBD.findAll();
	}

	@Override
	public Post findById(Long id) {
		Optional<Post> post = postBD.findById(id);
		Post postReturn;
		if (post.isPresent()) {
			postReturn = post.get();
		} else {
			throw new PostNotFoundException();
		}
		return postReturn;
	}

	@Override
	public Post save(Post post) {
		return postBD.save(post);
	}

}
