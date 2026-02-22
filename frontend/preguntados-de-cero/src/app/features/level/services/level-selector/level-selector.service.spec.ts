import Difficulty from '@/app/shared/types/difficulty';
import { LevelSelectorService } from './level-selector.service'



describe.only("tests to level selector", () => {

  let service : LevelSelectorService;
  let difficulties : Difficulty[];

  beforeEach(() => {
    service = new LevelSelectorService();
    difficulties = [
      {
        id: 1,
        level: 1,
        themeNames : ["arpegio", "acorde"]
      },
      {
        id: 1,
        level: 1,
        themeNames : ["arpegio", "acorde"]
      }
    ]
  })

  test("a level selector have levels", () => {
    service.setLevels(difficulties);
    expect(service.isFirstLevel()).true;
  })
})
