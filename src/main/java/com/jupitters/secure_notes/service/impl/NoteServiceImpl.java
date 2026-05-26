package com.jupitters.secure_notes.service.impl;

import com.jupitters.secure_notes.models.Note;
import com.jupitters.secure_notes.repository.NoteRepository;
import com.jupitters.secure_notes.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;

    @Override
    public Note createNoteForUser(String username, String content){
        Note note = new Note();
        note.setContent(content);
        note.setOwnerUsername(username);

        return noteRepository.save(note);
    }
}
