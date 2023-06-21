import { Component, NgModule } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  form: FormGroup;
  loading = false;
  constructor(private fb: FormBuilder, private _snackbar: MatSnackBar){
    this.form = this.fb.group({
      usuario: ['',Validators.required],
      password: ['',Validators.required]
    })
  }

  ngOnInit(): void{

  }

  ingresar() {
    const usuario = this.form.value.usuario;
    const password = this.form.value.password;

    if (usuario == 'fabrizio' && password == 'admin123'){
      this.fakeLoading();
    } else{
      this.error();
    }
  }

  error(){
    this._snackbar.open('Usuario o contraseña inválidos', '', {duration: 5000, horizontalPosition: 'center', verticalPosition: 'bottom'})
  }

  fakeLoading(){
    this.loading = true;
    setTimeout(() =>{
        this.loading = false;
    }, 1500);
  }

}
