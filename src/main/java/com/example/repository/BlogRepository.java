package com.example.repository;


import com.example.model.Blog;
import com.example.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {
    Iterable<Blog> findAllByStatus(Status status);
}
