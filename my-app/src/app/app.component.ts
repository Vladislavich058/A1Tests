import { Component, OnInit } from '@angular/core';
import { Posting } from './models/posting';
import { PostingService } from './services/posting.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  postings: Posting[]=[]

  constructor(private postingsService: PostingService){
  }

  ngOnInit(): void {
    this.postingsService.getAll().subscribe(postings => {
      this.postings=postings
      // console.log(postings)
    })
  }

}
