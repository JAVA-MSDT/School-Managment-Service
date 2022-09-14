import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import {
  TranslateLoader,
  TranslateModule,
  TranslateService,
} from '@ngx-translate/core';
import { DescriptionTranslatorPipe } from '../pipes/description-translator.pipe';
import { PageNotFoundComponent } from './errors/page-not-found/page-not-found.component';
import { ScrollTopComponent } from './scroll-top/scroll-top.component';
import { ReactiveFormsModule } from '@angular/forms';
import { CarouselComponent } from './reusable-componenet/carousel/carousel.component';
import { ImageDecoderPipe } from '../pipes/image-decoder.pipe';


// loader module
export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}

const components = [
  HeaderComponent,
  FooterComponent,
  DescriptionTranslatorPipe,
  PageNotFoundComponent,
  ScrollTopComponent,
  ImageDecoderPipe,
];
@NgModule({
  declarations: [NavBarComponent, ...components, CarouselComponent],
  imports: [
    CommonModule,
    RouterModule,
    HttpClientModule,
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [HttpClient],
      },
    }),
    ReactiveFormsModule,
  ],
  exports: [TranslateModule, HttpClientModule, ReactiveFormsModule, ...components],
  providers: [TranslateService],
})
export class SharedModule {}
