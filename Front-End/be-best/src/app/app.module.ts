import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PublicPagesModule } from './public-pages/public-pages.module';
import { SharedModule } from './shared/shared.module';
import { DescriptionTranslatorPipe } from './pipes/description-translator.pipe';

@NgModule({
  declarations: [AppComponent],
  imports: [BrowserModule, AppRoutingModule, SharedModule, PublicPagesModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
