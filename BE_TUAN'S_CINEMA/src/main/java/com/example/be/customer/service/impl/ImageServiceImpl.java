package com.example.be.customer.service.impl;

import com.example.be.entity.Image;
import com.example.be.repository.ImageRepository;
import com.example.be.customer.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository repository;

    @Override
    public List<Image> getAll() {
        return repository.findAll();
    }

    @Override
    public void saveOrUpdate(Image image) {
        repository.save(image);
    }
}
