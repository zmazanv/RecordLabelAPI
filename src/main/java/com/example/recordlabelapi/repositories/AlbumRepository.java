package com.example.recordlabelapi.repositories;

import com.example.recordlabelapi.models.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {

    public Iterable<Album> findAllAlbumsByArtistId(Long artistId);
}
