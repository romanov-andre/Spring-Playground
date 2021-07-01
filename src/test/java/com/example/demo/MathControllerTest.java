package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MathController.class)
public class MathControllerTest {

    @Autowired
    private MockMvc mock;

    @Test
    public void getMathPI() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/pi");
        mock.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(Math.PI)));
    }

    @Test
    public void testAdd() throws Exception {
        int x = 10;
        int y = 5;
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=add&x="+x+"&y="+y);
        this.mock.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("15"));
    }

    @Test
    public void testSubtract() throws Exception {
        int x = 10;
        int y = 5;
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=subtract&x="+x+"&y="+y);
        this.mock.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("5"));
    }

    @Test
    public void testMultiply() throws Exception {
        int x = 10;
        int y = 5;
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=multiply&x="+x+"&y="+y);
        this.mock.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("50"));
    }

    @Test
    public void testDivide() throws Exception {
        int x = 10;
        int y = 5;
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=divide&x="+x+"&y="+y);
        this.mock.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("2"));

    }

    @Test
    public void testVolume() throws Exception {
        int length = 5;
        int width = 3;
        int height = 2;
        RequestBuilder request = MockMvcRequestBuilders.get("/math/volume/" + length
        + "/ " + width + "/ " + height);
        mock.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(length * width * height)));
    }

    @Test
    public void testComputeAreaOfCircle() throws Exception {
        String type = "circle";
        int radius =5;
        int width = 5, height = 5;

        RequestBuilder request = MockMvcRequestBuilders.post("/math/area/")
                //.contentType("application/x-www-form-urlencoded")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type",type)
                .param("radius", String.valueOf(radius))
                .param("width", String.valueOf(width))
                .param("height", String.valueOf(height));

        String expectedForCircle = String.valueOf((int)(Math.pow(radius, 2) * Math.PI));
        String expectedForRect = String.valueOf(width * height);


        this.mock.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(expectedForCircle));
    }





}
