package org.example.day06;

import java.util.List;

public class Guard
{
    public Coordinates currentPosition;
    public Direction direction;

    public Guard(Coordinates currentPosition)
    {
        this.currentPosition = currentPosition;
        this.direction = Direction.UP;
    }

    public void move(List<List<Character>> board)
    {
        switch (direction) {
            case UP -> moveUp(board);
            case RIGHT -> moveRight(board);
            case DOWN -> moveDown(board);
            case LEFT -> moveLeft(board);
        }
    }
    

    public void moveUp(List<List<Character>> board)
    {
        for (int i = currentPosition.y(); i >= 0; i--) {
            board.get(i).set(currentPosition.x(), 'X');

            var nextCoordinates = new Coordinates(currentPosition.x(), i - 1);
            
            if (nextCoordinates.isObstruction(board)) {
                this.direction = direction.rotateRight('^');
                break;
            } else {
                this.currentPosition = nextCoordinates;
            }
        }
    }

    public void moveRight(List<List<Character>> board)
    {
        for(int i = currentPosition.x(); i < board.getFirst().size(); i++) {
            board.get(currentPosition.y()).set(i, 'X');

            var nextCoordinates = new Coordinates(i + 1, currentPosition.y());

            if (nextCoordinates.isObstruction(board)) {
                this.direction = direction.rotateRight('>');
                break;
            } else {
                this.currentPosition = nextCoordinates;
            }
        }

    }

    public void moveDown(List<List<Character>> board)
    {
        for (int i = currentPosition.y(); i < board.size(); i++) {
            board.get(i).set(currentPosition.x(), 'X');

            var nextCoordinates = new Coordinates(currentPosition.x(), i + 1);

            if (nextCoordinates.isObstruction(board)) {
                this.direction = direction.rotateRight('v');
                break;
            } else {
                this.currentPosition = nextCoordinates;
            }
        }

    }

    public void moveLeft(List<List<Character>> board)
    {
        for(int i = currentPosition.x(); i >= 0; i--) {
            board.get(currentPosition.y()).set(i, 'X');

            var nextCoordinates = new Coordinates(i - 1, currentPosition.y());
            if (nextCoordinates.isObstruction(board)) {
                this.direction = direction.rotateRight('<');
                break;
            } else {
                this.currentPosition = nextCoordinates;
            }
            
        }
    }

}
