import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ROUTER_PATH } from 'src/app/app-config/router-path-const';
import { User } from 'src/app/domains/user/user';

@Component({
  selector: 'b-best-profile-card',
  templateUrl: './profile-card.component.html',
  styleUrls: ['./profile-card.component.sass'],
})
export class ProfileCardComponent implements OnInit {
  @Input() teacher: User = <User>{};
  constructor(private router: Router) {}

  ngOnInit(): void {}

  goToTeacherPage(teacherId: string | undefined): void {
    if (teacherId) {
      console.log(teacherId);
      this.router.navigate([
        ROUTER_PATH.users + ROUTER_PATH.contextPath + teacherId,
      ]);
    }
  }

  getLeftImageStyle(image: string) {
    return {
      'background-image': 'url(' + image + ')',
      'background-position': 'center',
      'background-repeat': 'no-repeat',
      'background-size': 'cover',
    };
  }
}
