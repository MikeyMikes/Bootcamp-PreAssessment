package com.galvanize.tmo.paspringstarter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PaSpringStarterApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	LibraryRepository libraryRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void isHealthy() throws Exception {
		mockMvc.perform(get("/health"))
				.andExpect(status().isOk());
	}

	@Test
	void whenGetBooksIsCalled_thenFindAllShouldBeExecuted() throws Exception {
		when(libraryRepository.findAll())
				.thenReturn(Collections.emptyList());

		mockMvc.perform(get("/api/books")).andReturn();

		verify(libraryRepository).findAll(Sort.by(Sort.Direction.ASC, "title"));
	}

//	@Test
//	void bookIsAdded_Ok() throws Exception {
//		Book bookToReturn = new Book("Mike Livingston", "Ducks Are Cute", "7-25-2021");
//
//		when(libraryRepository.save(ArgumentMatchers.any(Book.class)))
//				.thenReturn(bookToReturn);
//
//		MvcResult result = mockMvc.perform(post("/api/books")).andReturn();
//
//		Assertions.assertTrue(result.getResponse().getContentAsString()
//				.contains("author : Mike Livingston"));
//	}

	@Test
	void whenDeleteAllBooksIsCalled_deleteAllShouldBeExecuted() throws Exception {
		mockMvc.perform(delete("/api/books")).andReturn();

		verify(libraryRepository).deleteAll();
	}

}
