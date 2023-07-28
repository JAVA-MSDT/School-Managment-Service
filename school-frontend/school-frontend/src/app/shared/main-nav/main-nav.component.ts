import { Component } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'school-main-nav',
  templateUrl: './main-nav.component.html',
  styleUrls: ['./main-nav.component.scss']
})
export class MainNavComponent {
  isMenuCollapsed = true;
  usedLanguage: string;

  constructor(private translate: TranslateService){
    translate.addLangs(['en', 'pl'])
    translate.setDefaultLang('pl')
    this.usedLanguage = translate.getDefaultLang();
  }

  useLanguage(lang: string) {
    this.usedLanguage = lang;
    this.translate.use(lang);
    
  }

  getLanguages(): Array<string> {
    return this.translate.getLangs();
  }
}
