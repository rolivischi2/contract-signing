import { Component } from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'contract-signing-plugin';
  links = [
    { title: 'Contract Templates', fragment: 'templates' },
    { title: 'Signed Contracts', fragment: 'signed' }
  ];

  constructor(public route: ActivatedRoute) {}


}
