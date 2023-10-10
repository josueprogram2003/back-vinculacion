package com.example.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import jakarta.transaction.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonaTestController {
	
	@Autowired
	private MockMvc mock;
	
	 @Test
	public void listar() throws Exception{
		mock.perform(MockMvcRequestBuilders.get("/api/persona/all").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
		
	}
	 
	 @Test
	    @Transactional
	    public void buscarPersona() throws Exception {
		 mock.perform(MockMvcRequestBuilders
	                .get("/api/persona/search/2")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(MockMvcResultMatchers.status().isOk())
	                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	    }
	 
	 @Test
	    @Transactional
	    public void deletePersona() throws Exception {
		 mock.perform(MockMvcRequestBuilders
	                .delete("/api/persona/delete/4")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(MockMvcResultMatchers.status().isOk());
	    }
	 
	 @Test
	    @Transactional
	    public void crear() throws Exception {
		  String jsonPersona = "{\"nombres\": \"Ariana\", \"apellidos\": \"Marquez Romani\", \"dni\": \"1234567890\"}";
		  mock.perform(MockMvcRequestBuilders
	                .post("/api/persona/create")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(jsonPersona)) // Agregar el objeto JSON al cuerpo de la solicitud
	                .andExpect(MockMvcResultMatchers.status().isOk());
	    }
}
