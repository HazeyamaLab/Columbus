package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.domain.Picture;

public interface PictureRepository extends JpaRepository<Picture, String>{

}
