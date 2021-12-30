package com.example.service.Impl;

import com.example.model.Blog;
import com.example.model.Status;
import com.example.repository.BlogRepository;
import com.example.service.interf.IBlogServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogImpl implements IBlogServive {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Iterable<Blog> findAllByStatus(Status status) {
        return blogRepository.findAllByStatus(status);
    }
}
