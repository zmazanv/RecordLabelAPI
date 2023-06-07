package com.example.recordlabelapi.services;

import com.example.recordlabelapi.exceptions.ResourceNotFoundException;
import com.example.recordlabelapi.models.Artist;
import com.example.recordlabelapi.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {


    @Autowired
    private ArtistRepository artistRepository;


    protected void verifyArtistExists(Long idOfArtistToVerify) throws ResourceNotFoundException {
        if (!(this.artistRepository.existsById(idOfArtistToVerify))) {
            throw (new ResourceNotFoundException("Artist with ID " + idOfArtistToVerify + " not found"));
        }
    }


    public void addArtist(Artist artistToBeAdded) {
        this.artistRepository.save(artistToBeAdded);
    }

    public void updateArtist(Long idOfArtistToUpdate, Artist artistWithUpdates) throws ResourceNotFoundException {
        this.verifyArtistExists(idOfArtistToUpdate);
        Artist artistToUpdate = this.artistRepository.findById(idOfArtistToUpdate).get();
        artistToUpdate.setName(artistWithUpdates.getName());
        this.artistRepository.save(artistToUpdate);
    }

    public void deleteArtist(Long idOfArtistToDelete) {
        this.verifyArtistExists(idOfArtistToDelete);
        this.artistRepository.deleteById(idOfArtistToDelete);
    }

    public Iterable<Artist> getAllArtists() {
        return this.artistRepository.findAll();
    }

    public Artist getArtistById (Long idOfArtistToGet) {
        this.verifyArtistExists(idOfArtistToGet);
        return this.artistRepository.findById(idOfArtistToGet).get();
    }
}
