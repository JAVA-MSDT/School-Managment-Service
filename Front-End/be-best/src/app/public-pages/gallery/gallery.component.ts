import { Component, OnInit } from '@angular/core';
import { API_PATH_NAME } from 'src/app/app-config/app.conestant';
import { Image } from 'src/app/domains/shared/image';
import { ApiService } from 'src/app/service/api/api.service';

@Component({
  selector: 'b-best-gallery',
  templateUrl: './gallery.component.html',
  styleUrls: ['./gallery.component.sass'],
})
export class GalleryComponent implements OnInit {
  readonly imagesApi = API_PATH_NAME.IMAGES_PUBLIC_PATH;
  images: Image[] = [];
  constructor(private apiService: ApiService) {}

  ngOnInit(): void {
    this.getImages();
  }

  getImages(): void {
    this.apiService
      .get<Image[]>(this.imagesApi)
      .subscribe((images) => {
        this.images = images;
        console.log(images.length);
      });
  }
}
