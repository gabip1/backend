package zti.crud;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import jdk.internal.net.http.common.Log;
import zti.crud.model.Movies;
import zti.crud.repository.MoviesRepository;

import org.springframework.beans.factory.annotation.Autowired;
//import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertFalse;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc

class MoviesManagementFinalApplicationTests {

	@Autowired 
	private MockMvc mockMvc;

	
	@Test
	public void contextLoads() throws Exception {
		//Movies testMovie = new Movies(123,"c1","c2","c3");
		//moviesRepository.save(testMovie);
		//Assert.assertNotNull(moviesRepository.findById((long) 1234));
		
		//System.out.println(moviesRepository.findById((long) 123));
		//System.out.println(moviesRepository.existsById((long) 123));
		//System.out.println(moviesRepository.count());
		//System.out.println(moviesRepository.findAll());
		//System.out.println(((Movies) moviesRepository.findAll().toArray()[0]).getId());
		
		//Assert.assertTrue(moviesRepository.existsById((long) 1));
		this.mockMvc.perform(get("/movies/123")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("c1")));
	}

}
