import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomepageComponent } from './home-page/homepage.component';
import { CoursesPageComponent } from './courses-page/courses-page.component';
import { AboutuspageComponent } from './about-us-page/aboutuspage.component';
import { MediaPageComponent } from './media-page/media-page.component';
import { SharedModule } from '../shared/shared.module';
import { PrivateModule } from '../private/private.module';



@NgModule({
  declarations: [
    HomepageComponent,
    CoursesPageComponent,
    AboutuspageComponent,
    MediaPageComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    PrivateModule
  ],
  exports: [HomepageComponent]
})
export class PublicModule { }
