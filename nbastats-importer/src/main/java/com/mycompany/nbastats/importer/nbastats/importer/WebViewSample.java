package com.mycompany.nbastats.importer.nbastats.importer;

import org.w3c.dom.html.HTMLCollection;

import com.sun.webkit.dom.HTMLDocumentImpl;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;
 
public class WebViewSample extends Application {
    private Scene scene;
    @Override public void start(Stage stage) {
        // create the scene
        stage.setTitle("Web View");
        scene = new Scene(new Browser(),750,500, Color.web("#666970"));
        stage.setScene(scene);
        scene.getStylesheets().add("webviewsample/BrowserToolbar.css");        
        stage.show();
    }
 
    public static void main(String[] args){
        launch(args);
    }
}
class Browser extends Region {
 
    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();
     
    public Browser() {
        //apply the styles
        getStyleClass().add("browser");
        
        webEngine.getLoadWorker().stateProperty().addListener(
            new ChangeListener<State>() {
              @Override public void changed(ObservableValue ov, State oldState, State newState) {
                  if (newState == Worker.State.SUCCEEDED) {
                    printResults();
                  }
              }
        });
        
        // load the web page
//        webEngine.load("http://www.basketball-reference.com/boxscores/index.cgi?month=3&day=10&year=2016");
        webEngine.load("https://www.basketball-reference.com/boxscoes/index.cgi?month=8&dy=10&year=2016");
        //add the web view to the scene
        
//        webEngine.documentProperty().addListener((observable, oldDoc, newDoc) -> {
//            HTMLDocumentImpl realMcCoy = (HTMLDocumentImpl) newDoc;
//            realMcCoy.setOnmousemove(event -> {
//                MouseEvent expertMouser = (MouseEvent) event;
//                
//            });
//        });
        
        getChildren().add(browser);
        
        
        
 
    }
    private Node createSpacer() {
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        return spacer;
    }
 
    @Override protected void layoutChildren() {
        double w = getWidth();
        double h = getHeight();
        layoutInArea(browser,0,0,w,h,0, HPos.CENTER, VPos.CENTER);
    }
 
    @Override protected double computePrefWidth(double height) {
        return 750;
    }
 
    @Override protected double computePrefHeight(double width) {
        return 500;
    }
    
    private void printResults() {
//    	JSObject result = (JSObject)webEngine.executeScript("document.getElementsByClassName('game_summary')");
//        System.out.println(result);
//        System.out.println(result.getMember("value"));
        
    	System.out.println(webEngine.getDocument().getBaseURI());
        Object collectionHtml = webEngine.executeScript("document.getElementsByClassName('game_summary')[0].getElementsByClassName('right')[0].innerHTML");
        System.out.println(collectionHtml);
        
//        for(int i=0; i!=-1; i++) {
//        	try {
//        		System.out.println(result.getSlot(i));
//        	} catch(Exception e) {
//        		e.printStackTrace();
//        		i=-1;
//        	}
//        }
    }
}