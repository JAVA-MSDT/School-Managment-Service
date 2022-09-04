import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ROUTER_PATH } from './app-config/router-path-const';
import { AboutUsComponent } from './public-pages/about-us/about-us.component';
import { ContactUsComponent } from './public-pages/contact-us/contact-us.component';
import { LoginComponent } from './public-pages/login/login.component';
import { MainPageComponent } from './public-pages/main-page/main-page.component';
import { TrainingZoneComponent } from './public-pages/trainings/training-zone/training-zone.component';
import { TrainingComponent } from './public-pages/trainings/training/training.component';
import { UserComponent } from './public-pages/user/user.component';

const routes: Routes = [
  {
    path: ROUTER_PATH.home,
    component: MainPageComponent,
  },
  {
    path: ROUTER_PATH.aboutUs,
    component: AboutUsComponent,
  },
  {
    path: ROUTER_PATH.contactUs,
    component: ContactUsComponent,
  },
  {
    path: ROUTER_PATH.trainings,
    component: TrainingZoneComponent,
  },
  {
    path: ROUTER_PATH.trainings + ROUTER_PATH.contextPath + ROUTER_PATH.id,
    component: TrainingComponent,
  },
  {
    path: ROUTER_PATH.users + ROUTER_PATH.contextPath + ROUTER_PATH.id,
    component: UserComponent,
  },
  {
    path: ROUTER_PATH.login,
    component: LoginComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
