package com.example.demo.album.domain;

import com.example.demo.album.infrastructure.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;


    public String create(Album album){
        albumRepository.save(album);
        return "/album/"+album.getId();
    }

    public Album leer(int id){
        return albumRepository.findById(id).orElseThrow();
    }


}
