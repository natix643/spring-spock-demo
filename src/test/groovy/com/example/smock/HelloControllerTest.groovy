package com.example.smock

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import spock.mock.DetachedMockFactory

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest extends Specification {

    @Autowired
    MockMvc mvc
    @Autowired
    HelloController mockController

    def 'GET /hello should call hello()'() {
        given:
        1 * mockController.hello() >> 'hello, test'

        when:
        def response = mvc.perform(get('/hello'))
                .andReturn().response

        then:
        response.status == 200
        response.contentAsString == 'hello, test'
    }

    @TestConfiguration
    static class Mocks {
        def factory = new DetachedMockFactory()

        @Bean
        HelloController helloController() {
            factory.Mock(HelloController)
        }
    }
}
