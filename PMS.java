/**
 * This class contains the main method and 
 * constructs the JFrame window
 */
package pms;
 

import javax.swing.JFrame;

/**
 * @author Ellen
 *
 */
public class PMS extends JFrame  {

  private static final long serialVersionUID = 1L;
	
	uiLoginPanel uiLoginPanelObj;
	uiMainMenuPanel uiMainMenuPanelObj;
	uiNewResPanel uiNewResPanelObj;
	uiDeleteResPanel uiDeleteResPanelObj;
	uiSearchResPanel uiSearchResPanelObj;
	uiShowAllResPanel uiShowAllResPanelObj;
	
	public void loginPanel(){ 
		uiLoginPanelObj = new uiLoginPanel();  
		this.add(uiLoginPanelObj); 
		uiLoginPanelObj.setVisible(true);
	}
	 
	public void mainMenuPanel(){ 
		uiMainMenuPanelObj = new uiMainMenuPanel(); 
		this.add(uiMainMenuPanelObj); 
		uiMainMenuPanelObj.setVisible(true);
	}
	
	public void newResPanel() {
		uiNewResPanelObj = new uiNewResPanel();
		this.add(uiNewResPanelObj);
		uiNewResPanelObj.setVisible(true);
	}
	
	public void deleteResPanel() {
		uiDeleteResPanelObj = new uiDeleteResPanel();
		this.add(uiDeleteResPanelObj);
		uiDeleteResPanelObj.setVisible(true);
	}
	
	public void searchResPanel() {
		uiSearchResPanelObj = new uiSearchResPanel();
		this.add(uiSearchResPanelObj);
		uiSearchResPanelObj.setVisible(true);
	}
	
	public void showAllResPanel() {
		uiShowAllResPanelObj = new uiShowAllResPanel();
		this.add(uiShowAllResPanelObj);
		uiShowAllResPanelObj.setVisible(true);
	}
	
	public PMS() { 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setTitle("Property Management System"); 
		setSize(1000, 700);
		  
	}

	public static void main(String[] args) {
 
		PMS window = new PMS(); 
		window.setVisible(true); 
		window.loginPanel();
	}
 
}
