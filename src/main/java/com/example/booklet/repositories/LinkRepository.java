package com.example.booklet.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.booklet.models.Link;

public interface LinkRepository extends CrudRepository<Link, String> {
}
