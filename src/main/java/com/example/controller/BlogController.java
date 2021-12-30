package com.example.controller;

import com.example.model.Blog;
import com.example.model.Status;
import com.example.service.Impl.BlogImpl;
import com.example.service.Impl.StatusImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/blogs")
public class BlogController {
    @Autowired
    BlogImpl blogimpl;
    @Autowired
    StatusImpl statusimpl;

    //
    @GetMapping("")
    public ResponseEntity<Iterable<Blog>> findAll(){
        Iterable<Blog> blogs= blogimpl.findAll();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    //5
    @PostMapping("")
    public ResponseEntity<Blog> create(@RequestBody Blog blog){
        blog.setTime(LocalDateTime.now());
        blogimpl.save(blog);
        return new ResponseEntity<>(blog,HttpStatus.CREATED);
    }

    //4
    @PutMapping("/{id}")
    public ResponseEntity<Blog> update(@PathVariable Long id,@RequestBody Blog blog){
        blog.setId(id);
        blog.setTime(LocalDateTime.now());
        blogimpl.save(blog);
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
    //3
    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> delete(@PathVariable Long id){
        blogimpl.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //2
    @GetMapping("/{id}")
    public ResponseEntity<Blog> detail(@PathVariable Long id){
        Optional<Blog> blog=blogimpl.findById(id);
        return new ResponseEntity<>(blog.get(),HttpStatus.OK);
    }
    //1
    @GetMapping("public/{id}")
    public ResponseEntity<Iterable<Blog>> Public(@PathVariable Long id){
        Optional<Status> status=statusimpl.findById(id);
        Iterable<Blog> blogs=blogimpl.findAllByStatus(status.get());
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
    @GetMapping("status/{id}")
    public ResponseEntity<Iterable<Blog>> findByStatus(@PathVariable Long id){
        Optional<Status> status=statusimpl.findById(id);
        Iterable<Blog> blogs=blogimpl.findAllByStatus(status.get());
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

}