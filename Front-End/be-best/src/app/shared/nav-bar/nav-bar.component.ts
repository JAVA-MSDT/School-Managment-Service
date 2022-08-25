import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { LANG_CONSTANTS } from 'src/app/app-config/app.conestant';

@Component({
  selector: 'b-best-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.sass']
})
export class NavBarComponent implements OnInit {

  constructor(
    private translate: TranslateService,
  ) {
    translate.setDefaultLang(LANG_CONSTANTS.EN);
    this.useLanguage(LANG_CONSTANTS.EN);
  }

  ngOnInit(): void {
  }

  useLanguage(lang: string): void {
    this.translate.use(lang);
  }
  
}
