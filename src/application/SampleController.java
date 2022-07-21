package application;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
//import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
//import javafx.stage.Stage;
//import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.control.SplitPane;
import javafx.event.ActionEvent;

public class SampleController {
	
	@FXML
    private Button solve;
	
	@FXML 
	private Button clear ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea n00;

    @FXML
    private TextArea n10;

    @FXML
    private TextArea n20;

    @FXML
    private TextArea n30;

    @FXML
    private TextArea n40;

    @FXML
    private TextArea n50;

    @FXML
    private TextArea n60;

    @FXML
    private TextArea n70;

    @FXML
    private TextArea n80;

    @FXML
    private TextArea n01;

    @FXML
    private TextArea n11;

    @FXML
    private TextArea n21;

    @FXML
    private TextArea n31;

    @FXML
    private TextArea n41;

    @FXML
    private TextArea n51;

    @FXML
    private TextArea n61;

    @FXML
    private TextArea n71;

    @FXML
    private TextArea n81;

    @FXML
    private TextArea n02;

    @FXML
    private TextArea n12;

    @FXML
    private TextArea n22;

    @FXML
    private TextArea n32;

    @FXML
    private TextArea n42;

    @FXML
    private TextArea n52;

    @FXML
    private TextArea n62;

    @FXML
    private TextArea n72;

    @FXML
    private TextArea n82;

    @FXML
    private TextArea n03;

    @FXML
    private TextArea n13;

    @FXML
    private TextArea n23;

    @FXML
    private TextArea n33;

    @FXML
    private TextArea n43;

    @FXML
    private TextArea n53;

    @FXML
    private TextArea n63;

    @FXML
    private TextArea n73;

    @FXML
    private TextArea n83;

    @FXML
    private TextArea n04;

    @FXML
    private TextArea n14;

    @FXML
    private TextArea n24;

    @FXML
    private TextArea n34;

    @FXML
    private TextArea n44;

    @FXML
    private TextArea n54;

    @FXML
    private TextArea n64;

    @FXML
    private TextArea n74;

    @FXML
    private TextArea n84;

    @FXML
    private TextArea n05;

    @FXML
    private TextArea n15;

    @FXML
    private TextArea n25;

    @FXML
    private TextArea n35;

    @FXML
    private TextArea n45;

    @FXML
    private TextArea n55;

    @FXML
    private TextArea n65;

    @FXML
    private TextArea n75;

    @FXML
    private TextArea n85;

    @FXML
    private TextArea n06;

    @FXML
    private TextArea n16;

    @FXML
    private TextArea n26;

    @FXML
    private TextArea n36;

    @FXML
    private TextArea n46;

    @FXML
    private TextArea n56;

    @FXML
    private TextArea n66;

    @FXML
    private TextArea n76;

    @FXML
    private TextArea n86;

    @FXML
    private TextArea n07;

    @FXML
    private TextArea n17;

    @FXML
    private TextArea n27;

    @FXML
    private TextArea n37;

    @FXML
    private TextArea n47;

    @FXML
    private TextArea n57;

    @FXML
    private TextArea n67;

    @FXML
    private TextArea n77;

    @FXML
    private TextArea n87;

    @FXML
    private TextArea n08;

    @FXML
    private TextArea n18;

    @FXML
    private TextArea n28;

    @FXML
    private TextArea n38;

    @FXML
    private TextArea n48;

    @FXML
    private TextArea n58;

    @FXML
    private TextArea n68;

    @FXML
    private TextArea n78;

    @FXML
    private TextArea n88;
    
    @FXML
    private Text text;
    
    
    public static int[][] S_table = new int[9][9];
    public static boolean flag = true ;
	
