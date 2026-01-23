import {Component, inject, OnInit, signal, WritableSignal} from '@angular/core';
import {AppHeader} from '@/app/shared/components/app-header/header';
import {ButtonsContainer} from '@/app/features/theme/components/buttons-container/buttons-container';
import {ThemeService} from '@/app/features/theme/services/theme/theme.service';
import {filter, Observable} from 'rxjs';
import Theme from '@/app/shared/types/theme';
import {NavigationEnd, Router} from '@angular/router';

@Component({
  selector: 'app-theme',
  imports: [
    AppHeader,
    ButtonsContainer
  ],
  templateUrl: './theme.component.html',
  styleUrl: './theme.component.css',
})
export class ThemeComponent { // ← Sacar "implements OnInit"
  private themeService = inject(ThemeService);
  private router = inject(Router); // ← Inyectar Router
  protected themes: WritableSignal<Theme[]> = signal<Theme[]>([]);

  constructor() { // ← Cambiar ngOnInit por constructor
    // Escuchar navegaciones
    this.router.events.pipe(
      filter(event => event instanceof NavigationEnd)
    ).subscribe(() => {
      this.loadThemes();
    });

    // Carga inicial
    this.loadThemes();
  }

  private loadThemes(): void { // ← Extraer lógica a método privado
    this.themeService.getAll().subscribe({
      next: (themes) => this.themes.set(themes),
      error: (error: unknown) => console.error(error)
    });
  }
}
