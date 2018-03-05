package com.andrei.service;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.andrei.model.Quote;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;
import reactor.core.publisher.Flux;

public class QuoteGeneratorServiceImplTest {

	private QuoteGeneratorService quoteGeneratorService = new QuoteGeneratorServiceImpl();;
	
	@Before
	public void setUp() throws Exception {
//		quoteGeneratorService = new QuoteGeneratorServiceImpl();
	}

	@Test
	public void testFetchQuoteStream() {
		//get quoteFlux of quotes
		Flux<Quote> quoteFlux = quoteGeneratorService.fetchQuoteStream(Duration.ofMillis(100));
		quoteFlux.take(10).subscribe(System.out::println);
	}
	
	@Test
	@Ignore
	public void testFetchQuoteStreamCountDown() throws Exception {
		//get quoteFlux of quotes
		Flux<Quote> quoteFlux = quoteGeneratorService.fetchQuoteStream(Duration.ofMillis(100));
//		quoteFlux.take(10).subscribe(System.out::println);
		Consumer<Quote> println = System.out::println;
		
		Consumer<Throwable> errorHandler = e -> System.out.println("Some error occurred!!!");
		
		CountDownLatch countDownLatch = new CountDownLatch(1);
		
		Runnable allDone = () -> countDownLatch.countDown();
		
//		quoteFlux.take(10).subscribe(println, errorHandler, allDone);
		
		countDownLatch.wait();
	}

}
