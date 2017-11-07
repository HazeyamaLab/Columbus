package com.example.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.PictureRepository;

import com.example.domain.Picture;
import java.util.List;

@Service
public class PictureService {
	@Autowired PictureRepository pictureRepository;
	
	public List<Picture> findALL(){
		return pictureRepository.findAll();
	}
	
	public Picture findOne(String id) {
		return pictureRepository.findOne(id);
	}
	
	public Picture create(Picture picture) {
		return pictureRepository.save(picture);
	}
	
	public Picture update(Picture picture) {
		return pictureRepository.save(picture);
	}
	
	public void delete(Picture picture){
		pictureRepository.delete(picture);
	}
}
