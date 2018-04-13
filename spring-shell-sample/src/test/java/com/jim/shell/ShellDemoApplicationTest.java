package com.jim.shell;

import com.jim.shell.service.ITranslationService;
import com.jim.shell.service.impl.TranslationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShellDemoApplicationTest {

    @Autowired
    private ITranslationService service;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void contextLoads() {

        List<String> list = mock(List.class);


        when(list.get(0)).thenReturn("hello");
        String result = list.get(0);
        verify(list).get(0);
        Assert.assertEquals("I don't know~!", result);
	}

}
