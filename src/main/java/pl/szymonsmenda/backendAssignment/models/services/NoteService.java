package pl.szymonsmenda.backendAssignment.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szymonsmenda.backendAssignment.models.entity.NoteEntity;
import pl.szymonsmenda.backendAssignment.models.repositiories.NoteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService implements INoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<NoteEntity> getAllNote() {
        return noteRepository.findAll();
    }

    @Override
    public Optional<NoteEntity> findNoteById(long id) {
        return noteRepository.findById(id);
    }

    @Override
    public void saveNotes(NoteEntity noteEntity) {
        noteRepository.save(noteEntity);
    }

    @Override
    public void removeNoteById(long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public boolean existsById(long id) {
        return noteRepository.existsById(id);
    }


}
