package com.epam.app.cloud.contract;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.app.LibraryserviceApplication;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = LibraryserviceApplication.class)
@AutoConfigureMockMvc
@AutoConfigureStubRunner(stubsMode = StubsMode.LOCAL, ids = {"com.epam:bookservice"})
class BookContractTest {

	
	
	  @Autowired
	  private MockMvc mockMvc;
	  
	  @Test 
	  void getBookTest() throws Exception {
	  mockMvc.perform(get("/api/books/1")) .andExpect(status().isOk());
	  //.andExpect(jsonPath("$.id", Matchers.is(1))); 
	  }
	 
	 
}
