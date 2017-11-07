package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.services.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/posts/create")
    public String showCreatePostForm(Model viewModel){
        viewModel.addAttribute("post", new Post());
        return "posts/create";
    }


    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post){
        postSvc.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditPostForm(Model viewModel,@PathVariable long id){
        viewModel.addAttribute(postSvc.findOne(id));
        return "posts/edit";
    }
}
