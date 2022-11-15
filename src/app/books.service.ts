import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class BooksService {
  apiurl="http://localhost:8080/book";

  constructor(private http:HttpClient) { }
  getBookDetails(){
    const books=this.http.get(this.apiurl);
    console.log("FromMovieApiService: "+books);
    return books;
  }
}
