import { Component, OnInit } from '@angular/core';
import { environment} from '../../../environments/environment';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent {
  version: string;
  profile: string;

  constructor() {
    this.version = environment.VERSION;
    this.profile = environment.production ? 'Prod' : 'Dev';
  }
}
