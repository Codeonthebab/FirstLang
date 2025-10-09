import React, { useEffect, useRef } from "react";
import Phaser from "phaser";

class GameScene extends Phaser.Scene {
  
  // player 컨테이너
  private playerContainer!: Phaser.GameObjects.Container;
  // 괭이 'hoe', 씨앗 'seed' 저장 변수
  private currentTool: "hoe" | "seed" = "hoe";
  private toolIcon!: Phaser.GameObjects.Image;
  private cursors!: Phaser.Types.Input.Keyboard.CursorKeys;

  constructor() {
    super("GameScene");
  }

  preload() {
    // Tiled에서 사용할 '마스터 팔레트' 이미지
    this.load.spritesheet(
      "terrain_tiles",
      "assets/Sunnyside_World_ASSET_PACK_V2.1/Sunnyside_World_Assets/Tileset/spr_tileset_sunnysideworld_16px.png",
      { frameWidth: 16, frameHeight: 16 } 
    );

    // Tiled JSON 맵 파일 경로
    this.load.tilemapTiledJSON(
      "farm_map",
      "assets/Sunnyside_World_ASSET_PACK_V2.1/farm.json"
    );
    
    // 캐릭터 파츠별 소환
    this.load.spritesheet (
      "base_dig",
      "assets/Sunnyside_World_ASSET_PACK_V2.1/Sunnyside_World_Assets/Characters/Human/DIG/base_dig_strip13.png",
      {frameWidth: 16, frameHeight: 16 }
    );
    this.load.spritesheet (
      "bowlhair_dig",
      "assets/Sunnyside_World_ASSET_PACK_V2.1/Sunnyside_World_Assets/Characters/Human/DIG/bowlhair_dig_strip13.png",
      {frameWidth: 16, frameHeight: 16}
    );
  }
  create() {
    const map = this.make.tilemap({ key: "farm_map" });
    const tileset = map.addTilesetImage("terrain", "terrain_tiles");

    // Tiled에서 만든 레이어 이름('Ground')을 사용
    if (tileset) {
      const groundLayer = map.createLayer("Ground", tileset, 0, 0);

      // 플레이어 컨테이너
      this.anims.create({
        key: 'player_dig_base',
        frames: this.anims.generateFrameNumbers('base_dig', {start:0, end:12}),
        frameRate: 10,
        repeat: -1
      });
      this.anims.create({
        key: 'player_dig_hair',
        frames: this.anims.generateFrameNumbers('bowlhair_dig', {start: 0, end: 12}),
        frameRate: 10,
        repeat: -1
      });

      const body = this.add.sprite(0, 0, 'base_dig');
      const hair = this.add.sprite(0,0, 'bowlhair_dig');

      // 캐릭터 컨테이너 (*파츠 포함)
      this.playerContainer = this.add.container(400, 300, [body, hair]);
      this.physics.world.enable(this.playerContainer);
      (this.playerContainer.body as Phaser.Physics.Arcade.Body).setSize(16,20).setOffset(8,12);

      // 캐릭터 애니메이션
      body.play('player_dig_base');
      hair.play('player_dig_hair');

      this.cursors = this.input.keyboard!.createCursorKeys();

      // UI, 상태 관리 로직, 마우스 리스너
      if (groundLayer) {
        this.toolIcon = this.add
          .image(40, 40, "terrain_tiles", 691)
          .setScrollFactor(0);
        this.toolIcon.setScale(2);
        
        // 키보드로 도구 바꿈 기능
        this.input.keyboard?.on('keydown-ONE', () => {
          this.currentTool = 'hoe';
          console.log('도구 변경 : 괭이');
          this.toolIcon.setFrame(691); // 괭이질 대상 잔디 타일 지정 아이콘
        });
        this.input.keyboard?.on('keydown-TWO', () => {
          this.currentTool = 'seed';
          console.log('도구 변경 : 씨앗');
          this.toolIcon.setFrame(457);
        });

        // 마우스 리스너
        this.input.on('pointerdown', (pointer: Phaser.Input.Pointer) => {
          const worldPoint = pointer.positionToCamera(
            this.cameras.main
          ) as Phaser.Math.Vector2;
          const tile = groundLayer?.getTileAtWorldXY(
            worldPoint.x,
            worldPoint.y
          );

          if (tile) {
            // 타일에서 어떤 타일에 상호작용 시킬지
            const GRASS_TILE_INDEX = 457; // 흙 타일
            const TILLED_SOIL_INDEX = 1010; // 경작 흙 타일
            const PLANTED_SEED_INDEX = 818; // 씨앗심고 막아진 모양의 타일

            console.log(
              `클릭한 타일 좌표 : (${tile.x}, ${tile.y}), 타일 인덱스 : ${tile.index}`
            );

            // 괭이 들고, 클릭한 타일 '잔디'일 경우 분기점
            if (this.currentTool === 'hoe' && tile.index === GRASS_TILE_INDEX) {
              groundLayer.putTileAt(TILLED_SOIL_INDEX, tile.x, tile.y);
            }
            // '씨앗' 들고, 클릭한 타일이 '경작된 흙' 분기점
            else if (this.currentTool === 'seed' && tile.index === TILLED_SOIL_INDEX) {
              groundLayer.putTileAt(PLANTED_SEED_INDEX, tile.x, tile.y);
            }

            // 타일 인덱스 
            if (tile.index === 25) {
              groundLayer.putTileAt(43, tile.x, tile.y);
            }
          }
        });
      }
    }
  }

  update() {

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
      physics : {
        default : 'arcade',
        arcade : {
          gravity : { x : 0, y : 0 },
          debug: false
        }
      },
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
