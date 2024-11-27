package com.example;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class TokenValidator {

  private static final String SECRET = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsJWW58vLHqImc930HjcJ5ZgFcDvXIaTiU+agpTvWqzA7Fu4bnRoekKvHwMZuZSQ8eV7c3xiRaXkkI78IXOudhKkVIzNs55UU8M+iOe3Kg6MJcafTFO2fYSN60Cda9aYrOW/Zn7ucZ9iyVSS6WZX/RywuuxTa3QysivOId6uhwZsvi9+qqzbFOu1Anxfl7d+5Fz1T7N+5J0VKqzyPAb1KWbne9CAs9QHWyH+nYYzOw3m99thfftsdXX77qJ01q70v24rk6V4v2bOWo/0bxQzN1bLJ/mv1bHt0ErUZ2CbSDuH7Hb5cNujvoJsWndwXIi+UmdFAcUlOJ30l3JbmWyT2AQIDAQAB";

  public static boolean isValid(String token) {
    try {
      Key key = Keys.hmacShaKeyFor(SECRET.getBytes());  // Usar la clave pública para verificar
      Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
      return true; // Si no lanza una excepción, el token es válido.
    } catch (Exception e) {
      return false; // Token inválido
    }
  }
}
