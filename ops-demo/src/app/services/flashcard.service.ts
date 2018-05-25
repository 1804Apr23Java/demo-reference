import { Injectable } from '@angular/core';
import { Flashcard } from '../models/flashcard.model';
import { FlashcardList } from '../models/card-list.model';
import { HttpClient } from '@angular/common/http';

// map() function maps http responses onto objects
// import 'rxjs/Rx';
import { Observable } from 'rxjs';

import { map } from 'rxjs/operators';

@Injectable()
export class FlashcardService {

  // inject Http object
  constructor(private httpClient: HttpClient) { }

  // get all bears, for real, from our backend. using HttpClient, newer version of HttpModule
  public fetchAllCards(): Observable<FlashcardList> {
    return this.httpClient.get<FlashcardList>('http://ec2-34-217-90-162.us-west-2.compute.amazonaws.com:8090/OpsDemo/flashcard');
  }

}
