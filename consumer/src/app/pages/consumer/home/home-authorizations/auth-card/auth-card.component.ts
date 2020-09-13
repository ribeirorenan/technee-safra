import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Authorization } from '../../../shared/authorization/authorization.model';

@Component({
  selector: 'app-auth-card',
  templateUrl: './auth-card.component.html',
  styleUrls: ['./auth-card.component.scss']
})
export class AuthCardComponent implements OnInit {

  @Input()
  authorization: Authorization;

  constructor(
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  openManageAuth() {
    this.router.navigate(
      ['pages/consumer/manage-auth'],
      {
        state: {
          data: this.authorization
        }
      }
    )
  }

}
