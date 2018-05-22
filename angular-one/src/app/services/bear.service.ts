import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Bear } from '../models/bear.model';
import { BearList } from '../models/bear-list.model';
import { HttpClient } from '@angular/common/http';

// map() function maps http responses onto objects
// import 'rxjs/Rx';
import { Observable } from 'rxjs';

import { map } from 'rxjs/operators';

@Injectable()
export class BearService {

  // inject Http object
  constructor(private http: Http, private httpClient: HttpClient) { }

  public fetchBearInformation(id: number): Observable<Bear> {
    return this.http.get(`https://pokeapi.co/api/v2/pokemon/${id}`).pipe(map((response: Response) => {
      return <Bear>response.json();
    }));
  }

  // get all bears, for real, from our backend. using HttpClient, newer version of HttpModule
  public fetchAllBears(): Observable<BearList> {
    return this.httpClient.get<BearList>('http://localhost:8083/FrontControllerDemo/bear');
  }

}
