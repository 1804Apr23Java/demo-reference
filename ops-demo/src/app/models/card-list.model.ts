import { Flashcard } from './flashcard.model';

export class FlashcardList {
    flashcards: Flashcard[];

    constructor(cards: Flashcard[]) {
        this.flashcards = cards;
    }
}
