import { Component } from '@angular/core';

@Component({
  selector: 'school-courses-page',
  templateUrl: './courses-page.component.html',
  styleUrls: ['./courses-page.component.scss']
})
export class CoursesPageComponent {
  containerStyle: any = {
    backgroundColor: 'aqua',
    backgroundImage: 'url(assets/image/school_courses.jpg)',
    backgroundRepeat: 'no-repeat',
    backgroundSize: 'cover',
    height: '300px',
  }
  isTitleDisplay = false;
  isDiscriptionDisplay = false;
}
