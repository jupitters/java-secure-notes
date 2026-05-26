package com.jupitters.secure_notes.repository;

import com.jupitters.secure_notes.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
