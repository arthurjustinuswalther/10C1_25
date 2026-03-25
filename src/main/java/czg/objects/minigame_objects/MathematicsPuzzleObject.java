package czg.objects.minigame_objects;

import czg.util.Images;

import java.awt.*;
import java.util.Random;

public enum MathematicsPuzzleObject {
    // Level 1
    // Herz
    P_00("/assets/minigames/mathematics/puzzle_1_1.png", 7, new double[][][] {
        {
            {0.33, 0.4, 0.0},
            {0.0, 0.0, 180.0},
            {0.33, 0.0, 90.0},
            {0.5, 0.0, 0.0},
            {0.33, 0.4, 180.0},
            {0.5, 0.2, 90.0},
            {0.33, 0.6, 0.0}
        },
        {
            {0.0, 0.4, 0.0},
            {0.66, 0.0, 0.0},
            {0.33, 0.0, 0.0},
            {0.0, 0.2, 0.0},
            {0.33, 0.6, 0.0},
            {0.5, 0.4, 0.0},
            {0.17, 0.0, 0.0}
        }
    }),
    // Schwan
    P_01("/assets/minigames/mathematics/puzzle_1_2.png", 7, new double[][][] {
        {
            {0.0, 0.55, 0.0},
            {0.2, 0.55, 45.0},
            {0.68, 0.55, 315.0}, // wird irgendwie zuerst positioniert und dann rotiert, obwohl ich das eigentlich andersherum gemacht habe. machste nix
            {0.75, 0.0, 225.0}, // same here
            {0.75, 0.47, 0.0},
            {0.58, 0.0, 0.0},
            {0.58, 0.31, 0.0}
        }
    }),
    // Berg (aktuell noch Schwan)
    P_02("/assets/minigames/mathematics/puzzle_1_2.png", 7, new double[][][] {
        {
            {0.0, 0.55, 0.0},
            {0.2, 0.55, 45.0},
            {0.68, 0.55, 315.0}, // wird irgendwie zuerst positioniert und dann rotiert, obwohl ich das eigentlich andersherum gemacht habe. machste nix
            {0.75, 0.0, 225.0}, // same here
            {0.75, 0.47, 0.0},
            {0.58, 0.0, 0.0},
            {0.58, 0.31, 0.0}
        }
    }),

    // Level 2
    P_10("/assets/minigames/mathematics/puzzle_1_1.png", 1, new double[][][] {
        {
            {0.33, 0.4, 0.0},
            {0.0, 0.0, 180.0},
            {0.33, 0.0, 90.0},
            {0.5, 0.0, 0.0},
            {0.33, 0.4, 180.0},
            {0.5, 0.2, 90.0},
            {0.33, 0.6, 0.0}
        }
    }),
    P_11("/assets/minigames/mathematics/puzzle_1_1.png", 1, new double[][][] {
        {
            {0.33, 0.4, 0.0},
            {0.0, 0.0, 180.0},
            {0.33, 0.0, 90.0},
            {0.5, 0.0, 0.0},
            {0.33, 0.4, 180.0},
            {0.5, 0.2, 90.0},
            {0.33, 0.6, 0.0}
        }
    }),
    P_12("/assets/minigames/mathematics/puzzle_1_1.png", 1, new double[][][] {
        {
            {0.33, 0.4, 0.0},
            {0.0, 0.0, 180.0},
            {0.33, 0.0, 90.0},
            {0.5, 0.0, 0.0},
            {0.33, 0.4, 180.0},
            {0.5, 0.2, 90.0},
            {0.33, 0.6, 0.0}
        }
    }),

    P_20("/assets/minigames/mathematics/puzzle_1_1.png", 0, new double[][][] {
        {
            {0.33, 0.4, 0.0},
            {0.0, 0.0, 180.0},
            {0.33, 0.0, 90.0},
            {0.5, 0.0, 0.0},
            {0.33, 0.4, 180.0},
            {0.5, 0.2, 90.0},
            {0.33, 0.6, 0.0}
        }
    }),
    P_21("/assets/minigames/mathematics/puzzle_1_1.png", 0, new double[][][] {
        {
            {0.33, 0.4, 0.0},
            {0.0, 0.0, 180.0},
            {0.33, 0.0, 90.0},
            {0.5, 0.0, 0.0},
            {0.33, 0.4, 180.0},
            {0.5, 0.2, 90.0},
            {0.33, 0.6, 0.0}
        }
    }),
    P_22("/assets/minigames/mathematics/puzzle_1_1.png", 0, new double[][][] {
        {
            {0.33, 0.4, 0.0},
            {0.0, 0.0, 180.0},
            {0.33, 0.0, 90.0},
            {0.5, 0.0, 0.0},
            {0.33, 0.4, 180.0},
            {0.5, 0.2, 90.0},
            {0.33, 0.6, 0.0}
        }
    });

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
    
