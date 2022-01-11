package org.launchcode.lendinglibrary.models.data;

import org.launchcode.lendinglibrary.models.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends CrudRepository<Genre,Integer> {
}
