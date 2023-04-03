import {Component, Input} from '@angular/core'
import { Posting } from 'src/app/models/posting'

@Component({
    selector: 'app-posting',
    templateUrl: './posting.component.html'
})

export class PostingComponent{
    @Input() posting: Posting
}