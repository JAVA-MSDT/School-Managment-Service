import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ROUTER_PATH } from './app-config/router-path-const';
import { AboutUsComponent } from './public-pages/about-us/about-us.component';
import { LoginComponent } from './public-pages/login/login.component';
import { MainPageComponent } from './public-pages/main-page/main-page.component';

const routes: Routes = [
  {
    path: ROUTER_PATH.home,
    component: MainPageComponent
  },
  {
    path: ROUTER_PATH.aboutUs,
    component: AboutUsComponent
  },
  {
    path: ROUTER_PATH.login,
    component: LoginComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
