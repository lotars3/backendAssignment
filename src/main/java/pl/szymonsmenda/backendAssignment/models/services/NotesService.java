package pl.szymonsmenda.backendAssignment.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szymonsmenda.backendAssignment.models.entites.NoteEntity;
import pl.szymonsmenda.backendAssignment.models.repositiories.NotesRepository;

import java.util.Optional;

@Service
public class NotesService implements INotesService {
    @Autowired
    private NotesRepository NotesRepository;

    @Override
    public Iterable<NoteEntity> getAllNotes() {
        return NotesRepository.findAll();
    }

    @Override
    public Optional<NoteEntity> getOneNote(Long id) {
        return NotesRepository.findById(id);
    }

    @Override
    public void saveNotes(NoteEntity noteEntity) {
        NotesRepository.save(noteEntity);
    }

    @Override
    public void removeNoteById(long id) {
        NotesRepository.deleteById(id);
    }

    @Override
    public boolean existsById(long id) {
        return NotesRepository.existsById(id);
    }
}
