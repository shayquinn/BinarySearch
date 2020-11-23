

import java.util.ArrayList;

import java.util.Iterator;

import java.util.Random;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import javafx.scene.text.TextFlow;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class BinarySearch extends Application{
	
	public static int highNumber = 10000;
	public static int range = 10000;
	public static int lowNumber = 0;
	public static int key = 0;
	public static int[] ordered;
	public static int[] data;
	public static ArrayList<Integer>nums = new ArrayList<>();
	public static ArrayList<Integer>send = new ArrayList<>();
	public static ArrayList<Integer>send1 = new ArrayList<>();
	public static ArrayList<Integer>send2 = new ArrayList<>();
	public static ArrayList<Integer>high = new ArrayList<>();
	public static ArrayList<Integer>low = new ArrayList<>();
	public static String listToString = "";
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Serch");
	       primaryStage.setFullScreen(false);
	       primaryStage.centerOnScreen();
	      // primaryStage.setFullScreen(true);
	       Group root = new Group();
	       Scene scene = new Scene(root);
	       primaryStage.setScene(scene);
	       primaryStage.show();
	      
	       javafx.geometry.Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

	        //set Stage boundaries to visible bounds of the main screen
	       primaryStage.setX(primaryScreenBounds.getMinX());
	       primaryStage.setY(primaryScreenBounds.getMinY());
	       primaryStage.setWidth(primaryScreenBounds.getWidth());
	       primaryStage.setHeight(primaryScreenBounds.getHeight());

	       Pane p1 = new Pane();
	       p1.setMinWidth(primaryScreenBounds.getWidth());
	       p1.setMinHeight(primaryScreenBounds.getHeight());
	       p1.setStyle("-fx-background-color: black;");
	       Pane p2 = new Pane();
	       p2.setMinHeight(primaryScreenBounds.getWidth());
	       p2.setMinWidth(1364);
	       System.out.println(primaryScreenBounds.getWidth());
	       
	       
	       VBox v2 = new VBox();
	       v2.setTranslateX(10);
	       v2.setTranslateY(10);
	       v2.setTranslateY(20);
	       HBox hb1 = new HBox();
	       //TextField tf1 = new TextField();
	       //tf1.setMaxWidth(60);
	       Button b1 = new Button("Change");
	       b1.setMinWidth(60);
	       TextField tf2 = new TextField();
	       tf2.setMaxWidth(60);
	       Button b2 = new Button("Search");
	       b2.setMinWidth(60);
	       Button b3 = new Button("Center");
	       b3.setMinWidth(60);
	       TextFlow tflow1 = new TextFlow();
	      
	       tflow1.setStyle("-fx-background-color: black;");
	       tflow1.setMinHeight(50);
	       tflow1.setMinWidth(primaryScreenBounds.getWidth());
	       ScrollPane sc1 = new ScrollPane();
		   sc1.setContent(tflow1);
	       sc1.setPrefWidth(primaryScreenBounds.getWidth()-30);	
	       sc1.setTranslateY(10);
	   
	     
	       TextFlow tflow2 = new TextFlow();

	       tflow2.setStyle("-fx-background-color: black;");
	       tflow2.setMinHeight(700);
	       tflow2.setMinWidth(primaryScreenBounds.getWidth()-30);
	      
	       ScrollPane sc2 = new ScrollPane();
	       sc2.setContent(tflow2);
	       sc2.setTranslateY(10);
	       sc2.setPrefWidth(primaryScreenBounds.getWidth()-30);
	       sc2.setMinHeight(100);
	       sc2.setMaxHeight(primaryScreenBounds.getHeight()-160);
	    
	       sc2.setTranslateY(20);

	     
	       	       
	       root.getChildren().add(p1);
	       p1.getChildren().add(p2);
	       p2.getChildren().add(v2);
	       v2.getChildren().add(hb1);
	       //hb1.getChildren().add(tf1);
	       hb1.getChildren().add(b1);
	       hb1.getChildren().add(tf2);
	       hb1.getChildren().add(b2);
	       hb1.getChildren().add(b3);
	      
	       v2.getChildren().add(sc1);
	       v2.getChildren().add(sc2);
	     
		
			//BETWEEN 
			int length = BinarySearch.highNumber; int start = 1;
			//create a random array
			int[] nums = repeet(length, start);			
			Text t1 = new Text(arrayToString(nums)+"\n");
			t1.setFill(Color.WHITE);
			//Origins the the array
			BinarySearch.ordered = order(nums);			
			Text t2 = new Text(arrayToString(ordered)+"\n");
			t2.setFill(Color.LAWNGREEN);
			tflow1.getChildren().addAll(t1, t2);
			
			//Scroll listener
			sc1.hvalueProperty().addListener(new ChangeListener<Number>() {			
				@Override
				public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
					System.out.println("oldValue : "+oldValue.doubleValue()+", newValue : "+newValue.doubleValue());
					
				}
			});
			
		      b1.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						//if(!tf1.getText().trim().isEmpty()){
						//	BinarySearch.highNumber = Integer.parseInt(tf1.getText().toString());
						//	BinarySearch.range = Integer.parseInt(tf1.getText().toString());
						//}
						//BETWEEN 
						int length = BinarySearch.highNumber; int start = 1;
						//create a random array
						int[] nums = repeet(length, start);
						tflow1.getChildren().clear();
						Text t1 = new Text(arrayToString(nums)+"\n");
						t1.setFill(Color.WHITE);//System.out.println(arrayToString(nums)+"\n");
						//Origins the the array
						BinarySearch.ordered = order(nums);//System.out.println(arrayToString(ordered)+"\n");
						Text t2 = new Text(arrayToString(ordered)+"\n");
						t2.setFill(Color.LAWNGREEN);
						tflow1.getChildren().addAll(t1, t2);
						tflow2.getChildren().clear();
					}
				});
			
			
		b2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {				
				BinarySearch.data = BinarySearch.ordered;
				int key = Integer.parseInt(tf2.getText().toString());
				BinarySearch.key = key;
				int low = 0;
				int high = BinarySearch.ordered.length - 1;
				boolean bull = false;
				
			try{
								
				//((Object) sc1).getViewport().setViewPosition(new java.awt.Point(0, 0));
				
				while(bull == false){
					int middle = (low + high)/2;
					if(BinarySearch.data[middle] == key){
						int low1 = middle-1;
						int hig1 = middle+1;	
							low(low1+1);
							high(hig1-1);
							BinarySearch.send.add(data[middle]);
							Text t1l = new Text(it(BinarySearch.low));
							t1l.setFill(Color.WHITE);					
							Text t2l = new Text(it(BinarySearch.send));
							t2l.setFill(Color.RED);				
							Text t3l = new Text(it(BinarySearch.high)+"\n");
							t3l.setFill(Color.WHITE);
							Text t4l = new Text("\n");
							tflow2.getChildren().addAll(t1l, t2l, t3l, t4l);	
							BinarySearch.low.clear();
							BinarySearch.send.clear();
							BinarySearch.high.clear();		
						//System.out.println("L low Array"+BinarySearch.low.toString());
						//System.out.println("L point Array"+BinarySearch.send2.toString());
						//System.out.println("L high Array"+BinarySearch.high.toString());
						bull = true;
					}
					if(BinarySearch.data[middle] < key){//System.out.println("1 low "+BinarySearch.data[middle]+", low : "+low+", high : "+high);
						int one = high;;
						low = middle + 1;
						int two = low;	
						high(one);
						low(two);		
						for(int i=two+1;i<=one+1;i++){
							BinarySearch.send1.add(BinarySearch.data[i-1]);					
						}
						Text t1l = new Text(it(BinarySearch.low));
						t1l.setFill(Color.WHITE);	
						Text t2l = new Text(it(BinarySearch.send1));
						t2l.setFill(Color.LAWNGREEN);		
						Text t3l = new Text(it(BinarySearch.high)+"\n");
						t3l.setFill(Color.WHITE);
						tflow2.getChildren().addAll(t1l, t2l, t3l);
						//System.out.println("Low array"+send1+" Middle "+data[middle]);
						//System.out.println("H low Array"+BinarySearch.low.toString());
						//System.out.println("H point Array"+BinarySearch.send1.toString());
						//System.out.println("H high Array"+BinarySearch.high.toString());
						//System.out.println("============================================================");
						BinarySearch.low.clear();
						BinarySearch.send1.clear();
						BinarySearch.high.clear();
						//System.out.println("2 low "+data[middle]+", low : "+low+", high : "+high);	
					}
					if(BinarySearch.data[middle] > key){ //System.out.println("1 high "+data[middle]+", low : "+low+", high : "+high);
						int one = high;;
						high = middle - 1;
						int two = high;				
						high(one);
						low(two);						
						for(int i=two+1;i<=one+1;i++){
							BinarySearch.send2.add(BinarySearch.data[i-1]);					
						}	
						//System.out.println("2 high "+BinarySearch.data[middle]+", low : "+low+", high : "+high);
						Text t1l = new Text(it(BinarySearch.low));
						t1l.setFill(Color.WHITE);		
						Text t2l = new Text(it(BinarySearch.send2));
						t2l.setFill(Color.LAWNGREEN);	
						Text t3l = new Text(it(BinarySearch.high)+"\n");
						t3l.setFill(Color.WHITE);
						tflow2.getChildren().addAll(t1l, t2l, t3l);
						//System.out.println("High array "+send2+" Middle "+data[middle]);
						
						//System.out.println("L low Array"+BinarySearch.low.toString());
						//System.out.println("L point Array"+BinarySearch.send2.toString());
						//System.out.println("L high Array"+BinarySearch.high.toString());
						//System.out.println("==================================================");
						BinarySearch.low.clear();
						BinarySearch.send2.clear();
						BinarySearch.high.clear();
					}
				}
	
			}catch(Exception er){
				System.out.println("Error : "+er);}	
			
			}


			//turn array list to string
			public String it(ArrayList<Integer> low) {
				Iterator<Integer> it = low.iterator();
				StringBuilder sb = new StringBuilder();
				while(it.hasNext()){
					sb.append(it.next()+", ");
				}
				 BinarySearch.listToString = sb.toString();				 
				 return BinarySearch.listToString;	
			}
			//create lower array list
			private void low(int two) {
				for(int i=0;i<two;i++){
					BinarySearch.low.add(BinarySearch.data[i]);
				}				
			}
			//create higher array list
			private void high(int one) {								
				for(int i=one+1;i<BinarySearch.highNumber;i++){
					BinarySearch.high.add(BinarySearch.data[i]);		
				}//System.out.println("one == "+one+", count ="+count);
			}
		});
		
	b3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				try{					
					sc2.setHvalue(center());
					sc1.setHvalue(center());	
				}catch(Exception e){System.out.println("Error : "+e);}
							
				
			}
			//scroll to point
			private double center() {
				double newPoint = 0;
				try{
					int[]intArray= new int[BinarySearch.range];
					String str = "";
					String si = "";
					double point = 0;
					
					int i;
						for(i=1;i<=BinarySearch.range;i++){
							intArray[i-1] = i;
							str = str+i;
							si =  ""+i;
							if(i<=BinarySearch.key){
								point = point+si.length();
							}
							System.out.println("si : "+si.length()+", I : "+i);
						}	
				int strlength = str.length();
				double newOne = 1.0/strlength;
				 newPoint = newOne*point;
				
					
				}catch(Exception e){System.out.println("Error : "+e);}
				return newPoint;				
			}
		});
	}
	
	

		public String arrayToString(int[] nums2) {
			StringBuilder builder = new StringBuilder();
			for (int value : nums2) {
			    builder.append(value+", ");
			}
			String text = builder.toString();
			return text;
	}

		//Origins
		private static int[] order(int[] nums) {
			int[] numbers = new int[nums.length];
			for(int i=0;i<nums.length;i++){
				int low = lo(nums, nums[i]);
				numbers[low]=nums[i];}
			return numbers;
		}
		private static int lo(int[] nums, int one) {
			int low = 0;
			for(int i=0;i<nums.length;i++){
				if(one > nums[i]){
					low = low+1; 
					}
				}
			return low;
		}

		//create random ARRAY
		private static int[] repeet(int le, int st) {
			int[]array= new int[le];
			for(int i=0;i<array.length;i++){
				array[i] = rand(le, st);
				for(int j=0;j<i;j++){
					if(array[i] == array[j]){
						i--;
					}			
				}						
			}
			return array;			
		}	
		private static int rand(int le, int st) {
			Random rand = new Random();
			int ran = rand.nextInt(BinarySearch.range - st + st)+st;
			return ran;
		}
}
