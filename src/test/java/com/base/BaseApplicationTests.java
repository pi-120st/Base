package com.base;

import org.apache.catalina.filters.CorsFilter;
import org.hibernate.cache.spi.AbstractRegionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.LinkedList;
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
       List <SignUp> signUps = Arrays.asList(
       new SignUp("Zogus", "Maximus", 12345678, "yourMail@mail.com", "1234", "USER"));
        List<SignUp> spy = spy(signUps);
        when(baseService.findByLogin("yourMail@mail.com")).thenReturn(spy.get(4));
        assertEquals("yourMail@mail.com", spy.get(4));
        doAnswer(returnsFirstArg()).when(baseService).signUpUser(signUps.get(4));
        verify(baseService, never()).signUpUser(signUps.get(1));
        verify(baseService, times(1)).signUpUser(signUps.get(1));
        verifyNoMoreInteractions(baseService);
    }

    public void testSignUps() {
        ArgumentCaptor<SignUp> test = ArgumentCaptor.forClass(SignUp.class);
        SignUp signUps = (
                new SignUp("Zogus", "Maximus", 12345678, "yourMail@mail.com", "1234", "USER"));
        verify(baseService, times(1)).signUpUser(signUps);
        Mockito.doNothing().when(baseService).signUpUser(signUps);
        List<SignUp> test2 = test.getAllValues();
        assertEquals("Zogus", test2.get(0));
        assertEquals("Maximus", test2.get(1));
        assertEquals(12345678, test2.get(2));
        assertEquals("yourMail@mail.com", test2.get(3));
        assertEquals("1234", test2.get(4));
        assertEquals("USER", test2.get(5));
        verify(baseService, never()).findByLogin("yourMail@mail.com");
        verify(baseService, times(1)).signUpUser(signUps);
        verifyNoMoreInteractions(baseService);
    }
}
