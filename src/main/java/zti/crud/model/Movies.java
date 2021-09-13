package zti.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movies")

/**
 * The class implements a movie with specific details
 * 
 * @author Gabriela Penarska
 * @version 1.0
 *
 */

public class Movies {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "director")
	private String director;
	
	@Column(name = "genre")
	private String genre;

	
	public Movies() {
		
	}
	
	/**
	 * This describes a movie with a specified id, title, director and genre
	 * 
	 * @param id the id of the movie
	 * @param title the title of the movie
	 * @param director the director of the movie
	 * @param genre the genre of the movie
	 */
	
	public Movies(long id, String title, String director, String genre) {
		super();
		this.id = id;
		this.title = title;
		this.director = director;
		this.genre = genre;
	}
	
	/**
	 * This method returns id of the movie
	 * @return movie's id
	 */
	
	public long getId() {
		return id;
	}
	
	/**
	 * Describes a movie with a specified id
	 * @param id movie's id
	 */
	
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * This method returns title of the movie
	 * @return movie's title
	 */
	
	public String getTitle() {
		return title;
	}
	
	/**
	 * Describes a movie with a specified title
	 * @param title movie's title
	 */
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * This method returns director of the movie
	 * @return movie's director
	 */
	
	public String getDirector() {
		return director;
	}
	
	/**
	 * Describes a movie with a specified director
	 * @param director movie's director
	 */
	
	public void setDirector(String director) {
		this.director = director;
	}
	
	/**
	 * This method returns genre of the movie
	 * @return movie's genre
	 */
	
	public String getGenre() {
		return genre;
	}
	
	/**
	 * Describes a movie with a specified genre
	 * @param genre movie's genre
	 */
	
	public void setGenre(String genre) {
		this.genre = genre;
	}

}
