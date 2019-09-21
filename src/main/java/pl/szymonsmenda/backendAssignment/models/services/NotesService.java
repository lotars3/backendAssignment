package pl.szymonsmenda.backendAssignment.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szymonsmenda.backendAssignment.models.entites.NoteEntity;
import pl.szymonsmenda.backendAssignment.models.repositiories.NotesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NotesService implements INotesService {
    @Autowired
    private NotesRepository notesRepository;

    @Override
    public List<NoteEntity> getAllNotes() {
        return notesRepository.findAll();
    }

    @Override
    public Optional<NoteEntity> findById(long id) {
        return notesRepository.findById(id);
    }
    @Override
    public void saveNotes(NoteEntity noteEntity) {
        notesRepository.save(noteEntity);
    }

    @Override
    public void removeNoteById(long id) {
        notesRepository.deleteById(id);
    }

    @Override
    public boolean existsById(long id) {
        return notesRepository.existsById(id);
    }


}
