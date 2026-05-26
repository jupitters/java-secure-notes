package com.jupitters.secure_notes.service;

import com.jupitters.secure_notes.models.Note;

public interface NoteService {
    Note createNoteForUser(String username, String content);
    Note updateNoteForUser(Long noteId, String username, String content);
    void deleteNoteForUser(Long noteId, String username);
}
