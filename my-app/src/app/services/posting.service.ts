import { HttpClient, HttpErrorResponse, HttpParams, HttpResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { catchError, delay, Observable, retry, throwError } from "rxjs";
import { Posting } from "../models/posting";
import { ErrorService } from "./error.service";

@Injectable({
    providedIn: "root"
})
export class PostingService{
    constructor(
        private http: HttpClient,
        private errorService: ErrorService
        ){
    }

    getAll(): Observable<Posting[]>{
       return this.http.get<Posting[]>('http://localhost:8080/api/postings').pipe(
        retry(2),
        catchError(this.errorHandler.bind(this))
       )
    }

    getTrue(): Observable<Posting[]>{
        return this.http.get<Posting[]>('http://localhost:8080/api/postings/true').pipe(
         retry(2),
         catchError(this.errorHandler.bind(this))
        )
    }

    getByDocDate(date : string, filter : boolean): Observable<Posting[]> {
        return this.http.get<Posting[]>('http://localhost:8080/api/postings/sortByDay', {
            params: new HttpParams()
                .set('date', date)
                .set('filter', filter)
        }).pipe(
            retry(2),
            catchError(this.errorHandler.bind(this))
        )
    }

    getByMonth(month : number, year : number, filter : boolean): Observable<Posting[]> {
        return this.http.get<Posting[]>('http://localhost:8080/api/postings/sortByMonth', {
            params: new HttpParams()
                .set('month', month)
                .set('year', year)
                .set('filter', filter)
        }).pipe(
            retry(2),
            catchError(this.errorHandler.bind(this))
        )
    }

    getByQuarter(quarter : number, year : number, filter : boolean): Observable<Posting[]> {
        return this.http.get<Posting[]>('http://localhost:8080/api/postings/sortByQuarter', {
            params: new HttpParams()
                .set('quarter', quarter)
                .set('year', year)
                .set('filter', filter)
        }).pipe(
            retry(2),
            catchError(this.errorHandler.bind(this))
        )
    }

    getByYear(year : number, filter : boolean): Observable<Posting[]> {
        return this.http.get<Posting[]>('http://localhost:8080/api/postings/sortByYear', {
            params: new HttpParams()
                .set('year', year)
                .set('filter', filter)
        }).pipe(
            retry(2),
            catchError(this.errorHandler.bind(this))
        )
    }

    private errorHandler(error: HttpErrorResponse){
        this.errorService.handle(error.message)
        return throwError(()=>error.message)
    }
}