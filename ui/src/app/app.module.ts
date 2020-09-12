import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NbThemeModule, NbLayoutModule, NbCardModule, NbUserComponent, NbUserModule, NbIconModule, NbButtonModule } from '@nebular/theme';
import { NbEvaIconsModule } from '@nebular/eva-icons';
import { ConsumerComponent } from './pages/consumer/consumer.component';
import { HomeAccountsComponent } from './pages/consumer/home-accounts/home-accounts.component';
import { HomeAuthorizationsComponent } from './pages/consumer/home-authorizations/home-authorizations.component';

@NgModule({
  declarations: [
    AppComponent,
    ConsumerComponent,
    HomeAccountsComponent,
    HomeAuthorizationsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    NbThemeModule.forRoot({ name: 'default' }),
    NbCardModule,
    NbLayoutModule,
    NbEvaIconsModule,
    NbUserModule,
    NbButtonModule,
    NbIconModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
