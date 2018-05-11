import java.io.IOException;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


//Univerzalis dialog
public class DialogBox {
	private static int cwh = 0;
	private static ListView<String> list;
	
	public static int display(String title, String message) throws IOException {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		Button button = new Button("Submit");
		
		
		if(title.equals("New Game")) {

			list = new ListView<String>();
			
			for(int i= 0; i < Game.ShowWHs(); i++) {
				list.getItems().add("WareHouse - "+i);
			}
			
			list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			
			button.setOnAction(e -> {
					String[] temp = list.getSelectionModel().getSelectedItem().split(" ");
					cwh = Integer.parseInt(temp[2]);
					window.close();
					
			});
			
			VBox layout = new VBox(20);
			layout.setPadding(new Insets(20,20,20,20));
			layout.getChildren().addAll(list,button);
			
			Scene scene = new Scene(layout,300,250);
			window.setScene(scene);
			window.showAndWait();
			
			
		}
		
		
		else if(title.equals("Worker Number")) {
			list = new ListView<String>();
			
			list.getItems().addAll("1 player", "2 player", "3 player");
			list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			
			button.setOnAction(e -> {
				try {
				String[] temp = list.getSelectionModel().getSelectedItem().split(" ");
				int nw = Integer.parseInt(temp[0]);
				
				for(int i = 0; i<nw; i++) {
					Worker w;
					
						w = new Worker(i+1 + ". Player",5);
						Game.getCurrentWH().AddWorker(w, 1, i+1);
					
				}
				window.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			}
		});
		
			VBox layout = new VBox(20);
			layout.setPadding(new Insets(20,20,20,20));
			layout.getChildren().addAll(list,button);
			
			Scene scene = new Scene(layout,300,250);
			window.setScene(scene);
			window.showAndWait();
		 
		}
		
		return cwh;


		
	}


}
