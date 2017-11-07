package com.codeup.blog.services;

import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostsRepository;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("postSvc")
public class PostSvc {
    private final PostsRepository postsDao;

    @Autowired
    public PostSvc(PostsRepository postsDao){
        this.postsDao = postsDao;
//        createPosts();
    }

    public Iterable<Post> findAll(){
        return postsDao.findAll();
    }

    public Post findOne(long id){
        return postsDao.findOne(id);
    }

    public Post save(Post post){

        return postsDao.save(post);
    }

    public void delete(Post post){
        postsDao.delete(post);
    }



//    private void createPosts(){
//        this.save(new Post("Post one", "this is the first post that createPosts makes."));
//        this.save(new Post("Post two", "this is the second post that createPosts makes."));
//        this.save(new Post("Post three", "this is the second post that createPosts makes."));
//    }

}
