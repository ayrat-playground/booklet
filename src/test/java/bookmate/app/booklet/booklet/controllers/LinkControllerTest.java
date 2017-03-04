package bookmate.app.booklet.booklet.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class LinkControllerTest {
  @Autowired
  private MockMvc mvc;

  @Test
  public void shouldCreateLink() throws Exception {
    mvc.perform(post("/links").param("link", "goog.le").param("longLink", "http://google.com"))
        .andExpect(status().isOk());
  }

  @Test
  public void shouldReturnAllLinks() throws Exception {
    mvc.perform(get("/links"))
        .andExpect(status().isOk());
  }
}