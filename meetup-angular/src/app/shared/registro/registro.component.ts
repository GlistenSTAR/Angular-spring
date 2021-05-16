import {Component, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs';
import {map, flatMap} from 'rxjs/operators';
import {Router} from '@angular/router';
import {RegistroService} from './servicio/registro.service';
import {UsuarioMinimo} from './modelo/usuario-minimo.model';
import {Ciudad} from '../ciudades/ciudad.model';
import {MatAutocompleteSelectedEvent} from '@angular/material/autocomplete';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit{

  public usuarioMin: UsuarioMinimo;
  username: string;
  email: string;
  password: string;
  fechaNacimiento: Date;
  ciudad: Ciudad;

  autocompliteCiudad = new FormControl();
  ciudadesFiltradas: Observable<Ciudad[]>;

  constructor(private registroService: RegistroService, private router: Router) {
     this.usuarioMin = new UsuarioMinimo(this.username, this.email, this.password, this.fechaNacimiento, this.ciudad);
  }
  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.ciudadesFiltradas = this.autocompliteCiudad.valueChanges
      .pipe(
        map(value => typeof value === 'string' ? value : value.nombre),
        flatMap(value => value ? this._filter(value) : [])
      );
  }
  // tslint:disable-next-line:typedef
  registrarUsuario() {
    this.usuarioMin.username = this.username;
    this.usuarioMin.email = this.email;
    this.usuarioMin.password = this.password;
    this.usuarioMin.fechaNacimiento = this.fechaNacimiento;
    this.usuarioMin.ciudad = this.ciudad;

    this.registroService.registrarUsuarioMinimo(this.usuarioMin).subscribe(
      resp => {
        console.log('El usuario se ha creado correctamente');
        this.router.navigate(['/login']);
      },
      error => {
        if (error.status === 400) {
          console.log('No se ha podido crear el usuario');
        } else if (error.status === 409) {
          console.log('El usuario ya existe');
        }
      }
    );
  }

  private _filter(value: string): Observable<Ciudad[]> {
    const filterValue = value.toLowerCase();
    return this.registroService.buscarCiudadPorNombre(filterValue);
  }

  mostrarNombreCiudad(ciudad ?: Ciudad): string | undefined{
    return ciudad ? ciudad.nombre : undefined;
  }

  seleccionarCiudad(event: MatAutocompleteSelectedEvent): void{
    const ciudad = event.option.value as Ciudad;
    this.usuarioMin.ciudad = ciudad;
  }
}
