import { Component, OnInit } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { Posting } from './models/posting';
import { PostingService } from './services/posting.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title='my-app'

  postings$: Observable<Posting[]>

  loading = false

  filterByDay = false;
  filterByMonth = false;
  filterByQuarter = false;
  filterByYear = false;

  service: PostingService

  filter=false

  form: any={
    date: '',
    month: '1',
    year: '2023',
    quarter: '1'
  } 

  constructor(private postingsService: PostingService){
    this.service=postingsService
  }

  ngOnInit(): void {
    this.loading=true
    // this.postingsService.getAll().subscribe(postings => {
    //   this.postings=postings
    //   this.loading=false
    // })
    this.postings$ = this.postingsService.getAll().pipe(
      tap(()=>this.loading=false)
    )
  }

}
