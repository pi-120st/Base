package com.base;

import org.apache.catalina.filters.CorsFilter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseApplicationTests {

    private MockMvc mockMvc;

    @Mock
    private BaseService baseService;

    @InjectMocks
    private BaseController baseController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(baseController)
                .build();
    }

    @Test
    public void testFindByLogin() {
        SignUp signUps = (
                new SignUp("Zogus", "Maximus", 12345678, "yourMail@mail.com", "1234", "USER"));

        //doAnswer(returnsFirstArg()).when(baseService).signUpUser(signUps).thenReturn(signUps);
        doAnswer(returnsFirstArg()).when(baseService).signUpUser(signUps);
        verify(baseService, times(1)).signUpUser(signUps);
        verify(baseService, never()).findByLogin("Zogus");
        verifyNoMoreInteractions(baseService);
    }

    public void testSignUps() {
        //SignUp signUp = new SignUp("Test", "TestSurname", 12221, "mail", "qwe", "ADMIN");
        //when(baseService.signUpUser(signUp));
    }

    public void test() {
        SignUp signUps = (new SignUp("Test", "TestSurname", 12221, "mail", "qwe", "ADMIN"));
        assertEquals(signUps, "Test");

    }
}
