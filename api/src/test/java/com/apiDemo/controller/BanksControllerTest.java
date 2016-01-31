package com.apiDemo.controller;

import com.apiDemo.ApiApplication;
import com.apiDemo.service.BanksService;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by p.bell on 31.01.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApiApplication.class)
@WebAppConfiguration
public class BanksControllerTest extends TestCase {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    BanksService banksService;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testAddData() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/operations/?iban=1&businessIdentifierCode=test")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testUpdate() throws Exception {
        long id = banksService.create("2", "test2", null);
        mockMvc.perform(MockMvcRequestBuilders.put("/operations/?index="+id+"&iban=2&businessIdentifierCode=test1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDeleteData() throws Exception {
        long id = banksService.create("2", "test2", null);
        mockMvc.perform(MockMvcRequestBuilders.delete("/operations/?index="+id)).andExpect(MockMvcResultMatchers.status().isOk());
    }

}