import { UserService } from '@/app/shared/services/user.service';
import { Component, inject } from '@angular/core';

@Component({
  selector: 'app-add',
  imports: [],
  templateUrl: './add.html',
  styleUrl: './add.css',
})
export class Add {
  protected userService = inject(UserService);

  constructor() {
    this.userService.findUser()
    console.log(this.userService.getUser())
  }
}
