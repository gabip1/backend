package zti.crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zti.crud.exception.ResourceNotFoundException;
import zti.crud.model.Movies;
import zti.crud.repository.MoviesRepository;

@CrossOrigin(origins = "http://frontend-movie-app.herokuapp.com/")
@RestController
@RequestMapping("/api/v1/")

/**
 * Creating the REST APIs for creating, retrieving, updating, and deleting a movie
 * @author Gabriela Penarska
 * @version 1.0
 */

public class MoviesController {

	@Autowired
	private MoviesRepository moviesRepository;
	
	/**
	 * Get list of all movies
	 * @return list of movies
	 */

	// get all movies
	@GetMapping("/movies")
	public List<Movies> getAllMovies() {
		return moviesRepository.findAll();
	}
	
	/**
	 * Adds a movie to movie list
	 * @param movie 
	 * @return added movie
	 */

	// add movie
	@PostMapping("/movies")
	public Movies createMovie(@RequestBody Movies movie) {
		return moviesRepository.save(movie);
	}
	
	/**
	 * Gets a movie with particular id to perform actions on specified one
	 * @param id
	 * @return movie with particular id
	 */

	// get movie by id
	@GetMapping("/movies/{id}")
	public ResponseEntity<Movies> getMovieById(@PathVariable Long id) {

		Movies movie = moviesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Movie doesn't exist with id: " + id));
		return ResponseEntity.ok(movie);
	}
	
	/**
	 * Updates a particular movie
	 * @param id movie's id
	 * @param movieDetails title, director and genre of the particular movie
	 * @return movie with updated parameters
	 */

	// update movie
	@PutMapping("/movies/{id}")
	public ResponseEntity<Movies> updateMovie(@PathVariable Long id, @RequestBody Movies movieDetails) {

		Movies movie = moviesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Movie doesn't exist with id: " + id));

		movie.setTitle(movieDetails.getTitle());
		movie.setDirector(movieDetails.getDirector());
		movie.setGenre(movieDetails.getGenre());

		Movies updatedMovie = moviesRepository.save(movie);
		return ResponseEntity.ok(updatedMovie);

	}
	
	/**
	 * Deletes a particular movie
	 * @param id movie's id
	 * @return list without a deleted movie
	 */

	//delete movie
	@DeleteMapping("/movies/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteMovie(@PathVariable Long id) {
		Movies movie = moviesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

		moviesRepository.delete(movie);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
