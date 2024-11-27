package com.example;

import io.javalin.Javalin;

public class Main {
  public static void main(String[] args) {
    Javalin app = Javalin.create().start(7000);

    app.get("/", ctx -> ctx.result("Bienvenido a la PoC de OAuth!"));
    app.get("/login", OAuthController::redirect);
    app.get("/oauth/callback", OAuthController::callback);
    app.get("/protected", ctx -> {
      String token = ctx.header("Authorization");
      if (TokenValidator.isValid(token)) {
        ctx.result("Acceso concedido a contenido protegido.");
      } else {
        ctx.status(401).result("Token inválido.");
      }
    });
  }
}
