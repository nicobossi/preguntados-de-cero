import { Injectable } from "@angular/core";
import { AuthenticationService } from "./authentication";
import { HttpHeaders } from "@angular/common/http";
import { jwtDecode } from "jwt-decode";

@Injectable({
  providedIn: 'root'
})
export class JwtService implements AuthenticationService<HttpHeaders> {
  auth(headers: HttpHeaders) {
    const token = headers.get('Authorization')?.substring(7);

    if(token) {
      localStorage.setItem("TOKEN_KEY", token);
    }
  }

  getToken() {
    return localStorage.getItem("TOKEN_KEY");
  }

  isAuthenticate() {
    const token = localStorage.getItem("TOKEN_KEY");
    return token && !this.isExpired(token);
  }

  isExpired(token: string) {
    const { exp } = jwtDecode(token);
    return exp! * 1000 < Date.now();
  }
}
