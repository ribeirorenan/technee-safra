import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ConsumerComponent } from './pages/consumer/consumer.component';


const routes: Routes = [
  {
    path: 'pages',
    children: [
      {path: 'consumer', component: ConsumerComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
