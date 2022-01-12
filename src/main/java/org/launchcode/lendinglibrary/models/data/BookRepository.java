package org.launchcode.lendinglibrary.models.data;

import org.launchcode.lendinglibrary.models.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book,Integer> {

    @Query(value = "SELECT * FROM book WHERE "
                    + " MATCH(name,author, summary) "
                    + " AGAINST (?1)",nativeQuery = true)
    public List<Book> search(String searchTerm);

}
