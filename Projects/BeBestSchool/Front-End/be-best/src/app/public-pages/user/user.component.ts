import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { API_PATH_NAME } from 'src/app/app-config/app.conestant';
import { User } from 'src/app/domains/user/user';
import { ApiService } from 'src/app/service/api/api.service';

@Component({
  selector: 'b-best-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.sass'],
})
export class UserComponent implements OnInit {
  readonly usersApi = API_PATH_NAME.USERS_PUBLIC_PATH;

  user: User = <User>{};
  userId!: string | null;

  constructor(private apiService: ApiService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe((param: ParamMap) => {
      this.userId = param.get('id');
      this.setUser(this.userId);
    });
  }

  setUser(teacherId: string | null): void {
    if (teacherId != null) {
      this.apiService.get<User>(this.usersApi + teacherId).subscribe((user) => {
        this.user = user;
        console.log(this.user);
      });
    }
  }
}
