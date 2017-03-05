package bookmate.app.booklet.controllers;

import static junit.framework.TestCase.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import bookmate.app.booklet.models.Link;
import bookmate.app.booklet.repositories.LinkRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LinkControllerTest {
  @Autowired
  private MockMvc mvc;

  @Autowired
  private LinkRepository repo;

  @Test
  public void shouldCreateLink() throws Exception {
    String shortLink = "goog.le";

    mvc.perform(post("/links").param("link", shortLink).param("longLink", "http://google.com"))
        .andExpect(status().isOk());

    Link link = repo.findOne(shortLink);
    assertFalse(link.equals(null));
  }

  @Test
  public void shouldShowLink() throws  Exception {
    String shortLink = "gle";
    String longLink = "google.com";
    Link newLink = new Link(shortLink, longLink);
    repo.save(newLink);

    mvc.perform(get("/links/" + shortLink))
        .andExpect(status().isOk());
  }

  @Test
  public void shouldReturnNotFoundStatus() throws  Exception {
    mvc.perform(get("/links/dontexist"))
        .andExpect(status().isNotFound());
  }

  @Test
  public void shouldReturnAllLinks() throws Exception {
    mvc.perform(get("/links"))
        .andExpect(status().isOk());
  }
}