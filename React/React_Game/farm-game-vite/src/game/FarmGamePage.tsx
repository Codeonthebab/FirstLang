import React, { useEffect, useRef } from "react";
import Phaser from "phaser";

class GameScene extends Phaser.Scene {
  constructor() {
    super("GameScene");
  }

  preload() {
    // Tiled에서 사용할 '마스터 팔레트' 이미지
    this.load.image(
      'terrain_tiles',
      'assets/Sunnyside_World_ASSET_PACK_V2.1/Sunnyside_World_Assets/Tileset/spr_tileset_sunnysideworld_16px.png'
    );

    // Tiled JSON 맵 파일 경로
    this.load.tilemapTiledJSON (
        'farm_map',
        'assets/Sunnyside_World_ASSET_PACK_V2.1/farm.json'
    );
  }
  create() {
    const map = this.make.tilemap({ key: 'farm_map' });

    // Tiled에서 타일셋에 부여한 이름('Terrain')과 preload의 이미지 키('terrain_tiles')를 연결
    const tileset = map.addTilesetImage(
      'terrain', 
      'terrain_tiles'
    );

    // Tiled에서 만든 레이어 이름('Ground')을 사용
    if (tileset) {
      map.createLayer('Ground', tileset, 0, 0);
    }
  }
}

// React 컴포넌트 코드는 수정할 필요 없습니다.
const FarmGamePage: React.FC = () => {
  const gameInstance = useRef<Phaser.Game | null>(null);
  useEffect(() => {
    if (gameInstance.current) {
      return;
    }
    const config: Phaser.Types.Core.GameConfig = {
      type: Phaser.AUTO,
      width: 800,
      height: 600,
      parent: "phaser-game-container",
      backgroundColor: "#000000",
      scene: [GameScene],
    };
    gameInstance.current = new Phaser.Game(config);
    return () => {
      gameInstance.current?.destroy(true);
      gameInstance.current = null;
    };
  }, []);

  return <div id="phaser-game-container" />;
};

export default FarmGamePage;
