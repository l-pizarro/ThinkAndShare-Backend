import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VistaPrincipalComponent }      from './vista-principal/vista-principal.component';
import { IdeaComponent }      from './idea/idea.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'idea/:id', component: IdeaComponent },
  { path: 'home', component: VistaPrincipalComponent },
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
