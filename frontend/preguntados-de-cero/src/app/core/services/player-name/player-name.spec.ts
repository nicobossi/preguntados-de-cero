import { TestBed } from '@angular/core/testing';

import { PlayerName } from './player-name';

describe('PlayerName', () => {
  let service: PlayerName;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PlayerName);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
