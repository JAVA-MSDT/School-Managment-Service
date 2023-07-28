import { Component } from '@angular/core';

@Component({
  selector: 'school-aboutuspage',
  templateUrl: './aboutuspage.component.html',
  styleUrls: ['./aboutuspage.component.scss']
})
export class AboutuspageComponent {
  containerStyle: any = {
    backgroundColor: 'aqua',
    backgroundImage:'url(assets/image/about_us.jpg)',
    backgroundRepeat:'no-repeat',
    backgroundSize: 'cover',
    height:'300px',
  }
  
  isTitleDisplay = false;
  isDiscriptionDisplay = false;
}
