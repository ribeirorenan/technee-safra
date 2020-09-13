import { Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { UserService } from '../user/user.service';

@Injectable()
export class AuthorizationService implements OnInit {

    private consumerApi = environment.localAPi + 'consumer';

    constructor(
        private http: HttpClient,
        private userService: UserService
    ){}

    ngOnInit(): void {
    }

    getAuthorizations() {
        return this.http.get(this.consumerApi + '/' + 
        this.userService.getUser().id + '/authorization');
    }

}