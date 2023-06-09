import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { NonNullableFormBuilder } from '@angular/forms';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.sass']
})
export class LoginFormComponent implements OnInit {

  constructor(
    private authService: AuthService,
    private formBuilder: NonNullableFormBuilder
  ) { }

  ngOnInit(): void {
  }

  enter() {
    this.authService.autenticate()
  }

}
