package com.bebestlang.bebest.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Configuration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.ANY)
public class ReactiveRequestContext implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        return chain.filter(exchange)
                .contextWrite(ctx -> ctx.put(ReactiveRequestContextHolder.CONTEXT_KEY, request));
    }

}
