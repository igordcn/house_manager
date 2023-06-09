import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Token } from '../models/token.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private httpClient: HttpClient
  ) { }

  autenticate(credential: Credential): Observable<Token> {
    let url = "http://localhost:8080";
    let uri = "/auth"
    return this.httpClient.post<Token>(`${url}${uri}`, credential);
  }
  
}
