import {Component, inject, OnInit, signal, WritableSignal} from '@angular/core';
import {AppHeader} from '@/app/shared/components/app-header/header';
import {ButtonsContainer} from '@/app/features/theme/components/buttons-container/buttons-container';
import {ThemeService} from '@/app/features/theme/services/theme/theme.service';
import {Observable} from 'rxjs';
import Theme from '@/app/shared/types/theme';

@Component({
  selector: 'app-theme',
  imports: [
    AppHeader,
    ButtonsContainer
  ],
  templateUrl: './theme.component.html',
  styleUrl: './theme.component.css',
})
export class ThemeComponent implements OnInit{
  private themeService: ThemeService = inject(ThemeService);
  protected themes: WritableSignal<Theme[]> = signal<Theme[]>([]);

  ngOnInit(): void {
    const response: Observable<Theme[]> = this.themeService.getAll();
    response.subscribe({
      next: (themes) => this.themes.set(themes),
      error: (error : unknown) => console.error(error)
    })
  }

}
