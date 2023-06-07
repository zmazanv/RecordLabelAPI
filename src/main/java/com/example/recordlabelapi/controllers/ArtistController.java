package com.example.recordlabelapi.controllers;

import com.example.recordlabelapi.models.Artist;
import com.example.recordlabelapi.services.ArtistService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artists")
public class ArtistController {


    @Autowired
    private ArtistService artistService;


    @PostMapping
    public ResponseEntity<Void> addArtist(@RequestBody @Valid Artist artistToBeAdded) {
        this.artistService.addArtist(artistToBeAdded);
        return (new ResponseEntity<>(HttpStatus.CREATED));
    }

    @PutMapping("/{idOfArtistToUpdate}")
    public ResponseEntity<Void> updateArtist(@PathVariable Long idOfArtistToUpdate, @RequestBody @Valid Artist artistWithUpdates) {
        this.artistService.updateArtist(idOfArtistToUpdate, artistWithUpdates);
        return (new ResponseEntity<>(HttpStatus.OK));
    }

    @DeleteMapping("/{idOfArtistToDelete}")
    public ResponseEntity<Void> deleteArtist(@PathVariable Long idOfArtistToDelete) {
        this.artistService.deleteArtist(idOfArtistToDelete);
        return (new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @GetMapping
    public ResponseEntity<Iterable<Artist>> getAllArtists() {
        return (new ResponseEntity<>(this.artistService.getAllArtists(), HttpStatus.OK));
    }

    @GetMapping("/{idOfArtistToGet}")
    public ResponseEntity<Artist> getArtistById(@PathVariable Long idOfArtistToGet) {
        return (new ResponseEntity<>(this.artistService.getArtistById(idOfArtistToGet), HttpStatus.OK));
    }

    //@GetMapping("/search")
    //public ResponseEntity<Artist> getArtistByName(@RequestParam(value = "name", required = false) String nameOfArtistToGet) {
    //    return (new ResponseEntity<>(this.artistService.getArtistByName(nameOfArtistToGet), HttpStatus.OK));
    //}
    @GetMapping("/search")
    public ResponseEntity<Artist> getArtistByName(@RequestParam(value = "name") String nameOfArtistToGet) {
        return (new ResponseEntity<>(this.artistService.getArtistByName(nameOfArtistToGet), HttpStatus.OK));
    }
}
