package com.cognizant;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@AutoConfigureMockMvc
public class TestGetCountry {

	@Autowired
	private MockMvc mvc;
	@Test
	public void getCountry() throws Exception {

	ResultActions actions = mvc.perform(get("/country"));
	actions.andExpect(status().isOk());

	actions.andExpect(jsonPath("$.code").exists());

	actions.andExpect(jsonPath("$.code").value("IN"));

	}
}
