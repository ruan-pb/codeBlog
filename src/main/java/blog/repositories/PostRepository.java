package blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blog.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}
