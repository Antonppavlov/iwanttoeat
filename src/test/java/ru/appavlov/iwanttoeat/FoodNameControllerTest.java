package ru.appavlov.iwanttoeat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.appavlov.iwanttoeat.model.food.FoodName;
import ru.appavlov.iwanttoeat.service.impl.food.FoodNameService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class FoodNameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FoodNameService service;

    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        when(service.get(1)).thenReturn(new FoodName("пельмени", null));

        this.mockMvc.perform(get("/food/name/get?id=1"))
                .andExpect(status().isOk());

    }
}
