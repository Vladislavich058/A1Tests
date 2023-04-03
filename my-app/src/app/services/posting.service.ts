import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Posting } from "../models/posting";

@Injectable({
    providedIn: "root"
})
export class PostingService{
    constructor(private http: HttpClient){
    }

    getAll(): Observable<Posting[]>{
       return this.http.get<Posting[]>('http://localhost:8080/api/postings')
    }
}