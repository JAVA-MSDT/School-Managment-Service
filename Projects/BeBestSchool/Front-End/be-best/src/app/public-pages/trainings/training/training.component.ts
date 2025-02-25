import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { API_PATH_NAME } from 'src/app/app-config/app.conestant';
import { Subject } from 'src/app/domains/training/subject';
import { Training } from 'src/app/domains/training/training';
import { User } from 'src/app/domains/user/user';
import { ApiService } from 'src/app/service/api/api.service';

@Component({
  selector: 'b-best-training',
  templateUrl: './training.component.html',
  styleUrls: ['./training.component.sass'],
})
export class TrainingComponent implements OnInit {

  readonly trainingsApi = API_PATH_NAME.TRAININGS_PUBLIC_PATH;
  readonly subjectsApi = API_PATH_NAME.SUBJECTS_PUBLIC_PATH;
  readonly usersApi = API_PATH_NAME.USERS_PUBLIC_PATH;

  training: Training = <Training>{};
  subject: Subject = <Subject>{};
  user: User = <User>{};
  trainingId!: string | null;

  constructor(private apiService: ApiService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe((param: ParamMap) => {
      this.trainingId = param.get('id');
      if (this.trainingId != null) {
        this.apiService
          .get<Training>(this.trainingsApi + this.trainingId)
          .subscribe((training) => {
            this.training = training;

            this.setSubject(training.subjectId);
            this.setUser(training.teacherId);
          });
      }
    });
  }

  setSubject(subjectId: string): void {
    this.apiService
      .get<Subject>(this.subjectsApi + subjectId)
      .subscribe((subject) => {
        this.subject = subject;
        console.log(this.subject);
      });
  }

  setUser(teacherId: string): void {
    this.apiService.get<User>(this.usersApi + teacherId).subscribe((user) => {
      this.user = user;
      console.log(this.user);
    });
  }
}
