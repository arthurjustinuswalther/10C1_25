/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package czg.objects.minigame_objects;

import czg.util.Images;

import java.awt.*;

public enum TangramPieceObject {
    TRIANGLE_BIG_1("/assets/minigames/mathematics/tangram_piece_00.png"),
    TRIANGLE_BIG_2("/assets/minigames/mathematics/tangram_piece_01.png"),
    TRIANGLE_MEDIUM("/assets/minigames/mathematics/tangram_piece_02.png"),
    TRIANGLE_SMALL_1("/assets/minigames/mathematics/tangram_piece_03.png"),
    TRIANGLE_SMALL_2("/assets/minigames/mathematics/tangram_piece_04.png"),
    PARALLELOGRAM("/assets/minigames/mathematics/tangram_piece_05.png"),
    SQUARE("/assets/minigames/mathematics/tangram_piece_06.png");

    public final Image sprite;

   TangramPieceObject(String path) {
        this.sprite = Images.get(path);
    }
}
