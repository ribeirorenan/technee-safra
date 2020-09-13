import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from 'src/app/pages/consumer/shared/user/user.service';
import { User } from 'src/app/pages/consumer/shared/user/user.model';

@Component({
  selector: 'app-manage-account',
  templateUrl: './manage-account.component.html',
  styleUrls: ['./manage-account.component.scss']
})
export class ManageAccountComponent implements OnInit {

  account: Account;
  user: User;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private userSerivce: UserService
  ) { }

  ngOnInit(): void {
    this.route.data.subscribe(
      (account) => {
        this.account = history.state.data;
        this.user = this.userSerivce.getUser();
        console.log(this.account)
      })
  }

  backToHome() {
    this.router.navigate(['pages/consumer/home']);
  }

  revokePermission() {
    
  }

}
