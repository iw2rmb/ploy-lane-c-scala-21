package com.ploy.app;
import io.undertow.Undertow;import io.undertow.util.Headers;
public class Main { public static void main(String[] args){
  Undertow server = Undertow.builder().addHttpListener(Integer.parseInt(System.getenv().getOrDefault("PORT","8080")), "0.0.0.0")
    .setHandler(exchange -> { if ("/healthz".equals(exchange.getRequestPath())) { exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain"); exchange.getResponseSender().send("ok"); } else { exchange.getResponseSender().send("hello"); } }).build(); server.start(); }
}
