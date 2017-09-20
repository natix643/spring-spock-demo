package com.example.smock

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import spock.lang.Specification

import java.time.*

import static java.time.ZoneId.systemDefault

@SpringBootTest
class TimeServiceTest extends Specification {

    static NOW = LocalDateTime.of(2017, 9, 20, 0, 0).atZone(systemDefault()).toInstant()

    @Autowired
    TimeService timeService

    def "should return today's date"() {
        expect:
        timeService.today() == LocalDate.of(2017, 9, 20)
    }

    @TestConfiguration
    static class Mocks {
        @Bean
        Clock clock() {
            Clock.fixed(NOW, systemDefault())
        }
    }
}
