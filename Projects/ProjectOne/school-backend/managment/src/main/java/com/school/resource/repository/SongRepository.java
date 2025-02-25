package com.school.resource.repository;

import com.school.resource.model.audio.Song;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface SongRepository extends JpaRepository<Song, Long> {
    Optional<Song> findByName(String name);
}
