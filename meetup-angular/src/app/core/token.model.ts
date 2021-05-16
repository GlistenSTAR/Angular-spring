import {Role} from './role.model';

export interface Token {
  token: string;
  username?: string;
  password?: string;
  roles?: Array<Role>;
}
