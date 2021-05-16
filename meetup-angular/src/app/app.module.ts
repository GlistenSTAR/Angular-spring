import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { FooterComponent} from './shared/footer/footer.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './shared/login/login.component';
import { RegistroComponent } from './shared/registro/registro.component';
// Importamos los Módulos
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
// Importamos los servicios
import { RegistroService } from './shared/registro/servicio/registro.service';
import { HttpService } from './core/http.service';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { TopicsComponent } from './topics/topics.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    FooterComponent,
    LoginComponent,
    RegistroComponent,
    TopicsComponent
  ],
  imports: [
    NoopAnimationsModule,
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatAutocompleteModule
  ],
  providers: [
    RegistroService,
    HttpService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
