package bookmate.app.booklet.booklet.controllers;

import bookmate.app.booklet.booklet.models.Link;
import bookmate.app.booklet.booklet.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/links")
public class LinkController {

  private final LinkRepository repo;

  @Autowired
  public LinkController(LinkRepository repo) {
    this.repo = repo;
  }

  @GetMapping
  public Iterable<Link> index() {
    return repo.findAll();
  }

  @GetMapping("/{link}")
  public Link show(@PathVariable String link) {
    return repo.findOne(link);
  }

  @PostMapping
  public void create(
      @RequestParam(value = "link") String link,
                     @RequestParam(value = "longLink") String longLink
  ) {
    Link newLink = new Link(link, longLink);
    repo.save(newLink);
  }
}
