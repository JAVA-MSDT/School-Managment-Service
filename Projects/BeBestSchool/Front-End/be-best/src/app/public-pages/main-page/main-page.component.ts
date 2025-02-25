import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { Router, ActivatedRoute } from '@angular/router';
import { API_NAME, API_PATH_NAME } from 'src/app/app-config/app.conestant';
import { Subject } from 'src/app/domains/training/subject';
import { Training } from 'src/app/domains/training/training';
import { User } from 'src/app/domains/user/user';
import { Image } from 'src/app/domains/shared/image';
import { ApiService } from 'src/app/service/api/api.service';

@Component({
  selector: 'dc-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.sass'],
})
export class MainPageComponent implements OnInit {
  trainings: Training[] = [];
  teachers: User[] = [];
  subjects: Subject[] = [];

  thumbnail: any;

  readonly trainingsApi = API_PATH_NAME.TRAININGS_PUBLIC_PATH;
  readonly teachersApi = API_PATH_NAME.USERS_PUBLIC_PATH;
  readonly subjectsApi = API_PATH_NAME.SUBJECTS_PUBLIC_PATH;

  constructor(
    private apiService: ApiService,
    private router: Router,
    private route: ActivatedRoute,
    private sanitizer: DomSanitizer,
  ) {}

  ngOnInit(): void {
    this.getTraining();
    this.getTeachers();
    this.getSubjects();
  }

  goToTrainingPage(trainingId: any) {
    this.router.navigate([trainingId], { relativeTo: this.route });
  }

  getTraining(): void {
    this.apiService.get<Training[]>(this.trainingsApi).subscribe((training) => {
      this.trainings = training.slice(0, 3);
      console.log(this.trainings);
    });
  }

  getSubjects(): void {
    this.apiService.get<Subject[]>(this.subjectsApi).subscribe((subjects) => {
      this.subjects = subjects.slice(0, 4);
    });
  }

  getTeachers(): void {
    this.apiService.get<User[]>(this.teachersApi).subscribe((teachers) => {
      this.teachers = teachers.slice(0, 3);
    });
  }
}
