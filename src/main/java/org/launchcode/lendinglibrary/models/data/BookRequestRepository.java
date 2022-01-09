package org.launchcode.lendinglibrary.models.data;

import org.launchcode.lendinglibrary.models.BookRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRequestRepository extends CrudRepository<BookRequest, Integer> {
}
