import { Pipe, PipeTransform } from '@angular/core';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';
import { FILE_METADATE } from '../app-config/app.conestant';
import { Image } from 'src/app/domains/shared/image';


@Pipe({
  name: 'imageDecoder'
})
export class ImageDecoderPipe implements PipeTransform {

  constructor(private sanitizer: DomSanitizer) {}
  transform(image: Image, ...args: unknown[]): SafeUrl {
    let objectURL =
      FILE_METADATE.IMAGE_DATA +
      image.extension +
      ';' +
      FILE_METADATE.BASE64 +
      ',' +
      image.imageBase64;
    return this.sanitizer.bypassSecurityTrustUrl(objectURL);
  }

}
