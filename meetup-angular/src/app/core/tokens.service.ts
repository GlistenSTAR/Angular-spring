import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';

import {HttpService} from './http.service';
import {Role} from './role.model';

@Injectable()
export class TokensService {
  static END_POINT = '/api/usuarios';

  constructor(private httpService: HttpService) {
  }

  login(username: string, password: string): Observable<any> {
    return this.httpService.login(username, password, TokensService.END_POINT);
  }

  logout(): void {
    this.httpService.logout();
  }

  isAdmin(): boolean {
    return this.httpService.getToken() ? this.httpService.getToken().roles.includes(Role.ADMIN) : false;
  }

  isUser(): boolean {
    return this.httpService.getToken() ? this.httpService.getToken().roles.includes(Role.USER) : false;
  }

  getUsername(): string {
    return this.httpService.getToken() ? this.httpService.getToken().username : '???';
  }

  getPassword(): string {
    return this.httpService.getToken() ? this.httpService.getToken().password : '???';
  }
}
