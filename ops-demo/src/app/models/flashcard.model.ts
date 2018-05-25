import { Category } from './category.model';

export class Flashcard {
    id: number;
    question: string;
    answer: string;
    category: Category;

    constructor(id: number, question: string, answer: string, category: Category) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.category = category;
    }
}
