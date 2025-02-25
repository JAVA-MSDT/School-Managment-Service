import { Component, Input, OnInit } from '@angular/core';
import { API_PATH_NAME } from 'src/app/app-config/app.conestant';
import { Image } from 'src/app/domains/shared/image';
import { ApiService } from 'src/app/service/api/api.service';

@Component({
  selector: 'b-best-photos',
  templateUrl: './photos.component.html',
  styleUrls: ['./photos.component.sass']
})
export class PhotosComponent implements OnInit {

  readonly imagesApi = API_PATH_NAME.IMAGES_PUBLIC_PATH;
  @Input() images: Image[] = [];
  @Input() carouselOneImages: Image[] = [];
  constructor() {}

  ngOnInit(): void {

  }

}
