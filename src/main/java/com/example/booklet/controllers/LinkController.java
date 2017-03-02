package com.example.booklet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.booklet.models.Link;
import com.example.booklet.repositories.LinkRepository;

@RestController
@RequestMapping("/links")
public class LinkController {

    private static LinkRepository repo;

    @Autowired
    public LinkController(LinkRepository repo) {
	LinkController.repo = repo;
    }
    
    @GetMapping
    public List<Link> index() {
	return (List<Link>) repo.findAll();
    }
    
    @GetMapping("/{link}")
    public Link show(@PathVariable String link) {
	return (Link) repo.findOne(link);
    }

    @PostMapping
    public void create(@RequestParam(value = "link", required = true) String link,
	    @RequestParam(value = "long_link", required = true) String long_link) {
	Link new_link = new Link(link, long_link);
	repo.save(new_link);
    }
}
