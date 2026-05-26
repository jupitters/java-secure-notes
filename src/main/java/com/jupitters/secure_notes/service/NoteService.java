package com.jupitters.secure_notes.service;

import com.jupitters.secure_notes.models.Note;

public interface NoteService {
    Note createNoteForUser(String username, String content);
}
