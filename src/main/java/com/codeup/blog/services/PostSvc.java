package com.codeup.blog.services;

import com.codeup.blog.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("postSvc")
public class PostSvc {
    private List<Post> posts = new ArrayList<>();

    public PostSvc(){
        createPosts();
    }

    public List<Post> findAll(){
        return posts;
    }

    public Post findOne(long id){
        return posts.get((int)id - 1);
    }
    public Post save(Post post){
        posts.add(post);
        return post;
    }

    private void createPosts(){
        this.save(new Post("Post one", "this is the first post that createPosts makes."));
        this.save(new Post("Post two", "this is the second post that createPosts makes."));
        this.save(new Post("Post three", "this is the second post that createPosts makes."));
    }

}
