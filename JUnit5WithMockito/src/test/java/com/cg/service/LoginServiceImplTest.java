package com.cg.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static java.lang.Boolean.FALSE;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static java.lang.Boolean.TRUE;
import com.cg.dao.LoginRepository;
import com.cg.entity.Login;

@ExtendWith(MockitoExtension.class)
public class LoginServiceImplTest {
	
    @InjectMocks
	LoginServiceImpl service;
    
    @Mock
    LoginRepository repository;
    
    
    @Test
    public void shouldReturnTrue_WhenLoginIsSuccessfull() {
    	
 
    	
    	        //Arrange
    	        Login login = new Login();
    	        login.setMobileNum(1234567890);
    	        login.setPassword("password");

    	        when(repository.existsById(login.getMobileNum())).thenReturn(TRUE);
    	        when(repository.getOne(login.getMobileNum())).thenReturn(login);

    	        //Act
    	        boolean result = service.login(login);

    	        //Assert
    	        assertThat(result).isEqualTo(true);
    	    }
    
   @Test
    public void shouldReturnFalse_WhenLoginIsNotSuccessfull() {
    	
    	//Arrange
    	Login login = new Login();
    	
    	//Act
    	when(repository.existsById(login.getMobileNum())).thenReturn(FALSE);
    	
    	 //Act
        boolean result = service.login(login);

        //Assert
        assertThat(result).isEqualTo(false);
    }
   
   @Test
   public void shouldReturnTrue_whenNewUserIsRegistering() {

       //Arrange
       Login login = new Login();


       when(repository.existsById(login.getMobileNum())).thenReturn(FALSE);
       when(repository.save(login)).thenReturn(any());

       //Act
       boolean result = service.register(login);

       //Assert
       assertThat(result).isEqualTo(true);
   }
   
   @Test
   public void shouldReturnFalse_whenUserIsAlreadyExists() {

       //Arrange
       Login login = new Login();
       login.setMobileNum(1234567890);

       when(repository.existsById(login.getMobileNum())).thenReturn(TRUE);

       //Act
       boolean result = service.register(login);

       //Assert
       assertThat(result).isEqualTo(false);
   }


    }
   
    


