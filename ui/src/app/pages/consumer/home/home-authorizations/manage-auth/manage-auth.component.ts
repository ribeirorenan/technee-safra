import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Authorization } from '../../../shared/authorization/authorization.model';

@Component({
  selector: 'app-manage-auth',
  templateUrl: './manage-auth.component.html',
  styleUrls: ['./manage-auth.component.scss']
})
export class ManageAuthComponent implements OnInit {

  authorization: Authorization

  constructor(
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.route.data.subscribe(
      (data) => {
        this.authorization = history.state.data;
      }
    )

    console.log(this.route.url)
  }

  backToHome() {
    this.router.navigate(['pages/consumer/home']);
  }

  revokePermission() {
    
  }

}
