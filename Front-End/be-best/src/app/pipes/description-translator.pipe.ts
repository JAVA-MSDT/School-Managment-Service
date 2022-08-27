import { Pipe, PipeTransform } from '@angular/core';
import { LANG_CONSTANTS } from '../app-config/app.conestant';
import { Description } from '../domains/shared/map-string';

@Pipe({
  name: 'descriptionTranslator',
  pure: false
})
export class DescriptionTranslatorPipe implements PipeTransform {

  description!: string;
   
  
  transform(value: Description, ...args: unknown[]): unknown {
    const lang: string | null = localStorage.getItem(LANG_CONSTANTS.LANG_ATTR);
    
    if(lang === LANG_CONSTANTS.EN) {
      this.description = value['EN'];
    }

    if(lang === LANG_CONSTANTS.PL) {
      this.description = value['PL'];
    }
    return this.description;
  }

}
