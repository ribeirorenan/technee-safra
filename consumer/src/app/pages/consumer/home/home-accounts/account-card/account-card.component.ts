import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-account-card',
  templateUrl: './account-card.component.html',
  styleUrls: ['./account-card.component.scss']
})
export class AccountCardComponent implements OnInit {

  @Input()
  account: Account;

  constructor(
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  openManageAccount() {
    this.router.navigate(['pages/consumer/manage-account'], {
      state: {
        data: this.account
      }
    })
  }

}
