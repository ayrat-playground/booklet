package bookmate.app.booklet.services;

import bookmate.app.booklet.domain.LinkService;
import bookmate.app.booklet.models.Link;
import bookmate.app.booklet.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
  public Page<Link> findAll(Pageable page) {
    return repo.findAll(page);
  }

  @Override
  public Link create(Link link) {
    return repo.save(link);
  }
}
