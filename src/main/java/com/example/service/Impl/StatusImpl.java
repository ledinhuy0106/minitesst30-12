package com.example.service.Impl;

import com.example.model.Status;
import com.example.repository.StatusRepository;
import com.example.service.interf.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatusImpl implements IStatusService {
    @Autowired
    StatusRepository statusRepository;

    @Override
    public Iterable<Status> findAll() {
        return statusRepository.findAll();
    }

    @Override
    public Optional<Status> findById(Long id) {
        return statusRepository.findById(id);
    }

    @Override
    public void save(Status status) {
        statusRepository.save(status);
    }

    @Override
    public void remove(Long id) {
     statusRepository.deleteById(id);
    }
}
