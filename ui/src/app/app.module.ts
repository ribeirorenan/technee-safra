import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NbThemeModule, NbLayoutModule, NbCardModule, NbUserModule, NbIconModule, NbButtonModule, NbInputModule } from '@nebular/theme';
import { NbEvaIconsModule } from '@nebular/eva-icons';
import { ConsumerComponent } from './pages/consumer/consumer.component';
import { HomeAccountsComponent } from './pages/consumer/home/home-accounts/home-accounts.component';
import { AccountCardComponent } from './pages/consumer/home/home-accounts/account-card/account-card.component';
import { HomeComponent } from './pages/consumer/home/home.component';
import { HomeAuthorizationsComponent } from './pages/consumer/home/home-authorizations/home-authorizations.component';
import { AddAccountComponent } from './pages/consumer/home/add-account/add-account.component';
import { ManageAuthComponent } from './pages/consumer/home/home-authorizations/manage-auth/manage-auth.component';
import { AuthCardComponent } from './pages/consumer/home/home-authorizations/auth-card/auth-card.component';
import { ManageAccountComponent } from './pages/consumer/home/home-accounts/account-card/manage-account/manage-account.component';
import { AccountService } from './pages/consumer/shared/account/account.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { UserService } from './pages/consumer/shared/user/user.service';


@NgModule({
  declarations: [
    AppComponent,
    ConsumerComponent,
    HomeAccountsComponent,
    HomeAuthorizationsComponent,
    AccountCardComponent,
    AddAccountComponent,
    HomeComponent,
    ManageAuthComponent,
    AuthCardComponent,
    ManageAccountComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    NbThemeModule.forRoot({ name: 'cosmic' }),
    NbCardModule,
    NbLayoutModule,
    NbEvaIconsModule,
    NbUserModule,
    NbButtonModule,
    NbIconModule,
    NbInputModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    AccountService,
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
