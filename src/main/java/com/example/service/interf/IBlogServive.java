package com.example.service.interf;

import com.example.model.Blog;
import com.example.model.Status;

public interface IBlogServive extends IGeneralService<Blog> {
    Iterable<Blog> findAllByStatus(Status status);
}
