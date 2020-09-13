import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Account } from '../../shared/account/account.model';
import { AccountService } from '../../shared/account/account.service';

@Component({
  selector: 'app-home-accounts',
  templateUrl: './home-accounts.component.html',
  styleUrls: ['./home-accounts.component.scss']
})
export class HomeAccountsComponent implements OnInit {

  accounts: Account[];

  constructor(
    private router: Router,
    private accountService: AccountService
  ) { }

  ngOnInit(): void {
    this.accountService.getAccounts().subscribe(
      (res: Account[]) => {
        this.accounts = res;
        console.log(this.accounts);
      }
    );
  }

  openAddAccount() {
    this.router.navigate(['pages/consumer/add-account'])
  }

}
