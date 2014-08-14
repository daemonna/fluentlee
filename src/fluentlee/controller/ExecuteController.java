package fluentlee.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ExecuteController implements Observer {

	/**
	 * detect OS, replace shell values and execute command
	 * 
     * @param prog
     * @return 
	 */
	public int executor(String prog) {

		int exitv = 0;
		String osname = System.getProperty("os.name").toLowerCase();
		String[] cmd = new String[10];
                List<String> commandArgs = new ArrayList<>();

		switch (osname) {
		case "windows":
                    commandArgs.add("cmd");
                    commandArgs.add("/C");
                    break;
		case "mac":
		case "linux":
			commandArgs.add("/bin/bash");
                    commandArgs.add("-c");
			break;
		case "unix":
		case "sunos":
			commandArgs.add("/bin/sh");
                    commandArgs.add("-c");
			break;
		}
		
		commandArgs.add(prog);


		ProcessBuilder builder = new ProcessBuilder(commandArgs);
		Process p;
		try {
			p = builder.start();
			p.waitFor();
			exitv = p.exitValue();
		} catch (IOException | InterruptedException e) {
		}
		

		return exitv;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

}
