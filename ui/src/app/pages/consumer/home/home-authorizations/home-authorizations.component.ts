import { Component, OnInit } from '@angular/core';
import { AuthorizationService } from '../../shared/authorization/authorization.service';
import { Authorization } from '../../shared/authorization/authorization.model';

@Component({
  selector: 'app-home-authorizations',
  templateUrl: './home-authorizations.component.html',
  styleUrls: ['./home-authorizations.component.scss']
})
export class HomeAuthorizationsComponent implements OnInit {

  authorizations: Authorization[];

  constructor(
    private authorizationService: AuthorizationService
  ) { }

  ngOnInit(): void {
    this.authorizationService.getAuthorizations().subscribe(
      (res: Authorization[]) => {
        this.authorizations = res;
      }
    );
  }

}
