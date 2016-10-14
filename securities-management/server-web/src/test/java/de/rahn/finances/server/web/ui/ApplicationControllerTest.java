/*
 * Copyright 2011-2016 Frank W. Rahn and the project authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.rahn.finances.server.web.ui;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import de.rahn.finances.server.web.config.SecuritiesManagementApplication;

/**
 * Einen Test für den {@link ApplicationController}.
 *
 * @author Frank W. Rahn
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SecuritiesManagementApplication.class,
	initializers = ConfigFileApplicationContextInitializer.class)
@WebAppConfiguration
public class ApplicationControllerTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	/**
	 * Initialisiere diesen Test.
	 */
	@Before
	public void setUp() throws Exception {
		mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	/**
	 * Test method for {@link ApplicationController#index()}.
	 */
	@Test
	public void testIndex() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"))
			.andExpect(content().string(containsString("Wertpapierverwaltung")));
	}

	/**
	 * Test method for {@link ApplicationController#info()}.
	 */
	@Test
	public void testInfo() throws Exception {
		mockMvc.perform(get("/info")).andExpect(status().isOk()).andExpect(view().name("info"))
			.andExpect(content().string(containsString("Management-API")));
	}

}