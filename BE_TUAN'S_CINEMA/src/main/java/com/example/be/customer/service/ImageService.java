package com.example.be.customer.service;

import com.example.be.entity.Image;
import com.example.be.entity.Trailer;

import java.util.List;

public interface ImageService {


    List<Image> getAll();

    void saveOrUpdate(Image image);

}
