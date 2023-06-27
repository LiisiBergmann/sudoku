package application;

import javafx.animation.Animation;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;
import javafx.event.Event;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML Button button_one;
    @FXML Button button_two;
    @FXML Button button_three;
    @FXML Button button_four;
    @FXML Button button_five;
    @FXML Button button_six;
    @FXML Button button_seven;
    @FXML Button button_eight;
    @FXML Button button_nine;
    @FXML Canvas tulemus;
    @FXML Canvas canvas;
    @FXML Button button_clear;
    @FXML Button button_kontroll;
    @FXML Button button_kerge;
    @FXML Button button_keskmine;
    @FXML Button button_raske;
    @FXML  Button time;
    int player_selected_row;
    int player_selected_col;

    GameBoard gameboard;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        GraphicsContext context = canvas.getGraphicsContext2D();
        GraphicsContext result = tulemus.getGraphicsContext2D();
        result.clearRect(0, 0, 300, 200);
        context.clearRect(0, 0, 450, 450);
    }
     // Joonestab kõik välja

    public void drawOnCanvas(GraphicsContext context) {
        context.clearRect(0, 0, 450, 450);
        context.setStroke(Color.BLACK);
        context.setLineWidth(3);
        context.strokeLine(0,150,450,150);
        context.strokeLine(0,300,450,300);
        context.strokeLine(150,0,150,450);
        context.strokeLine(300,0,300,450);

        // Joonistab väiksed kastid
        for(int row = 0; row<9; row++) {
            for(int col = 0; col<9; col++) {
                int position_y = row * 50 + 2;
                int position_x = col * 50 + 2;
                int width = 46;
                context.setFill(Color.WHITE);
                context.fillRoundRect(position_x, position_y, width, width, 10, 10);
            }


            context.setStroke(Color.RED);
            context.setLineWidth(5);
            context.strokeRoundRect(player_selected_col * 50 + 2, player_selected_row * 50 + 2, 46, 46, 10, 10);

        }


        // see joonistab väljadele enne mängimist numbrid

        int[][] initial = gameboard.getInitial();
        for(int row = 0; row<9; row++) {
            for(int col = 0; col<9; col++) {

                int position_y = row * 50 + 35;

                int position_x = col * 50 + 17;

                context.setFill(Color.BLACK);

                context.setFont(new Font("arial black", 30));
                if(initial[row][col]!=0) {

                    context.fillText(initial[row][col] + "", position_x, position_y);
                }
            }
        }

       //  joonistab sulle selle numbri, mida sa just valisid

        int[][] player = gameboard.getPlayer();
        for(int row = 0; row<9; row++) {
            for(int col = 0; col<9; col++) {
                int position_y = row * 50 + 35;
                int position_x = col * 50 + 17;
                context.setFill(Color.PURPLE);
                context.setFont(new Font("arial black", 30));
                if(player[row][col]!=0) {
                    context.fillText(player[row][col] + "", position_x, position_y);
                }
            }
        }
    }
    public void canvasMouseClicked() {
        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int mouse_x = (int) event.getX();
                int mouse_y = (int) event.getY();

                player_selected_row = (int) (mouse_y / 50);
                player_selected_col = (int) (mouse_x / 50);

                drawOnCanvas(canvas.getGraphicsContext2D());
            }
        });
    }


    public void buttonOnePressed() {
        gameboard.modifyPlayer(1, player_selected_row, player_selected_col);
        drawOnCanvas(canvas.getGraphicsContext2D());
    }
    public void buttonTwoPressed() {
        gameboard.modifyPlayer(2, player_selected_row, player_selected_col);
        drawOnCanvas(canvas.getGraphicsContext2D());
    }

    public void buttonThreePressed() {
        gameboard.modifyPlayer(3, player_selected_row, player_selected_col);
        drawOnCanvas(canvas.getGraphicsContext2D());
    }

    public void buttonFourPressed() {
        gameboard.modifyPlayer(4, player_selected_row, player_selected_col);
        drawOnCanvas(canvas.getGraphicsContext2D());
    }

    public void buttonFivePressed() {
        gameboard.modifyPlayer(5, player_selected_row, player_selected_col);
        drawOnCanvas(canvas.getGraphicsContext2D());
    }

    public void buttonSixPressed() {
        gameboard.modifyPlayer(6, player_selected_row, player_selected_col);
        drawOnCanvas(canvas.getGraphicsContext2D());
    }

    public void buttonSevenPressed() {
        gameboard.modifyPlayer(7, player_selected_row, player_selected_col);
        drawOnCanvas(canvas.getGraphicsContext2D());
    }

    public void buttonEightPressed() {
        gameboard.modifyPlayer(8, player_selected_row, player_selected_col);
        drawOnCanvas(canvas.getGraphicsContext2D());
    }

    public void buttonNinePressed() {
        gameboard.modifyPlayer(9, player_selected_row, player_selected_col);
        drawOnCanvas(canvas.getGraphicsContext2D());
    }
    public void Clear() {
        gameboard.modifyPlayer(0, player_selected_row, player_selected_col);
        drawOnCanvas(canvas.getGraphicsContext2D());}
    public void kontroll(){
        Tulemus(tulemus.getGraphicsContext2D(), canvas.getGraphicsContext2D());
    }public void loo_kerge(){
        gameboard = new GameBoard("kerge");
        drawOnCanvas(canvas.getGraphicsContext2D());
    }
    public void loo_keskmine(){
        gameboard = new GameBoard("keskmine");
        drawOnCanvas(canvas.getGraphicsContext2D());}
    public void loo_raske(){
        gameboard = new GameBoard("raske");
        drawOnCanvas(canvas.getGraphicsContext2D());
    }

    public void Tulemus(GraphicsContext result, GraphicsContext context){
        result.setFont(new Font(20));
        if(gameboard.checkForSuccess() == true) {
            context.clearRect(0, 0, 450, 450);
            result.clearRect(0,0,300,200);
            result.setFill(Color.GREEN);
            result.setFont(new Font(36));
            result.fillText("Õige!", 100, 150);
        }
        if(gameboard.checkForSuccess() == false) {
            context.clearRect(0, 0, 450, 450);
            result.clearRect(0,0,300,200);
            result.setFill(Color.RED);
            result.setFont(new Font(36));
            result.fillText("Vale!", 100, 150);
        }
    }


}
