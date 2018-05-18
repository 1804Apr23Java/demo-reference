import { Component, OnInit } from '@angular/core';
import { BearService } from '../../services/bear.service';
import { Bear } from '../../models/bear.model';

@Component({
  selector: 'app-http',
  templateUrl: './http.component.html',
  styleUrls: ['./http.component.css']
})
export class HttpComponent implements OnInit {

  title = 'HTTP';
  documentation = 'https://angular.io/guide/http';

  // Inject service
  constructor(private bearService: BearService ) { }

  public bear: Bear = new Bear(5, '');

  getBearInformation(): void {
    this.bearService.fetchBearInformation(this.bear.id)
    .subscribe(
      bear => this.bear = bear,
      error => console.log(`Error: ${ error} `)
    );
  }

  // if we want to make the call when component is created
  ngOnInit() {
    this.getBearInformation();
  }

}
