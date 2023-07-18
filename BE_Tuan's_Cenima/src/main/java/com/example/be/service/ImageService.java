package com.example.be.service;

import com.example.be.entity.Image;
import com.example.be.entity.Trailer;
import org.springframework.data.domain.Page;

public interface ImageService {

    Page<Image> getAll(int pageNumber);

    Image getOneById(Long id);

    Object saveOrUpdate(Image image);

}
