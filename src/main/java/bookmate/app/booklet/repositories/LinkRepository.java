package bookmate.app.booklet.repositories;

import bookmate.app.booklet.models.Link;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LinkRepository extends PagingAndSortingRepository<Link, String> {
}
