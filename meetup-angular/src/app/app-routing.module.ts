import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {AppComponent} from './app.component';

import { LoginComponent } from './shared/login/login.component';
import { RegistroComponent } from './shared/registro/registro.component';
import { TopicsComponent } from './topics/topics.component';


const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'registro', component: RegistroComponent },
  { path: 'topics', component: TopicsComponent },
  { path: '', pathMatch: 'full', redirectTo: AppComponent.URL}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
