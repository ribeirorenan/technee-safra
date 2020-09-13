import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-accounts',
  templateUrl: './home-accounts.component.html',
  styleUrls: ['./home-accounts.component.scss']
})
export class HomeAccountsComponent implements OnInit {

  constructor(
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  openAddAccount() {
    this.router.navigate(['pages/consumer/add-account'])
  }

}
