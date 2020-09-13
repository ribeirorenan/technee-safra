import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-manage-auth',
  templateUrl: './manage-auth.component.html',
  styleUrls: ['./manage-auth.component.scss']
})
export class ManageAuthComponent implements OnInit {

  constructor(
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  backToHome() {
    this.router.navigate(['pages/consumer/home']);
  }

  revokePermission() {
    
  }

}
