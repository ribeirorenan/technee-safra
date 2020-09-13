import { Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Account } from './account.model';
import { UserService } from '../user/user.service';

@Injectable()
export class AccountService implements OnInit {

    private accountApi = environment.localAPi + 'consumer';

    constructor(
        private http: HttpClient,
        private userService: UserService
    ){}

    ngOnInit(): void {
    }

    getAccounts() {
        return this.http.get(this.accountApi + '/' + 
        this.userService.getUser().id + '/account');
    }

    addAccount(account: Account) {
        return this.http.post(this.accountApi + '/' + 
            this.userService.getUser().id + '/account', account)
    }

}