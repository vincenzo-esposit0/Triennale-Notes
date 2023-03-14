#include  <stdio.h>
#include  <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>


  int 
     main (int argc, char **argv)
     {
	while (1){
		int childPid;
		char * cmdLine;

	        printPrompt();

	        cmdLine= readCommandLine(); //or GNU readline("");
		
		cmd = parseCommand(cmdLine);

		record command in history list (GNU readline history ?)
 
		if ( isBuiltInCommand(cmd)){
		    executeBuiltInCommand(cmd);
		} else {		
		     childPid = fork();
		     if (childPid == 0){
			executeCommand(cmd); //calls execvp  
			
		     } else {
			if (isBackgroundJob(cmd)){
			        record in list of background jobs
			} else {
				waitpid (childPid);

			}		
		    }
	        }
     
