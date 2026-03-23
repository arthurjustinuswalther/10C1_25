package czg.objects.minigame_objects;

import czg.MainWindow;
import czg.util.Images;

import java.awt.*;
import java.util.Random;

public enum MathematicsPuzzleObject {
    P_00("/assets/minigames/mathematics/puzzle_1_1.png", 0, new int[][][] {{{}}}),
    P_01("/assets/minigames/mathematics/puzzle_1_1.png", 0, new int[][][] {{{}}}),
    P_02("/assets/minigames/mathematics/puzzle_1_1.png", 0, new int[][][] {{{}}}),

    P_10("/assets/minigames/mathematics/puzzle_1_1.png", 0, new int[][][] {{{}}}),
    P_11("/assets/minigames/mathematics/puzzle_1_1.png", 0, new int[][][] {{{}}}),
    P_12("/assets/minigames/mathematics/puzzle_1_1.png", 0, new int[][][] {{{}}}),

    P_20("/assets/minigames/mathematics/puzzle_1_1.png", 0, new int[][][] {{{}}}),
    P_21("/assets/minigames/mathematics/puzzle_1_1.png", 0, new int[][][] {{{}}}),
    P_22("/assets/minigames/mathematics/puzzle_1_1.png", 0, new int[][][] {{{}}});

    public static final MathematicsPuzzleObject[][] PUZZLES = {
        {
            MathematicsPuzzleObject.P_00,
            MathematicsPuzzleObject.P_01,
            MathematicsPuzzleObject.P_02
        }, {
            MathematicsPuzzleObject.P_10,
            MathematicsPuzzleObject.P_11,
            MathematicsPuzzleObject.P_12
        }, {
            MathematicsPuzzleObject.P_20,
            MathematicsPuzzleObject.P_21,
            MathematicsPuzzleObject.P_22
        }
    };
    
    public static final int marginOfError = 10;

    public final Image sprite;
    public final int amountOfGivenPieces;
    public final int[][][] solutions;

    MathematicsPuzzleObject(String path, int amountOfGivenPieces, int[][][] solutions) {
        this.sprite = Images.get(path);
        this.amountOfGivenPieces = amountOfGivenPieces;
        this.solutions = solutions;
    }

    public static MathematicsPuzzleObject getPuzzle(int level) {
        int r = (int) (new Random().nextDouble() * 3);

        return PUZZLES[level][r];
    }
    
    public boolean isSolutionValid(TangramPieceObject[] pieces) {
        for(int[][] solution : this.solutions) {
            boolean isValid = true;
            
            for(int i = 0; i < pieces.length; i++) {
                TangramPieceObject currentPiece = pieces[i];
                if(
                    currentPiece.x < solution[i][0] - marginOfError || currentPiece.x > solution[i][0] + marginOfError || // Überprüfung der X-Koordinate
                    currentPiece.y < solution[i][1] - marginOfError || currentPiece.y > solution[i][1] + marginOfError || // Überprüfung der Y-Koordinate
                    currentPiece.rotation == solution[i][2] // Überprüfung der Rotation
                ) isValid = false;
            }
            
            if(isValid) return true;
        }
        
        return false;
    }
    
    public void setGivenPieces() {
        int[] idx = new int[this.amountOfGivenPieces];
        
        for(int i = 0; i < this.amountOfGivenPieces; i++) {
            int rIdx;
            while(true) {
                rIdx = (int) (this.amountOfGivenPieces * new Random().nextDouble());
                boolean validIdx = true;
                for(int j = 0; j < this.amountOfGivenPieces; j++) {
                    if(idx[j] == rIdx) {
                        validIdx = false;
                    }
                }
                if(validIdx) break;
            }
            idx[i] = rIdx;
        }
        
        int rSolution = (int) (this.solutions.length * new Random().nextDouble());
        for(int i : idx) {
            TangramPieceObject.PIECES[i].x = this.solutions[rSolution][i][0];
            TangramPieceObject.PIECES[i].y = this.solutions[rSolution][i][1];
            TangramPieceObject.PIECES[i].rotation = this.solutions[rSolution][i][2];
        }
    }
    
    public void reset() {
        int size = MainWindow.HEIGHT / 2;
        double scale = Images.get("/assets/minigames/mathematics/tangram_packed.png").getWidth(null) / (double) size;
        
        TangramPieceObject.generatePacked((MainWindow.HEIGHT - size) / 2, (MainWindow.HEIGHT - size) / 2, size, size);
        this.setGivenPieces();
    }
}
