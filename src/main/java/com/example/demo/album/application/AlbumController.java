package com.example.demo.album.application;

import com.example.demo.album.domain.Album;
import com.example.demo.album.domain.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @PostMapping
    public ResponseEntity<Object> crear(@RequestBody Album album){
        String uri= albumService.create(album);
        return ResponseEntity.created(URI.create(uri)).body(uri);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> leer(@PathVariable int id){
        return ResponseEntity.ok(albumService.leer(id));
    }


}
