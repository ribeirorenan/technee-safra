import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { AccountService } from '../../shared/account/account.service';
import { Account } from '../../shared/account/account.model';

@Component({
  selector: 'app-add-account',
  templateUrl: './add-account.component.html',
  styleUrls: ['./add-account.component.scss']
})
export class AddAccountComponent implements OnInit {

  displayName: string = '';
  clientId: string = '';
  secret: string = '';

  constructor(
    private router: Router,
    private accountService: AccountService
  ) { }

  ngOnInit(): void {
    this.accountService.getAccounts();
  }

  backToHome() {
    this.router.navigate(['pages/consumer/home']);
  }


  addAccount() {
    let account = new Account();

    account.displayName = this.displayName;
    account.clientId = this.clientId;
    account.secret = this.secret;

    this.accountService.addAccount(account).subscribe(
      (res) => {
        this.router.navigate(['pages/consumer/home']);
      },
      (error) => {
        console.log(error);
      }
    );

  }
}
