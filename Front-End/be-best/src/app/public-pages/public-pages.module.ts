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

const components = [MainPageComponent, AboutUsComponent, LoginComponent, TrainingZoneComponent, TrainingComponent];

@NgModule({
  declarations: [...components],
  imports: [CommonModule, BrowserModule, RouterModule, SharedModule ],
  exports: [...components],
})
export class PublicPagesModule {}
