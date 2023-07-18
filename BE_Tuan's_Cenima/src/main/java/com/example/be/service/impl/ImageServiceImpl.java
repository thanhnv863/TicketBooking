package com.example.be.service.impl;

import com.example.be.entity.Image;
import com.example.be.entity.Trailer;
import com.example.be.repository.ImageRepository;
import com.example.be.repository.TrailerRepository;
import com.example.be.service.ImageService;
import com.example.be.service.TrailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;


    @Override
    public Page<Image> getAll(int pageNumber) {

        Pageable pageable = PageRequest.of(pageNumber, 15);

        return imageRepository.findAll(pageable);
    }

    @Override
    public Image getOneById(Long id) {
        return imageRepository.findById(id).get();
    }

    @Override
    public Image saveOrUpdate(Image image) {
        return imageRepository.save(image);
    }
}
