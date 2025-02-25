import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ROUTER_PATH } from 'src/app/app-config/router-path-const';
import { AuthService } from 'src/app/auth/service/auth.service';

@Component({
  selector: 'dc-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass'],
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;
  username = '';
  password = '';
  isLoadingResults = false;
  credintialError = false;

  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username: [null, Validators.required],
      password: [null, Validators.required],
    });
  }

  onFormSubmit(): void {
    this.isLoadingResults = true;
    let isIn = this.authService.login(this.loginForm.value);
    if (isIn) {
      this.isLoadingResults = false;
      this.router.navigate([ROUTER_PATH.contextPath + ROUTER_PATH.home]);
    } else {
      this.credintialError = true;
    }
  }
}
