import { Injectable } from '@angular/core';
import { USERS } from 'src/app/mocks/users-mocks';
import { TokenService } from './token.service';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private tokenService: TokenService) {}

  login(loginData: any): boolean {
    let isUserExists = false;
    USERS.forEach((user) => {
      if (
        user.username === loginData.username &&
        user.password === loginData.password
      ) {
        isUserExists = true;
        this.tokenService.saveToken('true');
        this.tokenService.setUserLoginStatus('true');
      }
    });
    return isUserExists;
  }

  logout(): void {
    this.tokenService.removeToken();
    this.tokenService.removeUserLoginStatus();
  }

}
