import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Bear } from '../models/bear.model';

// map() function maps http responses onto objects
// import 'rxjs/Rx';
import { Observable } from 'rxjs';

import { map } from 'rxjs/operators';

@Injectable()
export class BearService {

  // inject Http object
  constructor(private http: Http) { }

  public fetchBearInformation(id: number): Observable<Bear> {
    return this.http.get(`https://pokeapi.co/api/v2/pokemon/${id}`).pipe(map((response: Response) => {
        return <Bear> response.json();
      }));
  }

  private handleError(error: Response) {
    return Observable.throw(error.statusText);
  }

}
