package com.example.booklet.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash("links")
public class Link {
	
    public @Id String id;
    public @Indexed String link;
    public String long_link;
    
    public Link(String link, String long_link) {
    	this.link = link;
    	this.long_link = long_link;
    }
}
