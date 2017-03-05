package bookmate.app.booklet.services;

import bookmate.app.booklet.domain.LinkService;
import bookmate.app.booklet.models.Link;
import bookmate.app.booklet.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements LinkService {
  private final LinkRepository repo;

  @Autowired
  public LinkServiceImpl(LinkRepository repo) {
    this.repo = repo;
  }

  @Override
  public String find(Device device, String shortLink) {
    return null;
  }

  @Override
  public Link find(String shortLink) {
    return repo.findOne(shortLink);
  }

  @Override
  public Iterable<Link> findAll() {
    return repo.findAll();
  }

  @Override
  public Link create(String shortLink, String longLink) {
    Link link = new Link(shortLink, longLink);
    return repo.save(link);
  }
}
