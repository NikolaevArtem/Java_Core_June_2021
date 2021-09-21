package course_project.sea_battle.service;

import course_project.sea_battle.model.Field;

public class ComputeHelper {

    public static boolean chekCanPutShip(int pointA, int pointB, int[][] field) {
        if (pointA - 1 >= 0 && pointB - 1 >= 0 && pointA + 1 < 10 && pointB + 1 < 10) {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (field[pointA + i][pointB + j] != 0) return false;
                }
            }
        } else if (pointA - 1 < 0 && pointB - 1 >= 0 && pointB + 1 < 10) {
            for (int i = 0; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (field[pointA + i][pointB + j] != 0) return false;
                }
            }
        } else if (pointA - 1 >= 0 && pointB - 1 < 0 && pointA + 1 < 10) {
            for (int i = -1; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (field[pointA + i][pointB + j] != 0) return false;
                }
            }
        } else if (pointB - 1 >= 0 && pointA + 1 >= 10 && pointB + 1 < 10) {
            for (int i = -1; i < 1; i++) {
                for (int j = -1; j < 2; j++) {
                    if (field[pointA + i][pointB + j] != 0) return false;
                }
            }
        } else if (pointA - 1 >= 0 && pointB + 1 >= 10 && pointA + 1 < 10) {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 1; j++) {
                    if (field[pointA + i][pointB + j] != 0) return false;
                }
            }
        } else if (pointA - 1 < 0 && pointB - 1 < 0) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (field[pointA + i][pointB + j] != 0) return false;
                }
            }
        } else if (pointA + 1 >= 10 && pointB + 1 >= 10) {
            for (int i = -1; i < 1; i++) {
                for (int j = -1; j < 1; j++) {
                    if (field[pointA + i][pointB + j] != 0) return false;
                }
            }
        }
        return true;
    }

}
