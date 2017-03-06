package bookmate.app.booklet.controllers;

import bookmate.app.booklet.models.Link;
import bookmate.app.booklet.services.LinkServiceImpl;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/links")
public class LinkController {
  private final LinkServiceImpl linkService;

  @Autowired
  public LinkController(LinkServiceImpl linkService) {
    this.linkService = linkService;
  }

  @GetMapping
  public Page<Link> index(Pageable pageable) {
    return linkService.findAll(pageable);
  }

  @GetMapping("/{shortLink}")
  public Link show(
      @PathVariable String shortLink,
      Device device
  ) {
    Link link = linkService.find(shortLink);

    if (link!=null) {
      return link;
    }
    else {
      throw new ResourceNotFoundException();
    }
  }

  @PostMapping
  public void create(@Valid Link link) {
    linkService.create(link);
  }

  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  private class ResourceNotFoundException extends RuntimeException {}
}
