package pl.szymonsmenda.backendAssignment.models.services;

import pl.szymonsmenda.backendAssignment.models.entites.NoteEntity;

import java.util.Optional;

public interface INotesService {

    Iterable<NoteEntity> getAllNotes();

    Optional<NoteEntity> getOneNote(Long id);

    void saveNotes(NoteEntity noteEntity);

    void removeNoteById(long id);

    boolean existsById(long id);
}