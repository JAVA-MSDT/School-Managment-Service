import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { LANG_CONSTANTS } from 'src/app/app-config/app.conestant';

@Component({
  selector: 'b-best-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.sass'],
})
export class NavBarComponent implements OnInit {
  selectLang: string | null = "en";
  constructor(private translate: TranslateService) {
    this.setLanguageOnStartup();
  }

  ngOnInit(): void {
     // this.selectLang = localStorage.getItem(LANG_CONSTANTS.LANG_ATTR);
  }

  useLanguage(lang: string): void {
    this.translate.use(lang);
    this.setLocalStorageLanguage(lang);
    this.selectLang = lang;
  }

  setLocalStorageLanguage(language: string): void {
    localStorage.setItem(LANG_CONSTANTS.LANG_ATTR, language);
  }

  setLanguageOnStartup(): void {
    const lang = localStorage.getItem(LANG_CONSTANTS.LANG_ATTR);
    if (lang) {
      this.translate.setDefaultLang(lang);
      this.useLanguage(lang);
    } else {
      this.translate.setDefaultLang(LANG_CONSTANTS.EN);
      this.useLanguage(LANG_CONSTANTS.EN);
      this.setLocalStorageLanguage(LANG_CONSTANTS.EN);    
    }
    this.selectLang = lang;
  }
}
