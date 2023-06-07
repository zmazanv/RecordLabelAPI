package com.example.recordlabelapi.services;

import com.example.recordlabelapi.exceptions.ResourceNotFoundException;
import com.example.recordlabelapi.models.Album;
import com.example.recordlabelapi.repositories.AlbumRepository;
import com.example.recordlabelapi.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {


    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private ArtistService artistService;


    protected void verifyAlbumExists(Long idOfAlbumToVerify) throws ResourceNotFoundException {
        if (!(this.albumRepository.existsById(idOfAlbumToVerify))) {
            throw (new ResourceNotFoundException("Album with ID " + idOfAlbumToVerify + " not found"));
        }
    }


    public void addAlbum(Long artistId, Album albumToBeAdded) {
        this.artistService.verifyArtistExists(artistId);
        albumToBeAdded.setArtist(this.artistRepository.findById(artistId).get());
        this.albumRepository.save(albumToBeAdded);
    }

    public void updateAlbum(Long artistId, Long idOfAlbumToUpdate, Album albumWithUpdates) {
        this.artistService.verifyArtistExists(artistId);
        this.verifyAlbumExists(idOfAlbumToUpdate);
        Album albumToUpdate = this.albumRepository.findById(idOfAlbumToUpdate).get();
        albumToUpdate.setName(albumWithUpdates.getName());
        albumToUpdate.setReleaseYear(albumWithUpdates.getReleaseYear());
        albumToUpdate.setGenre(albumWithUpdates.getGenre());
        this.albumRepository.save(albumToUpdate);
    }

    public void deleteAlbum(Long artistId, Long idOfAlbumToDelete) {
        this.artistService.verifyArtistExists(artistId);
        this.verifyAlbumExists(idOfAlbumToDelete);
        this.albumRepository.deleteById(idOfAlbumToDelete);
    }

    public Iterable<Album> getAllAlbumsByArtistId(Long artistId) {
        this.artistService.verifyArtistExists(artistId);
        return this.albumRepository.findAllAlbumsByArtistId(artistId);
    }

    public Album getAlbumById(Long artistId, Long idOfAlbumToGet) {
        this.artistService.verifyArtistExists(artistId);
        this.verifyAlbumExists(idOfAlbumToGet);
        return this.albumRepository.findById(idOfAlbumToGet).get();
    }
}
