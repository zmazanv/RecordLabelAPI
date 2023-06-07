package com.example.recordlabelapi.repositories;

import com.example.recordlabelapi.models.Artist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Long> {}
