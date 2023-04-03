import { Component } from '@angular/core';
import { UserInterface } from './models/user';
import {users as data} from './data/user'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'my-app';

  users: UserInterface[] = data
}
