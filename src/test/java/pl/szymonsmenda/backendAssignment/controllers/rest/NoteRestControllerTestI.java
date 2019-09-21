package pl.szymonsmenda.backendAssignment.controllers.rest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.szymonsmenda.backendAssignment.BackendAssignmentApplication;
import pl.szymonsmenda.backendAssignment.models.entites.NoteEntity;
import pl.szymonsmenda.backendAssignment.models.services.NotesService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = BackendAssignmentApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NoteRestControllerTestI {
    @Mock
    private NoteEntity testNote;
    @Mock
    private NotesService notesService;
    @InjectMocks
    private  NoteRestController noteRestController;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeAll
    public void init() {
        testNote = new NoteEntity("TestTitle", "TestContent");
    }

    @Test
    public void findAllNote(){
        ResponseEntity<NoteEntity> result = this.restTemplate
                .getForEntity(getRootUrl() + "/rest/all/", NoteEntity.class);

            assertThat(result.getStatusCode(),equalTo(HttpStatus.OK));
            assertThat(result.getBody(), is(notNullValue()));
    }

    @Test
    public void updateTest() {

        HttpEntity<NoteEntity> request = new HttpEntity<>(testNote);
        ResponseEntity<NoteEntity> response = restTemplate.postForEntity(getRootUrl()+"/rest/updateNote/", request, NoteEntity.class);

        long id = response.getBody().getId();

        request = new HttpEntity<NoteEntity>(testNote);
        response = restTemplate.exchange(getRootUrl()+"/rest/updateNote/"+id, HttpMethod.PUT, request, NoteEntity.class);

        assertThat(response.getBody().getContent(), is("TestContent"));
        assertThat(response.getBody().getId(), is(id));
        restTemplate.delete(getRootUrl() +"/rest/updateNote/\""+id);
    }

    @Test
    public void findByIDTest() {

        HttpEntity<NoteEntity> request = new HttpEntity<>(testNote);
        ResponseEntity<NoteEntity> response = restTemplate.postForEntity(getRootUrl()+"/rest/note/", request, NoteEntity.class);

        long id = response.getBody().getId();

        response = restTemplate.getForEntity(getRootUrl()+"/rest/note/"+id, NoteEntity.class);

        assertThat(response.getBody().getId(), is(id));
        assertThat(response.getBody().getTitle(), equalTo(testNote.getTitle()));
        restTemplate.delete(getRootUrl()+"/rest/note/"+id);
    }

    @Test
    public void deleteByIDTestIT() {

        HttpEntity<NoteEntity> request = new HttpEntity<>(testNote);
        ResponseEntity<NoteEntity> response = restTemplate.postForEntity(getRootUrl()+"/rest/remove/", request, NoteEntity.class);

        long id = response.getBody().getId();

        restTemplate.delete(getRootUrl()+"/rest/remove/"+id);
        response = restTemplate.getForEntity(getRootUrl()+"/rest/remove/"+id, NoteEntity.class);

        assertThat(response.getBody(), is(nullValue()));

    }
}