    public static final int MARGIN_OF_ERROR = 20;

    public final Image sprite;
    public final int amountOfGivenPieces;
    public final double[][][] solutions;

    MathematicsPuzzleObject(String path, int amountOfGivenPieces, double[][][] solutions) {
        this.sprite = Images.get(path);
        this.amountOfGivenPieces = amountOfGivenPieces;
        this.solutions = solutions;
    }

    public static MathematicsPuzzleObject getPuzzle(int level) {
        int r = (int) (new Random().nextDouble() * 3);

        return PUZZLES[level][r];
    }
    
    public boolean isSolutionValid(TangramPieceObject[] pieces, int x, int y, int width, int height) {
        for(double[][] solution : solutions) {
            // Große Dreiecke
            boolean normal =
                matches(pieces[0], solution[0], 0.0, x, y, width, height) &&
                matches(pieces[1], solution[1], 0.0, x, y, width, height);

            boolean swapped =
                matches(pieces[0], solution[1], -90.0, x, y, width, height) &&
                matches(pieces[1], solution[0], 90.0, x, y, width, height);

            if(!(normal || swapped)) continue;

            // Mittleres Dreieck
            if(!matches(pieces[2], solution[2], 0.0, x, y, width, height)) continue;

            // Kleine Dreiecke
            normal =
                matches(pieces[3], solution[3], 0.0, x, y, width, height) &&
                matches(pieces[4], solution[4], 0.0, x, y, width, height);

            swapped =
                matches(pieces[3], solution[4], -90.0, x, y, width, height) &&
                matches(pieces[4], solution[3], 90.0, x, y, width, height);

            if(!(normal || swapped)) continue;

            // Parallelogramm
            pieces[5].rotation %= 180;
            if(!matches(pieces[5], solution[5], 0.0, x, y, width, height)) continue;

            // Quadrat
            pieces[6].rotation %= 90;
            if(!matches(pieces[6], solution[6], 0.0, x, y, width, height)) continue;
            
            return true;
        }
        
        return false;
    }

    private boolean matches(TangramPieceObject piece, double[] solution, double rotOffset, int x, int y, int width, int height) {
        return Math.abs(piece.x - (x + solution[0]*width)) <= MARGIN_OF_ERROR &&
                Math.abs(piece.y - (y + solution[1]*height)) <= MARGIN_OF_ERROR &&
                piece.rotation == solution[2] + rotOffset;
    }
    
    private void setGivenPieces(TangramPieceObject[] pieces, int x, int y, int width, int height) {
        int[] idx = new int[amountOfGivenPieces];
        for(int i = 0; i < amountOfGivenPieces; i++) {
            idx[i] = -1;
        }
        
        for(int i = 0; i < amountOfGivenPieces; i++) {
            int rIdx;
            while(true) {
                rIdx = (int) (7 * new Random().nextDouble());
                boolean validIdx = true;
                for(int j = 0; j < amountOfGivenPieces; j++) {
                    if (idx[j] == rIdx) {
                        validIdx = false;
                        break;
                    }
                }
                if(validIdx) break;
            }
            idx[i] = rIdx;
        }
        
        int rSolution = (int) (solutions.length * new Random().nextDouble());
        for(int i : idx) {
            pieces[i].setRotation(solutions[rSolution][i][2]);
            pieces[i].x = (int) (x + solutions[rSolution][i][0]*width);
            pieces[i].y = (int) (y + solutions[rSolution][i][1]*height);
        }
    }
    
    public void reset(TangramPieceObject[] pieces, int x, int y, int size, int px, int py, int pwidth, int pheight) {
        TangramPieceObject.generatePacked(pieces, x, y, size, size);
        setGivenPieces(pieces, px, py, pwidth, pheight);
    }
}
