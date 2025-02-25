import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { MainPageComponent } from './main-page/main-page.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { LoginComponent } from './login/login.component';
import { TrainingZoneComponent } from './trainings/training-zone/training-zone.component';
import { TrainingComponent } from './trainings/training/training.component';
import { SharedModule } from '../shared/shared.module';
import { UserComponent } from './user/user.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { GalleryComponent } from './gallery/gallery/gallery.component';
import { PhotosComponent } from './gallery/photos/photos.component';
import { VideosComponent } from './gallery/videos/videos.component';

const components = [
  MainPageComponent,
  AboutUsComponent,
  LoginComponent,
  TrainingZoneComponent,
  TrainingComponent,
  UserComponent,
  ContactUsComponent,
  GalleryComponent,
  PhotosComponent,
  VideosComponent,
];

@NgModule({
  declarations: [...components],
  imports: [CommonModule, BrowserModule, RouterModule, SharedModule],
  exports: [...components],
})
export class PublicPagesModule {}
