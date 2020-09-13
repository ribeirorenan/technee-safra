import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ConsumerComponent } from './pages/consumer/consumer.component';
import { HomeComponent } from './pages/consumer/home/home.component';
import { AddAccountComponent } from './pages/consumer/home/add-account/add-account.component';
import { ManageAuthComponent } from './pages/consumer/home/home-authorizations/manage-auth/manage-auth.component';
import { ManageAccountComponent } from './pages/consumer/home/home-accounts/account-card/manage-account/manage-account.component';


const routes: Routes = [
  {
    path: 'pages',
    children: [{
      path: 'consumer', component: ConsumerComponent,
      children: [
        {path: 'home', component: HomeComponent},
        {path: 'add-account', component: AddAccountComponent},
        {path: 'manage-auth', component: ManageAuthComponent},
        {path: 'manage-account', component: ManageAccountComponent},
      ]
    }
      
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
