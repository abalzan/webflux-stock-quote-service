package com.andrei.service;

import java.time.Duration;

import com.andrei.model.Quote;

import reactor.core.publisher.Flux;

public interface QuoteGeneratorService {

	Flux<Quote> fetchQuoteStream(Duration period);
}
