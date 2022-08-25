import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';

import { MainPageComponent } from './main-page/main-page.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [MainPageComponent, AboutUsComponent, LoginComponent],
  imports: [CommonModule, BrowserModule ],
  exports: [MainPageComponent, AboutUsComponent, LoginComponent],
})
export class PublicPagesModule {}
