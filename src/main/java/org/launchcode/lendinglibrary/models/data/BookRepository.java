package org.launchcode.lendinglibrary.models.data;

import org.launchcode.lendinglibrary.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book,Integer> {
}
