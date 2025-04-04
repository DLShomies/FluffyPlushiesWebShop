package com.dlshomies.fluffyplushies.api;

import com.dlshomies.fluffyplushies.FluffyPlushiesIdentityApplication;
import com.dlshomies.fluffyplushies.config.FakerTestConfig;
import com.dlshomies.fluffyplushies.util.TestDataUtil;
import com.dlshomies.fluffyplushies.dto.AddressRequest;
import com.dlshomies.fluffyplushies.dto.UserRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.function.Consumer;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = FluffyPlushiesIdentityApplication.class)
@TestPropertySource(locations = "classpath:application-test.properties")
@Import(FakerTestConfig.class)
@AutoConfigureMockMvc
class UserControllerApiTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    private static final String DATA_PROVIDER_PATH = "com.dlshomies.fluffyplushies.api.TestDataProvider";

    @BeforeEach
    void setUp() {
    }

    @Test
    void register_givenEmptyRequestBody_returnBadRequest() throws Exception {
        mvc.perform(post("/identity/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void register_givenValidRequestBody_returnOk() throws Exception {
        var addressRequest = generateAddressRequest();

        objectMapper.writeValueAsString(addressRequest);

        var userRequest = UserRequest.builder()
                .username(TestDataUtil.username())
                .email(TestDataUtil.emailAddress())
                .phone(TestDataUtil.phoneNumber())
                .password("Str0ngP@ssw0rd")
                .address(addressRequest)
                .build();

        mvc.perform(post("/identity/users")
                        .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(userRequest)))
                .andExpect(status().isOk());
    }

    private static AddressRequest generateAddressRequest() {
        return AddressRequest.builder()
                .street(TestDataUtil.streetAddress())
                .postalCode(TestDataUtil.postcode())
                .city(TestDataUtil.city())
                .country(TestDataUtil.country())
                .build();
    }

    @ParameterizedTest
    @MethodSource(value = DATA_PROVIDER_PATH + "#nullAndEmptyFieldProvider")
    void register_givenFieldIsNullOrEmpty_returnBadRequest(Consumer<UserRequest.UserRequestBuilder<?, ?>> modifier) throws Exception {
        var addressRequest = generateAddressRequest();

        var builder = UserRequest.builder()
                .email(TestDataUtil.emailAddress())
                .phone(TestDataUtil.phoneNumber())
                .password("Str0ngP@ssw0rd")
                .address(addressRequest)
                .username(TestDataUtil.username());

        modifier.accept(builder);
        var userRequest = builder.build();

        mvc.perform(post("/identity/users")
                        .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(userRequest)))
                .andExpect(status().isBadRequest());
    }
}