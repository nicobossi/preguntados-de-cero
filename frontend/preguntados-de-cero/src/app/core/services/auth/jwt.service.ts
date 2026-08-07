import { Injectable } from "@angular/core";
import { AuthenticationService } from "./authentication";
import { HttpHeaders } from "@angular/common/http";

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
}
