package bookmate.app.booklet.booklet.repositories;

import bookmate.app.booklet.booklet.models.Link;
import org.springframework.data.repository.CrudRepository;

public interface LinkRepository extends CrudRepository<Link, String> {
}
