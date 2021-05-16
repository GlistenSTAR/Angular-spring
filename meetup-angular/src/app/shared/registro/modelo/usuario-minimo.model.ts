import {Ciudad} from '../../ciudades/ciudad.model';

export class UsuarioMinimo {
  constructor(username: string, email: string, password: string, fechaNacimiento: Date, ciudad: Ciudad) {}
  username: string;
  email: string;
  password: string;
  fechaNacimiento: Date;
  ciudad: Ciudad;
}