    public static boolean onlyDigits(String str, int n)    {
        for (int i = 0; i < n; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    public static void printSudoku(int[][] array)    {
        for (int i = 0; i < array.length; i++)
        {
            if (i == 3 || i == 6 ) 
                System.out.println("------------------------------------");
            for (int j = 0; j < array[i].length; j++)
            {
                System.out.format("%-3s", array[i][j]);
                if (j == 2 || j == 5 || j == 8)
                    System.out.print(" | ");
            }           
            System.out.println();   
        }      
        System.out.println("------------------------------------");
    }
    
    public boolean isAllowed (int[][]array,int row, int col, int number){
    	
    	for(int i=0;i<9;i++){
            if(array[row][i]==number){                return false;            }
        }
    	
    	for(int i=0;i<9;i++){
            if(array[i][col]==number){                return false;            }
        }
    	
        int temprow = (row/3)*3;
        int tempcol = (col/3)*3;
        
        for (int i=0; i< 3; i++) {
        	for (int j=0; j<3 ;j++) {
        		if(array[temprow+i][tempcol+j]==number){                return false;            }
        	}
        }  
    	return true;
    }
    
    public boolean S_solve(int[][]array){ 	
    	for (int i = 0; i < 9; i++)
        {
    		for (int j = 0; j < 9; j++)
    		{
    			if (array[i][j] == 0)
    			{
    				for (int tmp = 1; tmp <= 9; tmp++)
    				{
    					if (isAllowed (array,i, j, tmp))
    					{
    						array[i][j] = tmp;
    						if (S_solve (array)) {return true;} else array[i][j] = 0 ;
    					}
    				} 
    				return false;	
    			}
    		}
        }
    	return true; 
    }
    
    public void show_results(int[][]arrayresult) {
    	String[] Results = new String[9];
    	
    	for (int i = 0 ; i<9 ;i++ ) {
    		
    			Results[i] = String.format("%5d %5d %5d|%5d %5d %5d|%5d %5d %5d|", arrayresult[i][0],arrayresult[i][1],arrayresult[i][2],arrayresult[i][3],
    					arrayresult[i][4],arrayresult[i][5],arrayresult[i][6],arrayresult[i][7],arrayresult[i][8]);
    	}
    	
    	String rs = "-------------------------------------------\n"+ Results[0]+ "\n" +Results[1] +"\n"+ Results[2]+"\n"
    			+ "-------------------------------------------\n"+ Results[3]+ "\n" +Results[4] +"\n"+ Results[5]+"\n"
    			+ "-------------------------------------------\n"+ Results[6]+ "\n" +Results[7] +"\n"+ Results[8]+"\n";
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Result.fxml"));
			AnchorPane root = loader.load() ; 
			
			SampleController2 result = loader .getController();
			result.setidResult(rs);
			
    		Scene scene = new Scene(root,300,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Stage newWindow = new Stage();
			newWindow.setScene(scene);
			newWindow.setTitle("The Solution");
			newWindow.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
    	
    } 
      
    @FXML
    void solve_action(ActionEvent event) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
    	String table[][] = {
    			
   		{n00.getText(), n10.getText(), n20.getText(), n30.getText(), n40.getText(), n50.getText(), n60.getText(), n70.getText(),n80.getText()},
   		{n01.getText(), n11.getText(), n21.getText(), n31.getText(), n41.getText(), n51.getText(), n61.getText(), n71.getText(),n81.getText()},
   		{n02.getText(), n12.getText(), n22.getText(), n32.getText(), n42.getText(), n52.getText(), n62.getText(), n72.getText(),n82.getText()},
   		{n03.getText(), n13.getText(), n23.getText(), n33.getText(), n43.getText(), n53.getText(), n63.getText(), n73.getText(),n83.getText()},
   		{n04.getText(), n14.getText(), n24.getText(), n34.getText(), n44.getText(), n54.getText(), n64.getText(), n74.getText(),n84.getText()},
   		{n05.getText(), n15.getText(), n25.getText(), n35.getText(), n45.getText(), n55.getText(), n65.getText(), n75.getText(),n85.getText()},
   		{n06.getText(), n16.getText(), n26.getText(), n36.getText(), n46.getText(), n56.getText(), n66.getText(), n76.getText(),n86.getText()},
   		{n07.getText(), n17.getText(), n27.getText(), n37.getText(), n47.getText(), n57.getText(), n67.getText(), n77.getText(),n87.getText()},
   		{n08.getText(), n18.getText(), n28.getText(), n38.getText(), n48.getText(), n58.getText(), n68.getText(), n78.getText(),n88.getText()},
   		
    	};
    	
    	
    	outer :for (int i = 0 ; i< 9;i++) {
    		for (int j = 0 ; j< 9;j++) {
    			
    			String var = table[i][j];
   			
    			//check if sudoku's cell is empty 
    			if (var=="") {
    				S_table[i][j]=0;
    				continue;
    			}
    			
    			//check if sudoku's cell contains only Digits 
    			if (onlyDigits(var, var.length())) {
    				S_table[i][j]= Integer.parseInt(var) ;}
    			else {
    				text.setText("Please fix the Sudoku , must contain only numbers.");
    				flag = false;
    				break outer;
    			}
   			  			
    			//check if sudoku's cell between 1-9
    			if ((S_table[i][j]>9) || (S_table[i][j]<0)) {
    				text.setText("Please fix the Sudoku , numbers must be from 1-9");
    				flag = false;
    				break outer;
    			}

    		}
    	}

    	if (flag) {
    		text.setText("We are solving the Sudoku ") ;
    		if (S_solve(S_table)) {
    			//printSudoku(S_table);
    			text.setText("All done");   			
    			show_results(S_table);
    		}
    		else {
    			text.setText("Cant be solved ");
    		}	
    	}
    }
    
    @FXML
    void clear_action(ActionEvent event) {
    	
    	n00.clear(); n10.clear(); n20.clear(); n30.clear(); n40.clear(); n50.clear(); n60.clear(); n70.clear();n80.clear();
 		n01.clear(); n11.clear(); n21.clear(); n31.clear(); n41.clear(); n51.clear(); n61.clear(); n71.clear();n81.clear();
   		n02.clear(); n12.clear(); n22.clear(); n32.clear(); n42.clear(); n52.clear(); n62.clear(); n72.clear();n82.clear();
   		n03.clear(); n13.clear(); n23.clear(); n33.clear(); n43.clear(); n53.clear(); n63.clear(); n73.clear();n83.clear();
   		n04.clear(); n14.clear(); n24.clear(); n34.clear(); n44.clear(); n54.clear(); n64.clear(); n74.clear();n84.clear();
   		n05.clear(); n15.clear(); n25.clear(); n35.clear(); n45.clear(); n55.clear(); n65.clear(); n75.clear();n85.clear();
   		n06.clear(); n16.clear(); n26.clear(); n36.clear(); n46.clear(); n56.clear(); n66.clear(); n76.clear();n86.clear();
   		n07.clear(); n17.clear(); n27.clear(); n37.clear(); n47.clear(); n57.clear(); n67.clear(); n77.clear();n87.clear();
   		n08.clear(); n18.clear(); n28.clear(); n38.clear(); n48.clear(); n58.clear(); n68.clear(); n78.clear();n88.clear();
   		
   		text.setText("All Clear ");
    }

    @FXML
    void initialize() {
//    	assert idResult != null : "fx:id=\"idResult\" was not injected: check your FXML file 'Result.fxml'.";
    	assert solve != null : "fx:id=\"solve\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n00 != null : "fx:id=\"n00\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n10 != null : "fx:id=\"n10\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n20 != null : "fx:id=\"n20\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n30 != null : "fx:id=\"n30\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n40 != null : "fx:id=\"n40\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n50 != null : "fx:id=\"n50\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n60 != null : "fx:id=\"n60\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n70 != null : "fx:id=\"n70\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n80 != null : "fx:id=\"n80\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n01 != null : "fx:id=\"n01\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n11 != null : "fx:id=\"n11\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n21 != null : "fx:id=\"n21\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n31 != null : "fx:id=\"n31\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n41 != null : "fx:id=\"n41\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n51 != null : "fx:id=\"n51\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n61 != null : "fx:id=\"n61\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n71 != null : "fx:id=\"n71\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n81 != null : "fx:id=\"n81\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n02 != null : "fx:id=\"n02\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n12 != null : "fx:id=\"n12\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n22 != null : "fx:id=\"n22\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n32 != null : "fx:id=\"n32\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n42 != null : "fx:id=\"n42\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n52 != null : "fx:id=\"n52\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n62 != null : "fx:id=\"n62\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n72 != null : "fx:id=\"n72\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n82 != null : "fx:id=\"n82\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n03 != null : "fx:id=\"n03\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n13 != null : "fx:id=\"n13\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n23 != null : "fx:id=\"n23\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n33 != null : "fx:id=\"n33\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n43 != null : "fx:id=\"n43\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n53 != null : "fx:id=\"n53\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n63 != null : "fx:id=\"n63\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n73 != null : "fx:id=\"n73\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n83 != null : "fx:id=\"n83\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n04 != null : "fx:id=\"n04\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n14 != null : "fx:id=\"n14\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n24 != null : "fx:id=\"n24\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n34 != null : "fx:id=\"n34\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n44 != null : "fx:id=\"n44\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n54 != null : "fx:id=\"n54\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n64 != null : "fx:id=\"n64\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n74 != null : "fx:id=\"n74\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n84 != null : "fx:id=\"n84\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n05 != null : "fx:id=\"n05\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n15 != null : "fx:id=\"n15\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n25 != null : "fx:id=\"n25\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n35 != null : "fx:id=\"n35\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n45 != null : "fx:id=\"n45\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n55 != null : "fx:id=\"n55\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n65 != null : "fx:id=\"n65\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n75 != null : "fx:id=\"n75\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n85 != null : "fx:id=\"n85\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n06 != null : "fx:id=\"n06\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n16 != null : "fx:id=\"n16\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n26 != null : "fx:id=\"n26\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n36 != null : "fx:id=\"n36\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n46 != null : "fx:id=\"n46\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n56 != null : "fx:id=\"n56\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n66 != null : "fx:id=\"n66\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n76 != null : "fx:id=\"n76\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n86 != null : "fx:id=\"n86\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n07 != null : "fx:id=\"n07\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n17 != null : "fx:id=\"n17\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n27 != null : "fx:id=\"n27\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n37 != null : "fx:id=\"n37\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n47 != null : "fx:id=\"n47\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n57 != null : "fx:id=\"n57\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n67 != null : "fx:id=\"n67\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n77 != null : "fx:id=\"n77\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n87 != null : "fx:id=\"n87\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n08 != null : "fx:id=\"n08\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n18 != null : "fx:id=\"n18\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n28 != null : "fx:id=\"n28\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n38 != null : "fx:id=\"n38\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n48 != null : "fx:id=\"n48\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n58 != null : "fx:id=\"n58\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n68 != null : "fx:id=\"n68\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n78 != null : "fx:id=\"n78\" was not injected: check your FXML file 'Sample.fxml'.";
        assert n88 != null : "fx:id=\"n88\" was not injected: check your FXML file 'Sample.fxml'.";

    }
}

