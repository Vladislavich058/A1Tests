import {Component, Input} from "@angular/core";
import { UserInterface } from "src/app/models/user";

@Component({
    selector: 'app-user',
    templateUrl: './user.component.html'
})

export class UserComponent{
    @Input() user: UserInterface
    
    constructor() { 
        // Initialization inside the constructor
        this.user = {
            name: "",
            age:0
        };
     }
}