package zti.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zti.crud.model.Movies;

@Repository

/**
 * Creates a repository
 * @author Gabriela Penarska
 * @version 1.0
 */

public interface MoviesRepository extends JpaRepository<Movies, Long> {

}
