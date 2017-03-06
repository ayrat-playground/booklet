package bookmate.app.booklet.domain;

import bookmate.app.booklet.models.Link;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LinkService {
  String find(String userAgent, String shortLink);
  Link find(String shortLink);
  Page<Link> findAll(Pageable page);
  Link create(Link link);
}
