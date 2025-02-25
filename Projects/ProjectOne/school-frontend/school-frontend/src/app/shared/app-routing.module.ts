import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { COMMON_CONSTANTS } from '../app-config/app.conestant';
import { ROUTER_CONSTANTS } from '../app-config/router.constants';
import { HomepageComponent } from '../public/home-page/homepage.component';
import { CoursesPageComponent } from '../public/courses-page/courses-page.component';
import { AboutuspageComponent } from '../public/about-us-page/aboutuspage.component';
import { MediaPageComponent } from '../public/media-page/media-page.component';

const routes: Routes = [
  {
    path: COMMON_CONSTANTS.EMPTY_STRING,
    redirectTo: ROUTER_CONSTANTS.CONTEXT,
    pathMatch: 'full',
  },
  {
    path: ROUTER_CONSTANTS.CONTEXT,
    component: HomepageComponent,
  },  
  {
    path: ROUTER_CONSTANTS.COURSES,
    component: CoursesPageComponent,
  }, 
  {
    path: ROUTER_CONSTANTS.ABOUT_US,
    component: AboutuspageComponent,
  },  
  {
    path: ROUTER_CONSTANTS.MEDIA,
    component: MediaPageComponent,
  },
  // {
  //   path: ROUTER_CONSTANTS.LOGIN,
  //   component: undefined,
  // },
  // {
  //   path: ROUTER_CONSTANTS.CONTACTS,
  //   component: undefined,
  //   // canActivate: [AuthGuard],
  // },
  // {
  //   path: ROUTER_CONSTANTS.NEW,
  //   component: undefined,
  //   // canActivate: [AuthGuard],
  // },
  {
    path: ROUTER_CONSTANTS.ANY_PAGE,
    redirectTo: ROUTER_CONSTANTS.CONTEXT
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
