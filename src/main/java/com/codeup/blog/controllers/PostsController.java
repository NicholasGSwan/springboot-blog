package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import com.codeup.blog.repositories.UsersRepository;
import com.codeup.blog.services.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class PostsController {
    private final PostSvc postSvc;
    private final UsersRepository usersDao;

    @Autowired
    public PostsController(PostSvc postSvc,UsersRepository usersDao){
        this.postSvc = postSvc;
        this.usersDao = usersDao;
    }

    @GetMapping("/posts")
    public String postsIndex(Model viewModel){
        viewModel.addAttribute("posts", postSvc.findAll());
        viewModel.addAttribute("users", usersDao.findAll());
        return "posts/index";



    }


    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable String id, Model viewModel){
        viewModel.addAttribute("postId", id);
        Post singlePost = postSvc.findOne(Long.parseLong(id));
        viewModel.addAttribute("post", singlePost);
        viewModel.addAttribute("user", usersDao.findOne(singlePost.getUser().getId()));

        return "posts/show";
    }


    @GetMapping("/posts/create")
    public String showCreatePostForm(Model viewModel){
        viewModel.addAttribute("post", new Post());
        return "posts/create";
    }


    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post){
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        post.setUser(user);
        postSvc.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditPostForm(Model viewModel,@PathVariable long id){
        viewModel.addAttribute("post",postSvc.findOne(id));
        return "posts/edit";
    }
    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post post){
        postSvc.save(post);
        return "redirect:/posts";
    }
    @GetMapping("/posts/{id}/delete")
    public String showDeletePostForm(Model viewModel,@PathVariable long id){
        viewModel.addAttribute("post", postSvc.findOne(id));
        return "posts/delete";
    }
    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable Long id){

        postSvc.delete(postSvc.findOne(id));
        return "redirect:/posts";
    }
//    @GetMapping("/posts/{id}/delete/confirm")
//    public String deletePost(@PathVariable long id){
//        postSvc.delete(postSvc.findOne(id));
//        return "redirect:/posts";
//    }
}
