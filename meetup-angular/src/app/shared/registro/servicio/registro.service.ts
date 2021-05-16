import {Inject, Injectable} from '@angular/core';
import {HttpService} from '../../../core/http.service';
import {ApiEndpoint} from '../../../home/shared/api-endpoint.model';
import {UsuarioMinimo} from '../modelo/usuario-minimo.model';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Ciudad} from '../../ciudades/ciudad.model';

@Injectable()
export class RegistroService{

  private urlUsuarios = 'http://localhost:8080/api/usuariosMin';
  private urlCiudades = 'http://localhost:8080/api/ciudades';

  constructor(private http: HttpClient) {
  }
  // tslint:disable-next-line:typedef
  registrarUsuarioMinimo(usuario: UsuarioMinimo) {
    return this.http.post(this.urlUsuarios, usuario);
  }

  buscarCiudadPorNombre(nombre: string): Observable<Ciudad[]>{
    return this.http.get<Ciudad[]>(`${this.urlCiudades}/filtrar-ciudades/${nombre}`);
  }

}
