package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.services.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class PostsController {
    private final PostSvc postSvc;

    @Autowired
    public PostsController(PostSvc postSvc){
        this.postSvc = postSvc;
    }

    @GetMapping("/posts")
    public String postsIndex(Model viewModel){

        List<Post> posts = postSvc.findAll();
        viewModel.addAttribute("posts", posts);
        return "posts/index";



    }


    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable String id, Model viewModel){
        viewModel.addAttribute("postId", id);
        Post singlePost = postSvc.findOne(Long.parseLong(id));
        viewModel.addAttribute("post", singlePost);

        return "posts/show";
    }

    @ResponseBody
    @GetMapping("/posts/create")
    public String createPostForm(){
        return "view the form for creating a post";
    }


    @ResponseBody
    @PostMapping("/posts/create")
    public String createPost(){
        return "create a new post";
    }
}
