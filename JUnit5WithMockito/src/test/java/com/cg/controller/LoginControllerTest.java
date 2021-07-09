package com.cg.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cg.entity.Login;
import com.cg.service.LoginServiceImpl;

@WebMvcTest(LoginController.class)
public class LoginControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@MockBean
	LoginServiceImpl service;
	
	@Test
	public void shouldReturnOk_whenLoginIsSuccess() throws Exception {
		 //Arrange
        String loginJson = "\n" +
                "{\n" +
                "\t\"mobileNum\":9398339059,\n" +
                "\t\"password\":\"Latha@123\"\n" +
                "}";

        Login login = new Login();
     //   login.setMobileNum(1234567890);
     //   login.setPassword("password");
        
        when(service.login(login)).thenReturn(Boolean.TRUE);


        //Act
        mockMvc.perform(post("/adminLogin")
                .contentType("application/json;charset=UTF-8")
                .content(loginJson)
        )

                //Assert
                .andExpect(status().isCreated());

    }

    @Test
    public void shouldReturnOk_whenRegistrationIsDone() throws Exception {

        //Arrange
        String loginJson = "\n" +
                "{\n" +
                "\t\"mobileNum\":1234567890,\n" +
                "\t\"password\":\"Latha@123\"\n" +
                "}";

        Login login = new Login();
   //     login.setMobileNum(1234567890);
    //    login.setPassword("Latha@123");

        when(service.register(login)).thenReturn(Boolean.TRUE);


        //Act
        mockMvc.perform(post("/adminLogin")
                .contentType("application/json;charset=UTF-8")
                .content(loginJson)
        )

                //Assert
                .andExpect(status().isCreated());

    }
		
		
		
	}


