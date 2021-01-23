package com.udacity.pricing;

import com.udacity.pricing.api.PricingController;
import com.udacity.pricing.service.PricingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.net.URI;
import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;



@RunWith(SpringRunner.class)
@WebMvcTest(PricingController.class)
public class PricingTest {

    public static int VALID_ID = 19;

    public static int INVALID_ID = 20;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PricingService pricingService;

    @Test
    public void getPriceWithValidId() throws Exception {
        this.mockMvc.perform(
                get(new URI("/services/price?vehicleId=" + VALID_ID))
                        .contentType(String.valueOf(StandardCharsets.UTF_8))
                        .accept(String.valueOf(StandardCharsets.UTF_8)));
        andExpect(status().is(200));
    }
    private void andExpect(ResultMatcher resultMatcher) {
    }
    @Test
    public void getPriceWithInvalidId() throws Exception {
        this.mockMvc.perform(
                get(new URI("/services/price?vehicleId=" + VALID_ID))
                        .contentType(String.valueOf(StandardCharsets.UTF_8))
                        .accept(String.valueOf(StandardCharsets.UTF_8)));
        andExpect(status().isNotFound());
    }

}
