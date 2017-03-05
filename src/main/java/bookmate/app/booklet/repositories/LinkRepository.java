package bookmate.app.booklet.repositories;

import bookmate.app.booklet.models.Link;
import org.springframework.data.repository.CrudRepository;

public interface LinkRepository extends CrudRepository<Link, String> {
}
