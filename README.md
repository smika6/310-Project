# 310-Project
The Project is due on November 30, 2020.

## Authors
Cheng Xiong  
Jacob Hopkins  
Ty Heckenlaible  ?

### TODO
11/14 - Coordinate who what work there is to be done  
11/14 - Assign roles to team  
11/14 - Designate tasks to team members  


### Example of inputing values for the code:

#### **THIS IS PROVIDING VALID COMMAND LINE PARAMETERS**
PS C:\Users\smika\Documents\GitHub\310-Project>  & 'c:\Users\smika\.vscode\extensions\vscjava.vscode-java-debug-0.27.1\scripts\launcher.bat' 'C:\Program Files\Java\jdk-15.0.1\bin\java.exe' '--enable-preview' '-XX:+ShowCodeDetailsInExceptionMessages' '-Dfile.encoding=UTF-8' '-cp' 'C:\Users\smika\AppData\Roaming\Code\User\workspaceStorage\08ddb6427ae7f211ffad04aec8b6a4da\redhat.java\jdt_ws\310-Project_1d541192\bin' 'BankersAlgorithmDriver'  4 5  

[INFO]: Running Simulation with 4 recource(s) and 5 thread(s).

#### **THIS IS PROVIDING INVALID COMMAND LINE PARAMETERS**
PS C:\Users\smika\Documents\GitHub\310-Project>  & 'c:\Users\smika\.vscode\extensions\vscjava.vscode-java-debug-0.27.1\scripts\launcher.bat' 'C:\Program Files\Java\jdk-15.0.1\bin\java.exe' '--enable-preview' '-XX:+ShowCodeDetailsInExceptionMessages' '-Dfile.encoding=UTF-8' '-cp' 'C:\Users\smika\AppData\Roaming\Code\User\workspaceStorage\08ddb6427ae7f211ffad04aec8b6a4da\redhat.java\jdt_ws\310-Project_1d541192\bin' 'BankersAlgorithmDriver'  0 11  
[ERROR]: Invalid input for count of resources: 0, value must be between 1 and 10.  
[ERROR]: Invalid input for count of threads: 11, value must be between 1 and 10.  
[ERROR]: Invalid parameters provided. Exiting...  


#### **THIS IS PROVIDING NO COMMAND LINE PARAMETERS AND USING A SCANNER w/ VALID & INVALID INPUTS**
PS C:\Users\smika\Documents\GitHub\310-Project>  & 'c:\Users\smika\.vscode\extensions\vscjava.vscode-java-debug-0.27.1\scripts\launcher.bat' 'C:\Program Files\Java\jdk-15.0.1\bin\java.exe' '--enable-preview' '-XX:+ShowCodeDe  
[REQUEST]: Input the number of recource types (1-10): 0  
[REQUEST]: Input the number of recource types (1-10): 11  
[REQUEST]: Input the number of recource types (1-10): 5  
[REQUEST]: Input the number of threads (1-10): 0  
[REQUEST]: Input the number of threads (1-10): 15  
[REQUEST]: Input the number of threads (1-10): 5  

[INFO]: Running Simulation with 5 recource(s) and 5 thread(s).  

