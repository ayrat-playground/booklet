package bookmate.app.booklet.services;

import bookmate.app.booklet.domain.LinkService;
import bookmate.app.booklet.models.Link;
import bookmate.app.booklet.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements LinkService {
  private final LinkRepository repo;

  @Autowired
  public LinkServiceImpl(LinkRepository repo) {
    this.repo = repo;
  }

  @Override
  public String find(String userAgent, String shortLink) {
    Link link = find(shortLink);

    if (link != null) {
      PlatformDetectionServiceImpl platformService = new PlatformDetectionServiceImpl(userAgent);
      String platform = platformService.detect();
      return link.getLinkWithFallback(platform);
    }
    else {
      return null;
    }
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
