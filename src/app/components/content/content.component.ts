import { Component, OnInit } from '@angular/core';
import { BooksService } from 'src/app/books.service';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {

  books:Array<any>=[];

  constructor(private bookSvc:BooksService) { }

  ngOnInit(): void {
  }
  onLoad(){
    const self=this;
    this.bookSvc.getBookDetails()
    .subscribe((data:any)=>this.books=data)
  }
}
