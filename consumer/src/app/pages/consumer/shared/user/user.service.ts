import { OnInit, Injectable } from '@angular/core';
import { User } from './user.model';

@Injectable()
export class UserService implements OnInit {

    user: User;

    ngOnInit(): void {
        this.user = new User();
        this.user.firstName = 'José';
        this.user.lastName = 'Silva';
        this.user.id = 1;
    }

    getUser() : User {
        this.user = new User();
        this.user.firstName = 'José';
        this.user.lastName = 'Silva';
        this.user.id = 1;
        return this.user;
    }

}