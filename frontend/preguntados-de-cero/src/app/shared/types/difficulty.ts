import GameTheme from './gameTheme';

interface Difficulty {
  id: number,
  level: number
  themes: GameTheme[]
}

export default Difficulty;
