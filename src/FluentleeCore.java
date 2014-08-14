import java.io.IOException;
import java.util.Observable;

import fluentlee.controller.ExecuteController;


public class FluentleeCore extends Observable {

	public void CoreInit(){
		System.out.println("core initializing...");
		ExecuteController xc = new ExecuteController();
		xc.executor("notepad");

	}
	
}
