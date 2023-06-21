import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { EditMysteryComponent } from './edit-mystery/edit-mystery.component';
import { ListMysteryComponent } from './list-mystery/list-mystery.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: 'list', component: ListMysteryComponent},
  { path: 'edit/:id', component: EditMysteryComponent},
  { path: '', redirectTo: 'home', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
