package bookmate.app.booklet.controllers;

import bookmate.app.booklet.models.Link;
import bookmate.app.booklet.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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

  @GetMapping("/{shortLink}")
  public Link show(@PathVariable String shortLink) {
    Link link = repo.findOne(shortLink);
    
    if (link!=null) {
      return link;
    }
    else {
      throw new ResourceNotFoundException();
    }
  }

  @PostMapping
  public void create(
      @RequestParam(value = "link") String link,
                     @RequestParam(value = "longLink") String longLink
  ) {
    Link newLink = new Link(link, longLink);
    repo.save(newLink);
  }

  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public class ResourceNotFoundException extends RuntimeException {}
}
