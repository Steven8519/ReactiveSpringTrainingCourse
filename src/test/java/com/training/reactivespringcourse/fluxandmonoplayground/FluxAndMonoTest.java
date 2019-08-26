package com.training.reactivespringcourse.fluxandmonoplayground;

import org.junit.Test;
import reactor.core.publisher.Flux;

public class FluxAndMonoTest {

    @Test
    public void fluxTest() {
       Flux<String> stringFlux = Flux.just("Spring", "Spring Boot", "Reactive Spring")
               //.concatWith(Flux.error(new RuntimeException("Exception Occured")))
               .concatWith(Flux.just("After error"))
               .log();

       stringFlux
               .subscribe(System.out::println,
                       (error) -> System.err.println("Exception is" + error),
                       () -> System.out.println("Completed"));
    }
}
