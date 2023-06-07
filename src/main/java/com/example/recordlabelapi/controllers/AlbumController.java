package com.example.recordlabelapi.controllers;

import com.example.recordlabelapi.models.Album;
import com.example.recordlabelapi.services.AlbumService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artists/{artistId}/albums")
public class AlbumController {


    @Autowired
    private AlbumService albumService;


    @PostMapping
    public ResponseEntity<Void> addAlbum(@PathVariable Long artistId, @RequestBody @Valid Album albumToBeAdded) {
        this.albumService.addAlbum(artistId, albumToBeAdded);
        return (new ResponseEntity<>(HttpStatus.CREATED));
    }

    @PutMapping("/{idOfAlbumToUpdate}")
    public ResponseEntity<Void> updateAlbum(@PathVariable Long artistId, @PathVariable Long idOfAlbumToUpdate, @RequestBody @Valid Album albumWithUpdates) {
        this.albumService.updateAlbum(artistId, idOfAlbumToUpdate, albumWithUpdates);
        return (new ResponseEntity<>(HttpStatus.OK));
    }

    @DeleteMapping("/{idOfAlbumToDelete}")
    public ResponseEntity<Void> deleteAlbum(@PathVariable Long artistId, @PathVariable Long idOfAlbumToDelete) {
        this.albumService.deleteAlbum(artistId, idOfAlbumToDelete);
        return (new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @GetMapping
    public ResponseEntity<Iterable<Album>> getAllAlbumsByArtistId(@PathVariable Long artistId) {
        return (new ResponseEntity<>(this.albumService.getAllAlbumsByArtistId(artistId), HttpStatus.OK));
    }

    @GetMapping("/{idOfAlbumToGet}")
    public ResponseEntity<Album> getAlbumById(@PathVariable Long artistId, @PathVariable Long idOfAlbumToGet) {
        return (new ResponseEntity<>(this.albumService.getAlbumById(artistId, idOfAlbumToGet), HttpStatus.OK));
    }
}
