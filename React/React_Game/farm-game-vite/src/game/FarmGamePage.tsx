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
    const map = this.make.tilemap({ key: "farm_map" });
    const tileset = map.addTilesetImage('terrain', 'terrain_tiles');

    // Tiled에서 만든 레이어 이름('Ground')을 사용
    if (tileset) {
      const groundLayer = map.createLayer('Ground', tileset, 0, 0);
      
      // 마우스 클릭 이벤트 감지 리스너
      this.input.on('pointerdown', (pointer : Phaser.Input.Pointer) => {
        const worldPoint = pointer.positionToCamera(this.cameras.main) as Phaser.Math.Vector2;
        const tile = groundLayer?.getTileAtWorldXY(worldPoint.x , worldPoint.y);

        if (tile) {
          console.log(`클릭한 타일 좌표 : (${tile.x}, ${tile.y}), 타일 인덱스 : ${tile.index}`);

          if (tile.index === 25) {
            groundLayer.putTileAt(43, tile.x, tile.y);
          }
        }
      });

    }
  }
}

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
