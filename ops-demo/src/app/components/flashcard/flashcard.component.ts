import { Component } from '@angular/core';
import { FlashcardService } from '../../services/flashcard.service';
import { Category } from '../../models/category.model';
import { Flashcard } from '../../models/flashcard.model';
import { FlashcardList } from '../../models/card-list.model';

@Component({
  selector: 'app-flashcard',
  templateUrl: './flashcard.component.html',
  styleUrls: ['./flashcard.component.css']
})
export class FlashcardComponent {

  title = 'Flashcards';

  // Inject service
  constructor(private flashcardService: FlashcardService) { }

  public cards: Flashcard[];

  getCards(): void {
    this.flashcardService.fetchAllCards()
      .subscribe(
        (cardList: FlashcardList) => { this.cards = cardList.flashcards; },
        error => { console.log(error); }
      );
  }

}
