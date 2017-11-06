package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
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

    @GetMapping("/posts")
    public String postsIndex(Model viewModel){
        Post firstPost = new Post("First Post", "This is the first Post");
        Post secondPost = new Post("Second Post", "this is the second post.");
        List<Post> posts = new ArrayList<>();
        posts.add(firstPost);
        posts.add(secondPost);
        viewModel.addAttribute("posts", posts);
        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable String id, Model viewModel){
        viewModel.addAttribute("postId", id);
        Post singlePost = new Post("The title of the post", "this is the body of the post.  I'm showing the body of the post right here, it's a pretty good post");
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
