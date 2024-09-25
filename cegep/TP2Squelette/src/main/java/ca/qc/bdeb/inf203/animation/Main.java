package ca.qc.bdeb.inf203.animation;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Main extends Application {
    public static final double WIDTH = 640, HEIGHT = 480;


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.getIcons().add(new Image("squelette.png"));
        var root = new Pane();
        var root2 = new VBox();
        var sceneDeJeu = new Scene(root, WIDTH, HEIGHT);
        var menu = new Scene(root2, WIDTH, HEIGHT);
        var vbox = new VBox();
        var vbox2 = new VBox();
        ImageView logo = new ImageView("logo.png");
        logo.fitHeightProperty();
        logo.fitWidthProperty();
        root2.getChildren().add(logo);

        Button jouer = new Button("Jouer");
        Button information = new Button("Info");
        jouer.setOnAction((e) -> {
            primaryStage.setScene(sceneDeJeu);
            Partie partie = new Partie();
        });


        vbox.getChildren().add(jouer);
        vbox.getChildren().add(information);
        vbox2.getChildren().add(vbox);
        vbox.setAlignment(Pos.CENTER);
        vbox2.setAlignment(Pos.CENTER);
        root2.getChildren().add(vbox2);
        menu.setFill(Color.BLACK);
        root2.setStyle("-fx-background-color: #000000;");


        var root3 = new VBox();
        var info = new Scene(root3, WIDTH, HEIGHT);
        information.setOnAction((e) -> {
            primaryStage.setScene(info);
            genererInfo(root3, primaryStage, menu);
        });


        var canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);
        var context = canvas.getGraphicsContext2D();
        Partie partie = new Partie();

        var timer = new AnimationTimer() {
            //delta temps entre les animations
            long lastTime = System.nanoTime();
            //temps depuis le début de l'animation
            long startTime = System.nanoTime();
//TODO:METTRE TOUS LES OBJETS ET LA LOGIQUE DANS LA CLASSE PARTIE


            @Override
            public void handle(long now) {


                double deltaTemps = (now - lastTime) * 1e-9;
                double deltaTimeDepart = (now - startTime);
                context.setFill(Color.rgb(0, 0, 0));
                context.fillRect(0, 0, WIDTH, HEIGHT);
                partie.jouer(deltaTemps, deltaTimeDepart, context);
                lastTime = now;
                startTime += 1;


            }
        };
        timer.start();
        primaryStage.setScene(menu);
        menu.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                Platform.exit();
            }
        });
        sceneDeJeu.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                primaryStage.setScene(menu);
            } else {
                Input.setKeyPressed(event.getCode(), true);
            }
        });
        info.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                primaryStage.setScene(menu);
            }
        });
        sceneDeJeu.setOnKeyReleased((e) -> {
            Input.setKeyPressed(e.getCode(), false);
        });

        primaryStage.setTitle("Squelette Espiegle");
        primaryStage.show();

    }


    /**
     * Méthode qui génère la scène d'information
     *
     * @param root3        vbox dans lequel sont écrites nos informations
     * @param primaryStage
     * @param menu         Notre scène principale
     */
    public void genererInfo(VBox root3, Stage primaryStage, Scene menu) {
        Text infoLigne1 = new Text("Squelette Espiègle");
        var hboxInfoLigne1 = new HBox();
        Text infoLigne2_1 = new Text("Par ");
        Text infoLigne2_2 = new Text("Jean Gael Doffou");
        var hboxInfoLigne2 = new HBox();
        Text infoLigne2_3 = new Text("Et ");
        Text infoLigne2_4 = new Text("M'hamed Battioui");
        Text infoLigne3 = new Text("Travail remis à Nicolas Hurtubise. Graphiques adaptés de\n" +
                "https://game-icons.net/. Développé dans le cadre du cours 420-203-RE -\n" +
                "Développement de programmes dans un environnement graphique, au\n" +
                "Collège de Bois-de-Boulogne.");
        infoLigne1.setFont(Font.font(45));
        infoLigne2_1.setFont(Font.font(25));
        infoLigne2_2.setFont(Font.font(30));
        infoLigne2_3.setFont(Font.font(25));
        infoLigne2_4.setFont(Font.font(30));
        infoLigne3.setFont(Font.font(15));
        infoLigne2_2.setFill(ImageHelpers.couleurAuHasard());
        infoLigne2_4.setFill(ImageHelpers.couleurAuHasard());
        hboxInfoLigne1.getChildren().add(infoLigne2_1);
        hboxInfoLigne1.getChildren().add(infoLigne2_2);
        hboxInfoLigne2.getChildren().add(infoLigne2_3);
        hboxInfoLigne2.getChildren().add(infoLigne2_4);
        hboxInfoLigne1.setAlignment(Pos.CENTER);
        hboxInfoLigne2.setAlignment(Pos.CENTER);
        root3.getChildren().add(infoLigne1);
        root3.getChildren().add(hboxInfoLigne1);
        root3.getChildren().add(hboxInfoLigne2);
        root3.getChildren().add(infoLigne3);

        Button retour = new Button("Retour");
        retour.setOnAction((e) -> {
            primaryStage.setScene(menu);
            infoLigne2_2.setFill(ImageHelpers.couleurAuHasard());
            infoLigne2_4.setFill(ImageHelpers.couleurAuHasard());
            root3.getChildren().setAll();
        });
        root3.getChildren().add(retour);
        root3.setAlignment(Pos.CENTER);
    }

}