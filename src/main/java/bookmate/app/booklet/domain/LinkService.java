package bookmate.app.booklet.domain;

import bookmate.app.booklet.models.Link;
import org.springframework.mobile.device.Device;

public interface LinkService {
  String find(Device device, String shortLink);
  Link find(String shortLink);
  Iterable<Link> findAll();
  Link create(String shortLink, String longLink);
}
