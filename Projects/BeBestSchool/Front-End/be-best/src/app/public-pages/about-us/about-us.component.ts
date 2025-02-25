import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { API_NAME, API_PATH_NAME } from 'src/app/app-config/app.conestant';
import { ROUTER_PATH } from 'src/app/app-config/router-path-const';
import { PublicInfo } from 'src/app/domains/shared/public-info';
import { Subject } from 'src/app/domains/training/subject';
import { User } from 'src/app/domains/user/user';
import { ApiService } from 'src/app/service/api/api.service';

@Component({
  selector: 'dc-about-us',
  templateUrl: './about-us.component.html',
  styleUrls: ['./about-us.component.sass'],
})
export class AboutUsComponent implements OnInit {
  readonly publicInfoApi = API_PATH_NAME.PUBLIC_INFO_PATH;
  readonly teachersApi = API_PATH_NAME.USERS_PUBLIC_PATH;
  readonly subjectsApi = API_PATH_NAME.SUBJECTS_PUBLIC_PATH;

  publicInfo: PublicInfo = <PublicInfo>{};
  teachers: User[] = [];
  subjects: Subject[] = [];

  constructor(
    private apiService: ApiService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.getPublicInfo();
    this.getTeachers();
    this.getSubjects();
  }

  getPublicInfo(): void {
    this.apiService
      .get<PublicInfo[]>(this.publicInfoApi)
      .subscribe((publicInfo) => {
        this.publicInfo = publicInfo[0];
      });
  }

  getTeachers(): void {
    this.apiService.get<User[]>(this.teachersApi).subscribe((teachers) => {
      this.teachers = teachers;
    });
  }

  getSubjects(): void {
    this.apiService.get<Subject[]>(this.subjectsApi).subscribe((subjects) => {
      this.subjects = subjects;
    });
  }

  goToTeacherPage(teacherId: string | undefined): void {
    if (teacherId) {
      console.log(teacherId);
      this.router.navigate([
        ROUTER_PATH.users + ROUTER_PATH.contextPath + teacherId,
      ]);
    }
  }
}
